var cliente;
var array_detalle_venta = [];
$(document).ready(function() {

	$('#tablaDetalle').DataTable({
	   	 "language": { "url": context + "/plugins/datatables/Spanish.json"},
	     responsive: true,
	     "searching": false
		});
	
	//$('.datepicker').datepicker()
	$(".select2").select2();
	$(".editable").attr('disabled', true)
	
	$('.numerico').priceFormat({
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '.',
		centsLimit : 0,

	});
	
	$("#fecha").focus();
	$('#fecha').daterangepicker({
    	format: 'DD/MM/YYYY',
        startDate:  moment().startOf('month'),
      //  startDate:  moment(),
        endDate: moment(),
        maxDate: moment(),
        dateLimit: { days: 90 },
        showDropdowns: true,
        opens: 'right',
        drops: 'down',
        buttonClasses: ['btn', 'btn-sm'],
        applyClass: 'btn-primary',
        cancelClass: 'btn-default',
        separator: ' - ',
        locale: {
            applyLabel: 'Aceptar',
            cancelLabel: 'Cancelar',
            fromLabel: 'Desde',
            toLabel: 'Hasta',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Do', 'Lu', 'Ma', 'Mie', 'Ju', 'Vi','Sa'],
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            firstDay: 1
        }
    	
    });
	
	//buscar al entrar en la pagina
	if(inputRequired($( "#fecha")) == 0){	
		  fechadesde = $('#fecha').data('daterangepicker').startDate.format('YYYY-MM-DD HH:mm');
		  fechahasta = $('#fecha').data('daterangepicker').endDate.format("YYYY-MM-DD HH:mm");
		buscar(fechadesde, fechahasta, $('#cliente').val())
	}
	
	$("#btnBuscar" ).click(function() {
		if(inputRequired($( "#fecha")) == 0){	
			  fechadesde = $('#fecha').data('daterangepicker').startDate.format('YYYY-MM-DD HH:mm');
			  fechahasta = $('#fecha').data('daterangepicker').endDate.format("YYYY-MM-DD HH:mm");
			buscar(fechadesde, fechahasta, $('#cliente').val())
		}
	});
	
$("#btnNuevo").click(function() {
		
		$(".editable").attr('disabled', false)
		$("#btnNuevo").attr('disabled', true)
		$("#btnGrabar").attr('disabled', false)
		$("#nrodoc").focus()
		
	});
	
});

//Vuelve a poblar la tabla
function reloadTables(){
	$('#tablaDetalle').DataTable().clear().draw();
	$("#tablaDetalleVenta > tbody").html("");

}

function buscar(fechadesde, fechahasta, cliente){
	
	reloadTables()
	$.blockUI({css : {
		border : 'none',
		padding : '15px',
		backgroundColor : '#000',
		'-webkit-border-radius' : '10px',
		'-moz-border-radius' : '10px',
		opacity : .5,
		color : '#fff'
	},
		message : '<h4><img src="'
					+ context
					+ '/dist/img/busy.gif" /> Procesando...</h4>'
	});
	$.ajax({
		type : "GET",
		url : context + "/api/v1/envio/find-by-params",
		data: { cliente: cliente, fechadesde: fechadesde, fechahasta : fechahasta },
		timeout: 600000,
		success : function(data) {
			console.log(data)
			data = JSON.stringify(data);
			var jsonobject = JSON.parse(data);

			
			if(jsonobject.length > 0){
				$("#resultado").removeClass('hidden');
				$("#ajax-loader").hide();
				$.each(jsonobject, function(index, element) {
					var tot = 0;
					for (var i = 0; i < element.detalles.length; i++) {
						tot += element.detalles[i].montoTotal
					}
					var detalleVenta = JSON.stringify(element.detalles);
					array_detalle_venta.push(detalleVenta)
					$('#tablaDetalle').DataTable().rows.add([{
						"0": index +1,
						"1": element.clienteRemitente.persona.nombres + " " + element.clienteRemitente.persona.  apellidos,
						"2": element.clienteDestinatario.persona.nombres + " " + element.clienteDestinatario.persona.  apellidos,
						"3": moment(element.fechaEnvio).format('DD/MM/YYYY'),
						"4": element.paisDestino.descripcion,
						"5": numeral(tot).format('0,0'),
						"6": '<a data-toggle="modal" href="#modalDetalleEnvio" onclick="setDetalleVenta('+index+')">Ver Detalles</a>',
						"7": "<td style='text-align: center;'><button type='button' class='btn btn-w-m btn-success' onclick='procesar("+JSON.stringify(element)+",0)'>Procesar</button>&nbsp;<button type='button' class='btn btn-w-m btn-danger' onclick='procesar("+JSON.stringify(element)+",1)'>Anular</button></td></td>\n",
						"8": JSON.stringify(element)
					}]).draw();
					
					
					
				});
				
			}else{
				
				alertify.alert("Atenci&oacute;n","No se encontraron coincidencias" , function(){});
			}
			
		},
		error: function(e) {
			console.log(e)
			alertify.errorAlert("Ha ocurrido un error, favor intente mas tarde");
			$('.spinner').toggleClass('sk-loading');
		},
		done: function(e) {
			console.log("DONE");
		}
	});
	
	$(document).ajaxStop($.unblockUI);
	
	
}

function procesar(element, n){
	var msj= "Desea procesar";
	var ok= "Procesar";
	
	var cabecera = {};
	cabecera.idEnvio = element.idEnvio 
	cabecera.estado ="L";
	cabecera.entregado = "S"
	if(n == 1) {
		msj ="Desea anular"
		ok= "Anular";
		cabecera.estado ="A";
		cabecera.entregado = "N"
	}
	console.log(element)
	alertify.confirm("Atencion", msj +" el envio con ID "+element.idEnvio+" del cliente " + element.clienteDestinatario.persona.nombres + " "+ element.clienteDestinatario.persona.apellidos +"?",
			
	  function(){
		
		grabar(cabecera, n)
	  },
	  function(){
	    alertify.error('Cancelado');
	  }).set('labels', {ok:ok, cancel:'Cancelar'});;
}

function grabar(element, n){
	var error = 0;
	var msj = "Giro  procesado";
	if(n == 1) {
		msj ="Giro  anulado"

	}
		
	if(error == 0){

		$.ajax({
			type: "POST",
		    url: "/api/v1/envio/procesar",
		    data: { cabecera: JSON.stringify(element)},
		    cache: false,
		    timeout: 600000,
		    success: function (data) {
		    	alertify .alert("Proceso Correcto", msj + " correctamente", function(){ 	
		    		cancelar(this.form);
				})
		    	  
		    },
		    error: function (e) {
		    	alert("Error al registrar");
		     }
		 });
	}
}


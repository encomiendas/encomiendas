var cliente;
$(document).ready(function() {

	//$('.datepicker').datepicker()
	$(".select2").select2();
	$(".editable").attr('disabled', true)
	
	$('.numerico').priceFormat({
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '.',
		centsLimit : 0,

	});
	
	$("#btnGrabar").click(function() {
		
		var error = 0;
		error = inputRequired($("#idCliente"))+inputRequired($("#idCliente1"))+ selectRequired($("#selectPais"))+
		inputRequired($("#cliente"))+inputRequired($("#cliente1"))+ selectRequired($("#selectSucursal"))+
		inputRequired($("#nrodoc"))+inputRequired($("#nrodoc1"))
			
		if(error == 0){
			var cabecera = {};
			var sucursal = {};
			sucursal.idSucursal = $("#selectSucursal").val();
			cabecera.sucursalDestino = sucursal;
			cabecera.sucursal = sucursal;
			var remitente = {};
			remitente.idCliente = $("#idCliente").val()
			cabecera.clienteRemitente = remitente;
			var destinatario = {};
			destinatario.idCliente = $("#idCliente1").val()
			cabecera.clienteDestinatario = destinatario;
			cabecera.estado = "P";
			cabecera.entregado = false;
			var pais = {};
			pais.idPais = $("#selectPais").val();
			cabecera.paisDestino = pais
			
			var obj = $('#tablaDetalle').tableToJSON();
			console.log(cabecera)
			
			
			var detalles = [];
			$.each( obj, function( index, element ) {
				  var item = {};
				  item.item = element.Item
				  var concepto = {};
				  concepto.idConcepto= element.id;
				  item.concepto = concepto;
				  item.comentario = element.Comentario;
				  item.montoEnvio = element.Importe_Envio.replace(/\./g, '');
				  item.montoTarifa = element.Monto_Tarifa.replace(/\./g, '');
				  item.montoTotal = parseInt(item.montoEnvio)+ parseInt(item.montoTarifa)
				  detalles.push(item)
				  
				});
			cabecera.detalles = detalles;

			$.ajax({
				type: "POST",
			    url: "/api/v1/envio/",
			    data: { cabecera: JSON.stringify(cabecera)},
			    cache: false,
			    timeout: 600000,
			    success: function (data) {
			    	alertify .alert("Proceso Correcto", "Giro  enviado correctamente", function(){ 	
			    		cancelar(this.form);
					})
			    	  
			    },
			    error: function (e) {
			    	alert("Error al registrar");
			     }
			 });
		}
		
		
		
	});
	
	
$("#btnNuevo").click(function() {
		
		$(".editable").attr('disabled', false)
		$("#btnNuevo").attr('disabled', true)
		$("#btnGrabar").attr('disabled', false)
		$("#nrodoc").focus()
		
	});
	
});

function modalCliente(n){
	cliente = n;
	$('#modalBusacadorCliente').modal();
}
		
function insertarDataDelBuscador(){
	var data = parseData();
	console.log(data)
	if(data != null){
		$('#modalBusacadorCliente').modal('toggle');
		if(cliente == 1){
			$("#idCliente").val(data.idCliente);
			$("#cliente").val(data.persona.nombres + " "+ data.persona.apellidos);
			$("#nrodoc").val(data.persona.documento);
		}else{
			$("#idCliente1").val(data.idCliente);
			$("#cliente1").val(data.persona.nombres + " "+ data.persona.apellidos);
			$("#nrodoc1").val(data.persona.documento);
		}
	}
}

function insertarDetalle(){
	var error = 0;
	error = inputRequired($("#importe"))+inputRequired($("#monto"))+ selectRequired($("#selectConcepto"))
		
	if(error == 0){
		var table = document.getElementById('tablaDetalle');
		
		var row = table.insertRow(-1);

		var cell0 = row.insertCell(0);
		var cell1 = row.insertCell(1);
		var cell2 = row.insertCell(2);
		var cell3 = row.insertCell(3);
		var cell4 = row.insertCell(4);
		var cell5 = row.insertCell(5);
		var cell6 = row.insertCell(6);


		cell0.innerHTML = $('#tablaDetalle tr').length -1 ;
		cell1.innerHTML = $("#selectConcepto option:selected").text()
		cell2.innerHTML = $("#importe").val()
		cell3.innerHTML = $("#monto").val()
		cell4.innerHTML = $("#comentario").val()
		cell5.innerHTML = '<a class="#" id="elim" onclick="eliminar(this)"><img src="/dist/img/delete.png" /></a>'
		cell6.innerHTML = $("#selectConcepto").val()

		limpiarCampos()
		
	}	
}


function limpiarCampos(){
	$("#importe").val("")
	$("#monto").val("")
	$("#comentario").val("")
}

function eliminar(row) {
	row.closest('tr').remove();

}


function buscarClienteByDoc(event){
	var tecla = event.keyCode ? event.keyCode : event.which ? event.which
			: event.charCode;
	console.log(event.target.value)
	var error = 0;
	error = inputRequired(event.target)
	var n;
	if (tecla == 13) {	
		if(error == 0){
			if(event.target.id == 'nrodoc'){
				$("#idCliente").val("");
				$("#cliente").val("");
				n=1;
			}else{
				$("#idCliente1").val("");
				$("#cliente1").val("");
		
				n=2;
			}
			
			$.ajax({
				url: "/api/v1/clientes/find-by-documento",
			    data: { documento: event.target.value },
			    timeout: 600000,
				success : function(data) {
					console.log(data)
					if(data.length == 0){
						$("#ajax-loader").hide();
						alertify.alert("Atenci&oacute;n","No se encontraron coincidencias" , function(){});
						return;
					}
					if(event.target.id == 'nrodoc'){
						$("#idCliente").val(data.idCliente);
						$("#cliente").val(data.persona.nombres + " "+ data.persona.apellidos);
						$("#nrodoc").val(data.persona.documento);
					}else{
						$("#idCliente1").val(data.idCliente);
						$("#cliente1").val(data.persona.nombres + " "+ data.persona.apellidos);
						$("#nrodoc1").val(data.persona.documento);
						
					}

				},
				error : function(e) {
					console.log("ERROR")
					modalCliente(n)
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		}
	}
	
}



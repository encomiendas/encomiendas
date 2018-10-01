var iddistrito =null;
var idciudad =null;
$(document).ready(function() {
	$(".select2").select2();
	  /*$('#fechaNacimiento').datepicker({
	      autoclose: true
	    })*/

		
	$('#tablaCliente tr').click(function(e) {
		insertForm(this);

		$('#tablaCliente tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
	
	//pais de residencia
	$('#idPais').change(function() {
		$('#idDivisionPolitica').empty();
		var idpais = $('#idPais').val();
		
		if(idpais==null || idpais=='') return;
		
		$.ajax({
			type: "GET",
		    contentType: "application/json",
		    url: "/api/v1/division-politica/pais/" + idpais,
		    dataType: 'json',
		    cache: false,
		    timeout: 600000,
		    success: function (data) {
	            $.each(data, function(index, element) {
	            	var o = $("<option/>", {
						value : element.idDivisionPolitica,
						text : element.descripcion
					});
					$("#idDivisionPolitica").append(o);
	            });
	          
		    	$('#idDivisionPolitica').val(iddistrito).attr('disabled', false).trigger('change');
		    },
		    error: function (e) {
		    	alert("Error al recuperar informacion");
		     }
		 });
	});
	
	//Distrito-Localidad
	$('#idDivisionPolitica').change(function() {
		$('#idCiudad').empty();
		var id = $('#idDivisionPolitica').val();
		if(id==null || id=='') return;
		$.ajax({
			type: "GET",
		    contentType: "application/json",
		    url: "/api/v1/ciudad/division-politica/" + id,
		    dataType: 'json',
		    cache: false,
		    timeout: 600000,
		    success: function (data) {
	            $.each(data, function(index, element) {
	            	var o = $("<option/>", {
						value : element.idCiudad,
						text : element.descripcion
					});
					$("#idCiudad").append(o);
	            });
		    	$('#idCiudad').val(idciudad).attr('disabled', false).trigger('change');
		    },
		    error: function (e) {
		    	alert("Error al recuperar informacion");
		     }
		 });
	});
});

// se inserta los valores
function insertForm(fila) {

	$("#idPersona").val(fila.cells[5].innerHTML);
	$("#documento").val(fila.cells[0].innerHTML);
	$("#nombres").val(fila.cells[1].innerHTML);
	$("#apellidos").val(fila.cells[2].innerHTML);

	if ($.trim(fila.cells[4].innerHTML) == '<span>ACTIVO</span>') {
		$("#estado").prop('selectedIndex', 1);
	} else {
		$("#estado").prop('selectedIndex', 2);
	}
	$('#tipoDoc').val(fila.cells[6].innerHTML).trigger('change');
	$('#tipoPersona').val(fila.cells[7].innerHTML).trigger('change');
	$('#idPais').val(fila.cells[8].innerHTML).trigger('change');
	$('#idPais2').val(fila.cells[9].innerHTML).trigger('change');
	$('#sexo').val(fila.cells[10].innerHTML).trigger('change');
	$('#estadoCivil').val(fila.cells[11].innerHTML).trigger('change');
	$('#correo').val(fila.cells[12].innerHTML);
	$('#telefono').val(fila.cells[13].innerHTML);
	$('#direccion').val(fila.cells[14].innerHTML);
	$('#fechaNacimiento').val(fila.cells[15].innerHTML);
	$('#idActividadEconomica').val(fila.cells[16].innerHTML).trigger('change');
	$('#idCiudad').val(fila.cells[17].innerHTML).trigger('change');
	$('#idDivisionPolitica').val(fila.cells[18].innerHTML).trigger('change');
	$('#tipoDoc2').val(fila.cells[19].innerHTML).trigger('change');
	$("#documento2").val(fila.cells[20].innerHTML);
	$(".editable").attr('disabled', false)
	$('#idCiudad').attr('disabled', false).trigger('change');
	$('#idDivisionPolitica').attr('disabled', false).trigger('change');
	$("#documento").focus();
	$('#btnGrabar').attr('disabled', false);
	
	iddistrito = fila.cells[18].innerHTML;
	idciudad = fila.cells[17].innerHTML;
}

function cancelar() {
	$('#tablaCliente tr').removeClass('highlighted');

	$('#btnGrabar').attr('disabled', true);
	$('#btnNuevo').attr('disabled', false);

	$("#formulario").trigger('reset');
	$(".editable").attr("disabled", true);
	$(".select2").val("").trigger('change');
	$('#idCiudad').attr('disabled', true).trigger('change');
	$('#idDivisionPolitica').attr('disabled', true).trigger('change');
	$('#idCiudad').attr('disabled', true).trigger('change');
	
	
}

function nuevo() {
	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);

	$("#formulario").trigger('reset');
	$(".editable").attr("disabled", false);
	$("#estado").prop('selectedIndex', 1);

	$("#documento").focus();

}


function insertarDataDelBuscador(){
	var data = parseData();
	if(data != null){
		$('#modalBusacadorPersona').modal('toggle');	
		$("#idPersona").val(data.idPersona);
		$("#documento").val(data.documento);
		$("#nombres").val(data.nombres);
		$("#apellidos").val(data.apellidos);
		
		if (data.estado) {
			$("#estado").prop('selectedIndex', 1);
		} else {
			$("#estado").prop('selectedIndex', 2);
		}
		$('#tipoDoc').val(data.tipoDocumento.idTipoDocumento).trigger('change');
		$('#tipoPersona').val(data.tipoPersona.idTipoPersona).trigger('change');
		//$('#idPais').val(data.PaisNacionalidad.idPais).trigger('change');
		//$('#idPais2').val(data.PaisResidencia.idPais).trigger('change');
		$('#sexo').val(data.genero).trigger('change');
		//$('#estadoCivil').val(data.EstadoCivil.idEstadoCivil).trigger('change');
		$('#correo').val(data.correo);
		$('#telefono').val(data.telefono);
		$('#direccion').val(data.direccion);
		$('#fechaNacimiento').val(data.fechaNacimiento);
		//$('#idActividadEconomica').val(data.actividadEconomica.idActividadEconomica).trigger('change');
		//$('#idCiudad').val(data.ciudad.idCiudad).trigger('change');
		//$('#idDivisionPolitica').val(data.divisionPolitica.idDivisionPolitica).trigger('change');
		//$('#tipoDoc2').val(data.tipoDocumento2.idTipoDocumento).trigger('change');
		$("#documento2").val(data.documento2);
		$(".editable").attr('disabled', false)
		$('#idCiudad').attr('disabled', false).trigger('change');
		$('#idDivisionPolitica').attr('disabled', false).trigger('change');
		$("#documento").focus();
		$('#btnGrabar').attr('disabled', false);
		
//	iddistrito = data.divisionPolitica.idDivisionPolitica;
//	idciudad = data.ciudad.idCiudad;
		
	}
}
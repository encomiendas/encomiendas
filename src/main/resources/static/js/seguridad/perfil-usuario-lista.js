$(function () {
    $(".select2").select2();
});

$("#btnGrabar").click(function() {
	
	var idUsuario = $("#selectUser").val();
	  
	var perfiles = $('#selectPerfil').select2("val"); 
	
	$.ajax({
		type: "POST",
	    url: "/api/v1/perfil-usuarios",
	    data: { idusuario: idUsuario, perfiles: perfiles },
	    cache: false,
	    timeout: 600000,
	    success: function (data) {
	    	  alert("Registro correcto de perfiles");
	    	  cancelar(this.form);
	    },
	    error: function (e) {
	    	alert("Error al registrar");
	     }
	 });
	
});

$('#selectUser').on('change', function() {
	
	$('#selectPerfil').val(null).trigger('change');
	
	idusuario = $('#selectUser').val();
	var array = [];
	
	$.ajax({
		type: "GET",
	    contentType: "application/json",
	    url: "/api/v1/perfil-usuarios",
	    data: { idusuario: idusuario },
	    dataType: 'json',
	    cache: false,
	    timeout: 600000,
	    success: function (data) {
            $.each(data, function(k, v) {
               array.push(JSON.stringify(data[k].perfil.idPerfil));
            });
	    	$('#selectPerfil').val(array);
	    	$('#selectPerfil').trigger('change');
	    },
	    error: function (e) {
	    	alert("Error al recuperar informacion");
	     }
	 });
});

$(document).ready(function() {
	$('#tablaProgramas tr').click(function(e) {
		insertForm(this);
		habilitarCampos();
		$('#tablaProgramas tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
});

// se inserta los valores
function insertForm(fila) {

	$("#idpagina").val(fila.cells[2].innerHTML);
	$("#url").val(fila.cells[1].innerHTML);
	$("#descripcion").val(fila.cells[0].innerHTML);

}

function habilitarCampos() {
	$('#url').attr('disabled', false);
	$('#descripcion').attr('disabled', false);

	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);

	$("#descripcion").focus();
	$("#descripcion").select();
}

function cancelar() {
	$('#btnGrabar').attr('disabled', true);
	$('#btnNuevo').attr('disabled', false);

	$("#formulario").trigger('reset');
	$("#formulario input").prop("disabled", true);
	$("#formulario select").prop("disabled", true);
	
	$('#selectPerfil').val(null).trigger('change');
	
}

function nuevo() {
	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);

	$("#formulario").trigger('reset');
	$("#formulario input").prop("disabled", true);
	$("#formulario select").prop("disabled", true);

	$("#formulario").trigger('reset');
	$("#formulario input").prop("disabled", false);
	$("#formulario select").prop("disabled", false);

	$("#formulario #idpagina").prop("disabled", true);

	$("#descripcion").focus();

}
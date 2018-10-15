
/*
 * Author: Lorenzo Bareiro
 * Date: 180918
 * Description: Mantenimiento de Unidad de Negocio.
 *       
 **/


$(document).ready(function() {
			$('#tablaProgramas tr').click(function(e) {
				insertForm(this);
				habilitarCampos();
				$('#tablaProgramas tr').removeClass('highlighted');
				$(this).toggleClass('highlighted');
			});
});


function insertForm(fila) {
	
	$("#descripcion").val(fila.cells[0].innerHTML);
	
	if ($.trim(fila.cells[1].innerHTML) == '<span>ACTIVO</span>') {
		$("#estado").prop('selectedIndex', 1);
	} else {
		$("#estado").prop('selectedIndex', 2);
	}
	$("#idUnidadNegocio").val(fila.cells[2].innerHTML);
	
}

function habilitarCampos() {
	$('#descripcion').attr('disabled', false);
	$('#estado').attr('disabled', false);
	
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
	
	$("#formulario #idusuario").prop("disabled", true);
	
	$("#estado").prop('selectedIndex', 1);
	
	$("#descripcion").focus();
	
}

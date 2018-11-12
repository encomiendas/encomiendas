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
	
	$("#descripcion").val(fila.cells[0].innerHTML);
	
	$("#idgrupoconcepto").val(fila.cells[1].innerHTML).trigger('change');
	
	$('#idTipoImpuesto').val(fila.cells[3].innerHTML).trigger('change');
	
	if ($.trim(fila.cells[5].innerHTML) == '<span>ACTIVO</span>') {
		$("#estado").prop('selectedIndex', 1);
	} else {
		$("#estado").prop('selectedIndex', 2);
	}	
		
	$("#idconcepto").val(fila.cells[6].innerHTML);
}

function habilitarCampos() {
	
	$('#descripcion').attr('disabled', false);
	$('#idgrupoconcepto').attr('disabled', false);
	$('#idTipoImpuesto').attr('disabled', false);
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

	$("#formulario #idmoneda").prop("disabled", true);
	
	$("#estado").prop('selectedIndex', 1);

	$("#descripcion").focus();

}







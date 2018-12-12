$(document).ready(function() {
	$('#tablaProgramas tr').click(function(e) {
		insertForm(this);
		habilitarCampos();
		$('#tablaProgramas tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
	$(".select2").select2();
});

// se inserta los valores
function insertForm(fila) {
	
	$("#idExistenciaComprob").val(fila.cells[0].innerHTML);
	$('#idEquipo').val(fila.cells[9].innerHTML).trigger('change.select2');
	$('#idTipoComprobante').val(fila.cells[10].innerHTML).trigger('change.select2');
	$("#nroDesde").val(fila.cells[3].innerHTML);
	$("#nroHasta").val(fila.cells[4].innerHTML);
	$("#nroTimbrado").val(fila.cells[5].innerHTML);
	$('#fechaInicioTimb').val(fila.cells[6].innerHTML);
	$('#fechaFinTimb').val(fila.cells[7].innerHTML);
		
	
	if ($.trim(fila.cells[8].innerHTML) == '<span>SI</span>') {
		$("#estado").prop('selectedIndex', 1);
	} else {
		$("#estado").prop('selectedIndex', 2);
	}	
		

}

function habilitarCampos() {
	
	$('#idEquipo').attr('disabled', false).trigger('change');
	$('#idTipoComprobante').attr('disabled', false).trigger('change');
	$('#nroDesde').attr('disabled', false);
	$('#nroHasta').attr('disabled', false);
	$('#nroTimbrado').attr('disabled', false);
	$('#fechaInicioTimb').attr('disabled', false);
	$('#fechaFinTimb').attr('disabled', false);
	$('#estado').attr('disabled', false);

	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);

	//$("#descripcion").focus();
}

function cancelar() {
	$('#btnGrabar').attr('disabled', true);
	$('#btnNuevo').attr('disabled', false);

	$("#formulario").trigger('reset');
	$("#formulario input").prop("disabled", true);
	$("#formulario select").prop("disabled", true);
	
	$('#tablaProgramas tr').removeClass('highlighted');
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







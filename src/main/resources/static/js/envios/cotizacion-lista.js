$(document).ready(function() {
	$('#tablaProgramas tr').click(function(e) {
		insertForm(this);
		habilitarCampos();
		$('#tablaProgramas tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
	
	$('td:nth-child(1),th:nth-child(1)').hide();
	$('td:nth-child(3),th:nth-child(3)').hide();
	
	$('#cotizVenta').priceFormat({
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '.',
		centsLimit : 0
	});
	
	$('#cotizCompra').priceFormat({
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '.',
		centsLimit : 0
	});
	
});

// se inserta los valores
function insertForm(fila) {
	$("#cotizVenta").val(fila.cells[4].innerHTML);
	$("#cotizCompra").val(fila.cells[5].innerHTML);
	
	$("#monedaA").val(fila.cells[2].innerHTML).trigger('change');
	$("#monedaDe").val(fila.cells[0].innerHTML).trigger('change');
	$("#idcotizacion").val(fila.cells[8].innerHTML);
	
}

function habilitarCampos() {
	
	$('#cotizVenta').attr('disabled', false);
	$('#cotizCompra').attr('disabled', false);
	
	$('#monedaA').attr('disabled', false);
	$('#monedaDe').attr('disabled', false);
	
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
	
	//$("#estado").prop('selectedIndex', 1);

	$("#monedaDe").focus();

}







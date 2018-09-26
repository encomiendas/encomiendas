$(document).ready(function() {
	$(".select2").select2();
	$('#idPais').change(function() {
		var data = $(this).val();
		$('#idPais2').val(data).trigger('change.select2');

	});

	$('#tablaCliente tr').click(function(e) {
		insertForm(this);
		$('#tablaCliente tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
});

function insertForm(fila) {

	$("#idCliente").val(fila.cells[5].innerHTML);
	$("#idPersona").val(fila.cells[6].innerHTML);
	$("#documento").val(fila.cells[0].innerHTML);
	$("#nombres").val(fila.cells[1].innerHTML);
	$("#apellidos").val(fila.cells[2].innerHTML);

	if ($.trim(fila.cells[4].innerHTML) == '<span>ACTIVO</span>') {
		$("#estado").prop('selectedIndex', 1);
	} else {
		$("#estado").prop('selectedIndex', 2);
	}
	$('#tipoDoc').val(fila.cells[7].innerHTML).trigger('change.select2');
	$('#tipoPersona').val(fila.cells[8].innerHTML).trigger('change.select2');
	$('#idPais').val(fila.cells[9].innerHTML).trigger('change.select2');
	$('#idPais2').val(fila.cells[9].innerHTML).trigger('change.select2');
	$(".editable").attr('disabled', false)

	$("#documento").focus();
	$('#btnGrabar').attr('disabled', false);
}

function cancelar() {
	$('#tablaCliente tr').removeClass('highlighted');

	$('#btnGrabar').attr('disabled', true);
	$('#btnNuevo').attr('disabled', false);

	$("#formulario").trigger('reset');
	$(".editable").attr("disabled", true);
}

function nuevo() {
	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);

	$("#formulario").trigger('reset');
	$(".editable").attr("disabled", false);
	$("#estado").prop('selectedIndex', 1);

	$("#documento").focus();

}

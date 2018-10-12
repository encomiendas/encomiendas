$(document).ready(function() {

	$(function() {
		$(".select2").select2();
	});

	$('#tabla-datos tr').click(function(e) {
		insertForm(this);
		habilitarCampos();
		$('#tabla-datos tr').removeClass('highlighted');
		$(this).toggleClass('highlighted');
	});
});
		
		
// se inserta los valores
function insertForm(fila) {

	
	console.log(fila.cells[0].innerHTML);
	console.log($.trim(fila.cells[1].innerHTML));
	console.log(fila.cells[2].innerHTML);
	
	
	$("#idGrupoConcepto").val(fila.cells[2].innerHTML);


	$("#descripcion").val(fila.cells[0].innerHTML);


	if ($.trim(fila.cells[1].innerHTML) == '<span>ACTIVO</span>') {
		console.log("inten 1");
		$("#estado").prop('selectedIndex', 1);
	} else {
		console.log("inten 2");
		$("#estado").prop('selectedIndex', 2);
	}
}


function habilitarCampos() {
	$("#formulario input").prop("disabled", false);
	$("#formulario select").prop("disabled", false);
	
	$('#btnGrabar').attr('disabled', false);
	$('#btnNuevo').attr('disabled', true);
}
		
function cancelar() {
	$( "#selectPagina" ).hide();
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
	
	$("#formulario input").prop("disabled", false);
	$("#formulario select").prop("disabled", false);
	
	$("#formulario #idGrupoConcepto").prop("disabled", true);
	
	$("#estado").prop('selectedIndex', 1);
	
}
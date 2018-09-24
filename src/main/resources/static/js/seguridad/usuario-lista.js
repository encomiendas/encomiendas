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

			$("#idusuario").val(fila.cells[4].innerHTML);
			$("#usuario").val(fila.cells[0].innerHTML);

			if ($.trim(fila.cells[3].innerHTML) == '<span>ACTIVO</span>') {
				$("#estado").prop('selectedIndex', 1);
			} else {
				$("#estado").prop('selectedIndex', 2);
			}
			
			$('#selectPersona').val(fila.cells[5].innerHTML).trigger('change.select2');
			$('#selectSucursal').val(fila.cells[6].innerHTML).trigger('change.select2');
			
		}

		function habilitarCampos() {
			$('#usuario').attr('disabled', false);
			$('#estado').attr('disabled', false);
			$('#selectPersona').attr('disabled', false);
			$('#selectSucursal').attr('disabled', false);
			
			$('#btnGrabar').attr('disabled', false);
			$('#btnNuevo').attr('disabled', true);
			
			$("#usuario").focus();
			$("#usuario").select();
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
			
			$("#usuario").focus();
			
		}
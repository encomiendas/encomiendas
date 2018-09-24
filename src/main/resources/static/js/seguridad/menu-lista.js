$(document).ready(function() {
			
			$(function () {
			    $(".select2").select2();
			});
			
			$('#tipoMenu').val(0).change();
			
			$('#tablaMenu tr').click(function(e) {
				insertForm(this);
				habilitarCampos();
				$('#tablaMenu tr').removeClass('highlighted');
				$(this).toggleClass('highlighted');
			});
		});
		
		
		$('#tipomenu').change(function(){
			  var data= $(this).val();
			  
			  console.log("data " + data);
			  
			  if(data=='S'){
				  $( "#selectMenuAnterior" ).show();
				  $( "#selectPagina" ).show();
			  }else{
				  $( "#selectMenuAnterior" ).hide();
				  $( "#selectPagina" ).hide();
			  }
			  
		});
		

		// se inserta los valores
		function insertForm(fila) {
			
			$("#idmenu").val(fila.cells[4].innerHTML);

			$('#selectPerfil').val(fila.cells[6].innerHTML).trigger('change.select2');
			
			if ($.trim(fila.cells[0].innerHTML) == 'M') {
				
				$("#tipomenu").prop('selectedIndex', 1);
				$( "#selectMenuAnterior" ).hide();
				$( "#selectPagina" ).hide();
				
			} else {
				$("#tipomenu").prop('selectedIndex', 2);

				$( "#selectMenuAnterior" ).show();
				$( "#selectPagina" ).show();
				
				console.log("pagina " + fila.cells[7].innerHTML);
				
				$('#selectPagina').val(fila.cells[7].innerHTML).trigger('change.select2');
				$('#selectMenuAnterior').val(fila.cells[8].innerHTML).trigger('change.select2');
				
			}
			
			$("#descripcion").val(fila.cells[1].innerHTML);
			
			$("#posicion").val(fila.cells[5].innerHTML);
			
			
			if ($.trim(fila.cells[3].innerHTML) == '<span>ACTIVO</span>') {
				$("#estado").prop('selectedIndex', 1);
			} else {
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
			$( "#selectMenuAnterior" ).hide();
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
			
			$("#formulario #idmenu").prop("disabled", true);
			
			$("#estado").prop('selectedIndex', 1);
			
		}
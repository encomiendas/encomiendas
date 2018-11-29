var context = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
/*$(document).ready(function(){
	
	var table = $('#tablaDetalleVenta').DataTable({
		"language": { "url": context + "/plugins/datatables/Spanish.json"},
	   	pageLength: 10,
	       responsive: true,
	       dom: '<"html5buttons"B>lTfgitp',
	       buttons: [
	           {extend: 'csv', title: 'Detalle Venta',exportOptions: { columns: ':visible'}},
	           {extend: 'excel', title: 'Detalle Venta',exportOptions: { columns: ':visible'}},
	           {extend: 'pdf', title: 'Detalle Venta',exportOptions: { columns: ':visible'}}
	       ],
	       //formato numerico
	       "createdRow": function ( row, data, index ) {
	               $('td', row).eq(2).addClass('price');
	               $('td', row).eq(3).addClass('price');
	               $('td', row).eq(5).addClass('price');
	               $('td', row).eq(6).addClass('price');
	               
	       }

	   });
	
	
	//$(".price").mask("000.000.000.000",{reverse: true});



});*/



function setDetalleVenta(indice){
	var datos = JSON.parse(array_detalle_venta[indice])

	$("#tablaDetalleVenta > tbody").html("");
	var cont = 1;
	$.each(datos, function(index, element) {
		
		
		$('#tablaDetalleVenta tbody').append(
	              "<tr>\n" +
	              "  <td style='text-align: center;'>" + cont+"</td>\n"+ 
	              "  <td>" + element.concepto.descripcion +"</td>\n"+
	              "  <td>" + element.moneda.descripcion +"</td>\n"+
	              "  <td style='text-align: center;'>" + element.cantidad+"</td>\n"+
	              "  <td style='text-align: right;'>" +numeral(element.montoEnvio).format('0,0')+"</td>\n"+
	              "  <td style='text-align: right;'>" + numeral(element.montoTarifa).format('0,0')+"</td>\n"+
	              "  <td style='text-align: right;'>" + numeral(element.montoTotal).format('0,0')+"</td>\n"+
	              "</tr>\n"
	            );
        
		/*table.rows.add( [ {
			"0": cont,
			"1": element.concepto.descripcion,
			"2": element.moneda.descripcion,
			"3": element.cantidad,
			"4": element.montoEnvio,
			"5": element.montoTarifa,
			"6": element.montoTotal,
			}]).draw();*/
			//formato numerico
		//	$(".price").mask("000.000.000.000",{reverse: true});
			cont++;
	});	
    
}

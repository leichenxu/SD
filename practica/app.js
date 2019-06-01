$(function() {
	var flickerAPI = "https://api.flickr.com/services/rest?";
	var url = flickerAPI + 'method=flickr.test.echo' + '&api_key=' + api_key
			+ '&format=json' + '&nojsoncallback=1';

	$.getJSON(url, function(data) {
		$('#respuesta').append(data.stat);
	});
});

$(function() {
	$.getJSON(
			'https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key='
					+ api_key + '&user_id=' + user_id
					+ '&format=json&nojsoncallback=1', mostrar_fotos)

	function mostrar_fotos(info) {
		var i;
		for (i = 0; i < info.photos.photo.length; i++) {
			var item = info.photos.photo[i];
			var url = 'https://farm' + item.farm + ".staticflickr.com/"
					+ item.server + '/' + item.id + '_' + item.secret
					+ '_t.jpg';
			$("#imagenes").append($("<img/>").attr("src", url));
		}
	}

})

function ocultarInicio() {
	var x = document.getElementById("todo");
	  var y = document.getElementById("AF");
	  if (x.style.display === "block") {
	    x.style.display = "none";
	    y.style.display="block";
	  }
}
function ocultarAF() {
	var x = document.getElementById("todo");
	  var y = document.getElementById("AF");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	    y.style.display="none";
	  }
	}

$(function() {
	main();
	function main(){		
		var urlEnviar1='https://api.flickr.com/services/rest/?&method=flickr.photos.getContactsPublicPhotos&api_key='
			+ api_key
			+ '&user_id='
			+ user_id
			+ '&format=json&nojsoncallback=1';
		var urlEnviar2='https://api.flickr.com/services/rest/?&method=flickr.photos.getContactsPublicPhotos&api_key='
			+ api_key
			+ '&user_id='
			+ user_id+'&just_friends=1'
			+ '&format=json&nojsoncallback=1';
		var obj1="#imagenesContacto";
		var obj2="#imagenesAF";
		llamada(obj1,urlEnviar1,0);
		llamada(obj2,urlEnviar2,1);
	}	
	function llamada(objetivo,urlRecibido,numeroSumar){
		
		$.ajax({
						async : false,
						type : 'GET',
						datatype : 'json',
						url:urlRecibido,
						success:mostrarFotosContactos})
		function mostrarFotosContactos(info) {
			var i, j;
			var datos = [];
			var nombres = [];
			for (i = 0; i < info.photos.photo.length; i++) {
				var item = info.photos.photo[i];
				datos.push(item);
				if (!nombres.includes(item.username)) {
					nombres.push(item.username);
				}
			}
			// meter en cada class todos los imagenes, la hoja de estilos los
			// desplaza de izq a der
			for (i = 0; i < nombres.length; i++) {
				var id;
				for (j = 0; j < datos.length; j++) {
					if (datos[j].username === nombres[i]) {
						var url = 'https://farm' + datos[j].farm
								+ ".staticflickr.com/" + datos[j].server + '/'
								+ datos[j].id + '_' + datos[j].secret + '_t.jpg';
						/*$(objetivo).append("<div class=\"column\">",
								$("<img/>").attr("src", url)
								.attr("id", datos[j].id+numeroSumar));*/
						var fecha=datos[j].id;
						$.ajax({
							async : false,
							type : 'GET',
							data:'json',
							url:'https://api.flickr.com/services/rest/?&method=flickr.photos.getInfo&api_key='
								+ api_key
								+ '&photo_id='
								+ fecha
								+ '&format=json&nojsoncallback=1',
							success:function(infoFecha){
								$(objetivo).append("<div class=\"column\"><img src=\""+url+"\" id=\""
										+(datos[j].id+numeroSumar)+"\"/>"+
										"<span class=\"caption\">"+infoFecha.photo.dates.taken+"</span></div>");
							}
						})
						$(objetivo).append(
								"<div id=\"myModal" + datos[j].id+numeroSumar
										+ "\" class=\"modal\">"
										+ "<span class=\"close\" id=\"close"
										+ datos[j].id+numeroSumar + "\">&times;</span>"
										+ "<img class=\"modal-content\" id=\"img"
										+ datos[j].id+numeroSumar + "\">"
										+ "<div id=\"caption\"></div>" + "</div>");
						var modal = document
								.getElementById('myModal' + datos[j].id+numeroSumar);
						var img = document.getElementById(datos[j].id+numeroSumar);
						var modalImg = document.getElementById("img" + datos[j].id+numeroSumar);

						img.onclick = function() {
							modal.style.display = "block";
							var aux=this.src.substring(0,this.src.length-5)+"b.jpg";
							modalImg.src = aux;
						}
						var span = document.getElementById("close" + datos[j].id+numeroSumar);

						span.onclick = function() {
							modal.style.display = "none";
						}

						id = datos[j].owner;
					}
				}			
				
				var dir = 'https://api.flickr.com/services/rest/?&method=flickr.people.getInfo&api_key='
						+ api_key
						+ '&user_id='
	+ id
	+ '&format=json&nojsoncallback=1';
				//para cargar los nombres
				$.ajax({
					async : false,
					type : 'GET',
					url : dir,
					datatype : 'json',
					success : function(info) {
						$(objetivo)
								.append("<div class=\"miColumn\"><strong>Nombre de usuario:</strong> "+
										"<element id=\""+nombres[i]+"\" onClick=\"ocultarInicio()\">"+nombres[i]+"</element> "+
										"<strong>Nombre de real:</strong> "+
										info.person.realname._content+"</div><br>");
					}
				})
			}
		}	
		}	
})



function getFiltroLibros(){
    
    var filtro = 0; 
    
    textFiltro = document.getElementById("selectFiltro").value;
    
    if (document.getElementsByName("filtro")[0].checked){
    	filtro = 1;
    	url = '/listaDeseo/verLibrosDesdeGoogleBooksFiltroAutor/'+textFiltro;
    }
    if (document.getElementsByName("filtro")[1].checked){
    	filtro = 2;
    	url = '/listaDeseo/verLibrosDesdeGoogleBooksFiltroTitulo/'+textFiltro;
    }
    if (document.getElementsByName("filtro")[2].checked){
    	filtro = 3;
    	url = '/listaDeseo/verLibrosDesdeGoogleBooksFiltroPublisher/'+textFiltro;
	}
	
	if (filtro === 0){
		alert('Por favor seleccione un filtro');
		return;
	}
	
	if (textFiltro.lenght === 0 || textFiltro === ''){
		alert('Por favor escribe un texto para el filtro seleccionado');
		return;
	}
	
	
	document.formGetLibrosFromGoogleBooks.action=url;
	document.formGetLibrosFromGoogleBooks.method='get';
	document.formGetLibrosFromGoogleBooks.submit();
    
}

function cargarLibrosEnLista(){
	url = '/listaDeseo/formListaDeseo/1';
	
	document.formGetLibrosFromGoogleBooks.action=url;
	document.formGetLibrosFromGoogleBooks.method='post';
	document.formGetLibrosFromGoogleBooks.submit();
}


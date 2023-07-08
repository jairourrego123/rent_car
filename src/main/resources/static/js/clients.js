// Variables Globales
let URL_BASE = "http://localhost:8080"
let client = null;

//Carga Inicial Pagina

$(document).ready( function(){
    $("#modalClient").hide();
})

//Funciones Utilitarias
function updateClientsTable(){
}

//Consumir sericios CUR

function getAllClients(){
    $.ajax({ // para llamar un servicio y traer la informacion sin necesidad de recargar
        url : URL_BASE + "/clients/all",
        type: "GET",
        datatype: "JSON"
    })
    .done(function(response){
        console.log(response);

    })
    .fail(function (jqHXR,testStatus,errorThrown){
        console.log("Error en getAllClients. " + testStatus );
        alert("Hemos tenido una falla obteniendo los clientes. Por favor Intente de nuevo mas tarde ");
    });
}
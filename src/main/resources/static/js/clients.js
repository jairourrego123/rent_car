// Variables Globales
let URL_BASE = "http://localhost:8080"
let client = null;

//Carga Inicial Pagina

$(document).ready( function(){
    closeModal();
    getAllClients();


})
//manejo del modal
function openModal(clientId){
    if(clientId==-1){ // Crear un nuevo cliente
        $("modalTitle").html("Nuevo Cliente")
        $("#btnAddClient").show();
        $("#btnUpdateClient").hide();
        $("#txtId").val("");
        $("#textId").prop("disabled",false)
        $("#txtNames").val("");
        $("#txtDirection").val("");
        $("#txtPhones").val("");
        $("#txtEmail").val("");
        $("#txtNickname").val("");
        $("#txtNickname").prop("disabled",false)
        $("#txtPassword").val("");
    }
    else{ // Actualizar un cliente
     $("modalTitle").html("Actualizar Cliente")
     $("#btnAddClient").hide();
     $("#btnUpdateClient").show();
     getClient(clientId);
     $("#txtId").val(client.idClient);
     $("#textId").prop("disabled",true);
     $("#txtNames").val(client.name);
     $("#txtDirection").val(client.address);
     $("#txtPhones").val(client.phones);
     $("#txtEmail").val(client.email);
     $("#txtNickname").val(client.nickname);
     $("#txtNickname").prop("disabled",true)
     $("#txtPassword").val(client.password);

    }
    $("#modalClient").show();
}

function closeModal(){
    $("#modalClient").hide();
}
//Funciones Utilitarias
function updateClientsTable(clients){
    $("#tblClients").find("tr:gt(0)").remove();//eliminar contenido
    let data = "";
    for (let i=0; i < clients.length; i++){
        data +="<tr>"
        data +="<td>"+ clients[i].idClient + "</td>"
        data +="<td>"+ clients[i].name + "</td>"
        data +="<td>"+ clients[i].address + "</td>"
        data +="<td>"+ clients[i].phones + "</td>"
        data +="<td>"+ clients[i].email +  "</td>"
        data +="<td>"+ clients[i].nickname +  "</td>"
        data +="<td>"+ "<span onclick=\"openModal("+ clients[i].idClient +") \">Actualizar </span>" +  "</td>"
        data +="<td>"+ "<span onclick=\"deleteClient("+ clients[i].idClient +")\">Eliminar</span>" + "</td>"
        data +="</tr>"
    }
    $("#tblClients > tbody:last-child").append(data) // se mueve al tbody y algrega la informacion
}

//Consumir servicios CUR

function getAllClients(){
    $.ajax({ // para llamar un servicio y traer la informacion sin necesidad de recargar
        url : URL_BASE + "/clients/all",
        type: "GET",
        datatype: "JSON"
    })
    .done(function(response){
        console.log(response);
        updateClientsTable(response);

    })
    .fail(function (jqHXR,textStatus,errorThrown){
        console.log("Error en getAllClients. " + textStatus );
        alert("Hemos tenido una falla obteniendo los clientes. Por favor Intente de nuevo mas tarde ");
    });
}

function getClient(clientId){
    $.ajax({
        url:URL_BASE+ "/clients/by_id/"+clientId,
        type:"GET",
        datatype:"JSON",
        async:false
    })
    .done(function(response){
        console.log(response)
        client=response;
    })
    .fail(function(jqHXR,textStatus,errorThrown){
        console.log("Error  in getClient." + clientId + "."+ textStatus)
        alert("Hemos tenido una falla obteniendo la informacion del Cliente. Por favor, Intente mastarde")
    })
}
function insertClient(){

    client ={
        idClient:$("#txtId").val(),
        name:$("#txtNames").val(),
        address:$("#txtDirection").val(),
        phones:$("#txtPhones").val(),
        email:$("#txtEmail").val(),
        nickname:$("#txtNickname").val(),
        password:$("#txtPassword").val()
    }

    let body = JSON.stringify(client);
      console.log(body);
    $.ajax({
        url: URL_BASE + "/clients/insert",
        type : "POST",
        datatype: "JSON",
        data:body,
        contentType:"application/json; charset=UTF-8"
    })

    .done(function(response){
    console.log(response)
    alert("Cliente Agregado")
    getAllClients();
    })
    .fail(function(jqHXR,textStatus,errorThrown){
        console.log("Error in insertClient." + textStatus);
        alert("Falla creando el cliente. Por favor, intente mas tarde")
    });
    closeModal()
}
function updateClient(clientId){
 client ={
        idClient:$("#txtId").val(),
        name:$("#txtNames").val(),
        address:$("#txtDirection").val(),
        phones:$("#txtPhones").val(),
        email:$("#txtEmail").val(),
        nickname:$("#txtNickname").val(),
        password:$("#txtPassword").val()
    }

    let body = JSON.stringify(client);
    console.log(body)
    $.ajax({
        url: URL_BASE + "/clients/update",
        type: "PUT",
        datatype:"JSON",
        data:body,
        contentType:"application/json;charset=UTF-8"
    })
    .done(function(response){
    console.log(response)
    alert("Cliente Correctamente Actualizado")
    getAllClients();
    })
    .fail(function(jqHXR,textStatus,errorThrown){
    console.log("Error in updateCliente." + textStatus);
    alert("Falla actualizando el cliente. Por favor, intente mas tarde")
    });
    closeModal()
}
function deleteClient(clientId){
    $.ajax({
        url:URL_BASE + "/clients/delete/"+ clientId,
        type:"DELETE",
        datatype:"JSON",

    })
    .done(function(response){
        console.log(response)
        alert("Cliente eliminado Satisfactoriamente")
        getAllClients();
    })
    .fail(function(jqHXR,textStatus,errorThrown){
        console.log("Error in deleteClient."+clientId+". "+textStatus)
        alert("Falla eliminando el cliente.Por favor, intente mas tarde" )
    });
}
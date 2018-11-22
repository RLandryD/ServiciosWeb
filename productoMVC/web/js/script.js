/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function enviar_datos(id) {
    var id = id;
    var url = "ServletControl";
    console.log(id);
    $.ajax({
        type: "post",
        url: url,
        data: {id: id},
        success: function (datos) {
            $("#elementos").html(datos);
        }
    });
}
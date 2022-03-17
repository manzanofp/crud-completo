function saveUser(){

var id = $("#id").val();
var name = $("#name").val();
var age = $("#age").val();

$.ajax({
method: "POST",
url: "saveUser",
data: JSON.stringify({id : id, name : name, age : age}),
contentType: "application/json; charset=utf-8",

success: function (response){
$("#id").val(response.id);
alert("Saved successfully!");
}

}).fail(function (xhr, status, errorThrown) {
alert("error saving: " + xhr.responseText);
});


}
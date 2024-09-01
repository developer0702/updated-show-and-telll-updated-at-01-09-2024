$(document).ready(function(){
	$.ajax({
		  url: "http://localhost:9090/micro-patient/patient/getById/110",
		 
		  success: function(result) {
				console.log(result)
				 var table = $("<table><tr><th> Profile </th></tr>");
				  
                table.append("<tr><td>Id:</td><td>" + result["id"] + "</td></tr>");
                table.append("<tr><td>Full Name:</td><td>" + result["fullName"] + "</td></tr>");
                table.append("<tr><td>Email :</td><td>" + result["email"] + "</td></tr>");
                table.append("<tr><td>Address :</td><td>" + result["address"] + "</td></tr>");
                table.append("<tr><td>Mobile Number:</td><td>" + result["mobileno"] + "</td></tr>");

                $("#profile").html(table);
			},
		  dataType: 'json'
		});
    
});


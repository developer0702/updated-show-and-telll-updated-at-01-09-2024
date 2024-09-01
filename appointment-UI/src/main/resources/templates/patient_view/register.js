$(document).ready(function(){
	$.ajax({
		type : "GET",
		url : "http://localhost:9090/micro-patient/patient/getById/110",
		success : function(result) {
			console.log(result)
		},
		error : function(e) {
			
			
		}
	});
    
});


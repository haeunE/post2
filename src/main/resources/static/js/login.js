$("#btn-login").on("click",(e)=>{
	e.preventDefault();
	let user = {
		username: $("#username").val(),
		password : $("#password").val()
	}
	$.ajax({
		type:"POST",
		url: "/auth/login",
		data: JSON.stringify(user),
		contentType : "application/json;charset=utf-8"
	}).done(function(response){
		alert(response.data);
		if(response.status==200)
			location.href = "/"
	}).fail(function(error){
		console.log(error)
	})
})
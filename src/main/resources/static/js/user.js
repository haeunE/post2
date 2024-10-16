const userObject = {
   init:function() {
      $('#btn-save').on('click', (e) => {
         e.preventDefault();
         this.insertUser();
      })
	  $('#btn-update').on('click',(e)=>{
		e.preventDefault();
		if(!confirm("회원정보르 수정하시겠습니까?"))
			return;
		alert('수정처리 진행합니다.');
		this.updateUser();
	  })
	  $('#btn-delete').on('click', (e) => {
	    e.preventDefault(); //기본동작막아주기
		
		if(!confirm("회원탈퇴하시겠습니까?"))
			return;
		
		let id = $('#id').val();
		console.log(id);
		$.ajax({
			type: "DELETE",
			url: "/auth/delete?id="+id
		}).done(function(response){
			alert(response.data);
		}).fail(function(response){
			console.log(error);
		})
	  })
   },
   
   insertUser:function() {
      alert("회원가입요청");
      // 회원가입 시 입력한 정보를 추출
      let user = {
         username: $("#username").val(),
         password: $("#password").val(),
         email: $("#email").val()
      };
      
      $.ajax({
         type: "POST",
         url: "/auth/insertuser",
         data: JSON.stringify(user),
         contentType: "application/json; charset=utf-8"
      }).done(function(response) {
         alert(response.data);
         if(response.status == 200){
			alert(response.data)
			location.href = "/";
		}else {
			const result = response.data;
			let msg = "";
			if(result.username !=null)
				msg+=result.username +"\n";
			if(result.password !=null)
				msg+=result.password +"\n";
			if(result.email !=null)
				msg+=result.email;
			alert(msg);
		}
      }).fail(function(error) {
         console.log(error);
      })  
   },
   updateUser:function() {
		alert('회원 정보 수정 요청');
		let user ={
			username: $("#username").val(),
		    password: $("#password").val(),
		    email: $("#email").val()
		};
		alert(user.username);
		$.ajax({
			type: "POST",
			url:"/auth/update",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response){
			if(response.status == 200)
				location.href = "/";
		}).fail(function(error){
			console.log(error)
		})
   },
   
}

userObject.init();



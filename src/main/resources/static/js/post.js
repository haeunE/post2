$(document).ready(function(){
	$("#content").summernote({
		height:400
	});
})
const postObject = {
	init:function(){
		$("#btn-insert").on("click",(e)=>{
			e.preventDefault(); //기본동작 막기
			if(!confirm("게시물을 저장하시겠습니까?"))
				return;
			alert("저장합니다.");
			this.savePost();
		}),
		$("#btn-update").on("click",(e)=>{
			e.preventDefault();
			this.updatePost();
		}),
		$("#btn-delete").on("click",(e)=>{
			e.preventDefault();
			if(!confirm("삭제하시겠습니까?"))
				return;
			const id = $("#id").text();
			alert(id)
			$.ajax({
				type: "DELETE",
				url: `/post/${id}`
			}).done(function(response){
				alert(response.data);
				if(response.status==200)
					location.href="/";
			}).fail(function(error){
				console.log(error);
			})
		})
	},
	
	
	savePost:function(){
		let send= {
			title : $("#title").val(),
			content : $("#content").val()
		}
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(send),
			contentType: "application/json; charset=utf-8"
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location.href = "/";
		}).fail(function(error) {
				console.log(error);
		})  
	},
	updatePost: function(){
		if(!confirm("수정하시겠습니까?"))
			return;
		let post = {
			id: $("#id").val(),
			title : $("#title").val(),
			content : $("#content").val()
		}
		$.ajax({
			type: "PUT",
			url: "/post",
			data: JSON.stringify(post),
			contentType: "application/json; charset=utf-8"
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location.href = "/post/"+post.id;
		}).fail(function(error) {
				console.log(error);
		})  
	}
	
}
postObject.init();
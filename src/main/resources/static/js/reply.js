$("#btn-save-reply").on("click", (e)=>{
	e.preventDefault();
	const postId = $("#postId").val();
	const reply = {
		content: $("#reply-content").val()
	};
	$.ajax({
		type: "POST",
		url : "/reply/" +postId,
		data: JSON.stringify(reply),
		contentType: "application/json; charset=utf-8"
	}).done((response)=>{
		alert(response.data);
		location.href = "/post/"+postId;
		
	}).fail((error)=>{
		console.log(error)
	})
})
$(".reply-delete").on("click",(e)=>{
	e.preventDefault();
	const replyId = e.target.dataset.id;
	$.ajax({
		type: "DELETE",
		url: "/reply/"+replyId
	}).done((response)=>{
		alert(response.data);
		location.reload();
		
	}).fail((error)=>{
		console.log(error)
	})
})
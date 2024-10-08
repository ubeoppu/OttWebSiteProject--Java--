
function updateCheck(contentNum){
	if(confirm("수정하시겠습니까?")){
		alert("수정되었습니다");
		location.href="OttServlet?command=content_detail&contentNum="+contentNum;
	}else{
		alert("수정이 취소되었습니다");
	}
	
}

function deleteCheck(){
	alert("삭제되었습니다.")
}

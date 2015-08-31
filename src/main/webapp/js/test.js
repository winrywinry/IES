/**
 * 
 */
var answer_no = 3;
$(function(){
	$(".answer_add").click(function(){
		if (answer_no<9) answerAdd();
	})
	$(".answer_del").click(function(){
		if (answer_no>3) answerDel();
	})
	if ($("input[name='gubun']:checked").val() == 'A'){
		$("#answer_A").show();
		$("#answer_B").hide();
	} else {
		$("#answer_A").hide();
		$("#answer_B").show();
	}
	$("input[name='gubun']").click(function(){
		var val = $(this).val();
		if (val == 'A'){
			$("#answer_A").show();
			$("#answer_B").hide();
		} else {
			$("#answer_A").hide();
			$("#answer_B").show();
		}
	})
	$("img.rollover").hover(function(){
		var src = $(this).attr("src").match(/[^\.]+/) + "_over.png";
		$(this).attr("src", src);
	}, function(){
		var src = $(this).attr("src").replace("_over", "");
		$(this).attr("src", src);
	})
})
function answerDelAction(){
	$(".answer_del").click(function(){
		answerDel($(this));
	})
}
function answerAdd(){
	var answerDiv = $("<div>"+ answer_no +". </div>");
	var answerRadio = "<input type='radio' name='corr_answer' value='"+ answer_no +"' />";
	var answerTxt = "<input type='text' name='answer_arr' class='txt w200' /> ";
	answerDiv.append(answerRadio);
	answerDiv.append(answerTxt);
	$("#answerList").append(answerDiv);
	answer_no++;
}
function answerDel(obj){
	$("#answerList div:last-child").remove();
	answer_no--;
}
function submitChk(){
	var f = document.writeFrm;
	if (FormChkModule(f)) {
		f.submit();
	}
}
function FormChkModule(f){
	return true;
	var gubun = -1;
	for (var i=0;i<f.gubun.length;i++){
		if (f.gubun[i].checked==true){
			gubun = i;
		}
	}
	if (gubun == -1) {
		alert("문제구분을 선택해 주세요!");
		f.gubun[0].focus();
		return false;
	}
	
	if (f.question.value == ''){
		alert("문제를 입력해 주세요!");
		f.question.focus();
		return false;
	}
	if (gubun == 0) {
		var answer = 0;
		for (var i=0;i<f.corr_answer.length;i++){
			if (f.corr_answer[i].checked == true){
				answer++;
			}
		}
		var answer_str = -1;
		for (var i=0;i<f.answer_arr.length;i++){
			if (f.answer_arr[i].value == '') {
				if (answer_str == -1) answer_str = i;
			}
		}
		if (answer == 0){
			alert("정답을 체크해주세요.")
			f.corr_answer[0].focus();
			return false;
		}
		if (answer_str > -1){
			alert("정답 문항을 입력해 주세요!");
			f.answer_arr[answer_str].focus();
			return false;
		}
	} else {
		if (f.corr_answer2.value == ''){
			alert("정답을 입력해 주세요!");
			f.corr_answer2.focus();
			return false;
		}
	}
	return true;
}

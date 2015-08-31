/**
 * 
 */
function joinFormCheck(f) {
	if (f.user_id.value == "") {
		alert("아이디를 입력해 주세요!");
		f.user_id.focus();
		return false;
	}
	if (f.idDup.value != f.user_id.value) {
		alert("사용할 수 없는 아이디 입니다!")
		f.user_id.select();
		f.user_id.focus();
		return false;
	}
	if (f.user_pwd.value == ""){
		alert("비밀번호를 입력해 주세요!");
		f.user_pwd.focus();
		return false;
	}
	if (f.pwdChk.value == "false"){
		alert("사용할 수 없는 비밀번호 입니다!");
		f.user_pwd.select();
		f.user_pwd.focus();
		return false;
	}
	if (f.user_pwd.value != f.user_pwd2.value){
		alert("비밀번호가 일치하지 않습니다!");
		f.user_pwd2.select();
		f.user_pwd2.focus();
		return false;
	}
	if (f.line_no1.value == ""){
		alert("내선번호를 입력해 주세요!");
		f.line_no1.focus();
		return false;
	}
	if (f.line_no2.value == ""){
		alert("내선번호를 입력해 주세요!");
		f.line_no2.focus();
		return false;
	}
	if (f.line_no3.value == ""){
		alert("내선번호를 입력해 주세요!");
		f.line_no3.focus();
		return false;
	}
	if (f.phone_no1.value == ""){
		alert("휴대폰번호를 입력해 주세요!");
		f.phone_no1.focus();
		return false;
	}
	if (f.phone_no2.value == ""){
		alert("휴대폰번호를 입력해 주세요!");
		f.phone_no2.focus();
		return false;
	}
	if (f.phone_no3.value == "") {
		alert("휴대폰번호를 입력해 주세요!");
		f.phone_no3.focus();
		return false;
	}
	if (f.post.value == ""){
		alert("우편번호 찾기를 통해 주소를 입력해 주세요!");
		f.post.focus();
		return false;
	}
	if (f.address.value == ""){
		alert("우편번호 찾기를 통해 주소를 입력해 주세요!");
		f.address.focus();
		return false;
	}
	if (f.email1.value == ""){
		alert("이메일을 입력해 주세요!");
		f.email1.focus();
		return false;
	}
	if (f.email2.value == ""){
		alert("이메일을 입력해 주세요!");
		f.email2.focus();
		return false;
	}
	return true;
}
function idCheck(val) {
	var params = "id="+ val;
	new ajax.xhr.Request("/IES/member/idCheck", params, idCheckResult, "POST");
}
function idCheckResult(xhr){
	if (xhr.readyState == 4 && xhr.status == 200) {
		var doc = xhr.responseXML;
		var id = getData(doc, "id");
		var msg = getData(doc, "msg");
		var val = getData(doc, "val");
		var idresult = new IDResult();
		if (val == "success") {
			idresult.ok(id, msg);
		} else {
			idresult.no(msg);
		}
	}
}


function getData(doc, id){
	return doc.getElementsByTagName(id).item(0).firstChild.nodeValue;
}
$(function(){
	var idRegx = /^[a-z0-9_]{6,18}$/;
	$("#id").keyup(function(){
		var val = $(this).val();
		if (idRegx.test(val)){
			idCheck(val);
		}else{
			var idresult = new IDResult();
			idresult.no("6~18자리의 영문/숫자 조합");
		}
	});
	var pwdRegx = /^[a-z0-9_]{6,18}$/;
	$("#pswd1").keyup(function(){
		var val = $(this).val();
		if(pwdRegx.test(val)){
			document.frmjoin.pwdChk.value = "true";
			$("#pswd1Msg").hide();
		} else {
			document.frmjoin.pwdChk.value = "false";
			$("#pswd1Msg").text("6~18자리의 영문/숫자 조합");
			$("#pswd1Msg").show();
		}
	})
	$("#pswd2").keyup(function(){
		var val = $(this).val();
		var pswd = document.frmjoin.user_pwd.value;
		if (val != pswd) {
			$("#pswd2Msg").show();
		} else {
			$("#pswd2Msg").hide();
		}
	})
  $('.num_only').css('imeMode', 'disabled').keypress(function(event) {
		if (event.which && (event.which < 48 || event.which > 57)) {
			event.preventDefault();
		}
	}).keyup(function() {
		if ($(this).val() != null && $(this).val() != '') {
			$(this).val($(this).val().replace(/[^0-9]/g, ''));
		}
	});
	
});

IDResult = function(id, msg){
	this.id = id;
	this.msg = msg;
}
IDResult.prototype={
	ok : function(id, msg){
		$("#idDup").val(id);
		$("#idMsg").text(msg);
		$("#idMsg").removeClass("error");
		$("#idMsg").addClass("nonError");		
	},
	no : function(msg){
		$("#idDup").val("");
		$("#idMsg").text(msg);
		$("#idMsg").removeClass("nonError");
		$("#idMsg").addClass("error");
	}
}

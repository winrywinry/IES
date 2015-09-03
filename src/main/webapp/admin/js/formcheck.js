/**
 * 
 */
function formSubmit(){
	var f = document.insertFrm;
	if (Formchk(f)){
		f.submit();
	}
}
function Formchk(f){
	if (f.user_nm.value == ""){
		alert("이름을 입력해 주세요!");
		f.user_nm.focus();
		return false;
	}
 	if (f.birth.value == ""){
		alert("생년월일을 입력해 주세요!");
		f.birth.focus();
		return false;
	}
	var gender = 0;
	for (var i=0;i<f.gender_yn.length;i++){
		if (f.gender_yn[i].checked){
			gender++;
		}
	}
	if (gender == 0){
		alert("성별을 선택해 주세요!");
		f.gender_yn[0].focus();
		return false;
	}
	if (f.hire.value == ""){
		alert("입사일을 입력해 주세요!");
		f.hire.focus();
		return false;
	}
	if (f.dept.value == ""){
		alert("부서를 입력해 주세요!");
		f.dept.focus();
		return false;
	}
	if (f.job.value == ""){
		alert("직책을 입력해 주세요!");
		f.job.focus();
		return false;
	}
	if (f.line_no.value == ""){
		alert("내선번호를 입력해 주세요!");
		f.line_no.focus();
		return false;
	}
	if (f.phone_no.value == ""){
		alert("연락처를 입력해 주세요!");
		f.phone_no.focus();
		return false;
	}
	if (f.second_no.value == ""){
		alert("비상연락처를 입력해 주세요!");
		f.second_no.focus();
		return false;
	}
	if (f.post.value == ""){
		alert("우편번호찾기를 통해서 주소를 입력해 주세요!");
		f.post.focus();
		return false;
	}
	if (f.address.value == ""){
		alert("우편번호찾기를 통해서 주소를 입력해 주세요!");
		f.address.focus();
		return false;
	}
	if (f.email.value == ""){
		alert("이메일을 입력해 주세요!");
		f.email.focus();
		return false;
	}
	if (f.no.value == ""){
		if (f.profil_picture.value == ""){
			alert("사진을 입력해 주세요!");
			f.profil_picture.focus();
			return false;
		}
	}
	return true;
}

function imageURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            $('#profil').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});
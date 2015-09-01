/**
 * 
 */
$(function(){
      callEditor( "ta1"); 
      callPeriod($("#from, #to"));
      
    if(document.writeFrm.state.value=="update"){
    	document.getElementById("sub").innerHTML = "����";
   		document.getElementById('pagetitle').innerHTML = "�ۼ���";
    }
	$(".chkAll").click(function(){
		var area = $(this).parent().parent();
		area.find('input:checkbox').not(this).prop('checked', this.checked);
	});
	$( "#icons li" ).hover(
		function() {
			$( this ).addClass( "ui-state-hover" );
		},
		function() {
			$( this ).removeClass( "ui-state-hover" );
		}
	);
	$("#category_mod").click(function(){
		var nm = $("#category_nm").val();
		var no = $("#category_no option:selected").val();
		if (nm == '') {
			alert("ī�װ����� �Է��� �ּ���!");
			return false;
		}
		var params = "action=add&nm="+ nm +"&no="+ no;
		new ajax.xhr.Request("/IES/learn/category", params, categoryList, "POST");
	})
	$("#category_del").click(function(){
		var no = $("#category_no option:selected").val();
		if (no == '') {
			alert("�����Ͻ� ī�װ��� ������ �ּ���!");
			return false;
		}
		if (confirm("������ �����Ͻðڽ��ϱ�?")){
			var params = "action=del&no="+ no;
			new ajax.xhr.Request("/IES/learn/category", params, categoryList, "POST");
		}
	})
	$("#test_add").css("cursor", "pointer");
	$("#test_add").click(function(){
		var no = $(this).attr("edu");
		var url = "../test/write?edu="+ no;
		testWinOpen(url);
	})
	$("img.rollover").hover(function(){
		var src = $(this).attr("src").match(/[^\.]+/) + "_over.png";
		$(this).attr("src", src);
	}, function(){
		var src = $(this).attr("src").replace("_over", "");
		$(this).attr("src", src);
	})
});
function testWinOpen(url){
	window.open(url, 'testWin', 'width=400, height=400');
}
function testDel(){
	if (confirm("���� �����Ͻðڽ��ϱ�?")){
		return true;
	} else {
		return false;
	}
}
function categoryList(xhr){
	if (xhr.readyState==4 && xhr.status==200) {
		var jsonData = eval('('+ xhr.responseText +')');
		$("#category_nm").val("");
		categoryReload(jsonData);
	}
}
function categoryReload(jsonData){
	if (jsonData.msg != ""){
		alert(jsonData.msg);
	} else {
		var json = eval(jsonData.data);
		$("#category_no option[value!='']").remove();
		for (var i=0;i<json.length;i++) {
			var option = $("<option value='"+ json[i].no +"'>"+ json[i].nm.replace(" ", "&nbsp;") +"</option>");
			$("#category_no").append(option);
		}
	}
}
function submitchk(){
	var f = document.writeFrm;
	if (FormchkModule(f)){
		f.submit();
	}
	return false;
}

function addTest(json){
	var newDiv = creaetDiv(json);
	$("#testList").append(newDiv);
}
function delTest(json){
	var no = parseInt(json.no) - 1;
	var thisDiv = $("#testList li:eq("+ no +")");
	thisDiv.remove();
}
function modTest(json){
	var no = parseInt(json.no) - 1;
	var oldDiv = $("#testList li:eq("+ no +")");
	var newDiv = creaetDiv(json);
	oldDiv.replaceWith(newDiv);
}
function creaetDiv(json){
	var html = $("<li>"+ json.no +". "+ json.question +"&nbsp;</li>");
	var em = $("<em></em>");
	var mod = "<a href='../test/write?no="+ json.test_no +"' onclick='testWinOpen(this.href); return false;'>����</a>";
	var del = "<a href='../test/delete?no="+ json.test_no +"' target=\"ifm_test\" onclick=\"return testDel();\">����</a>";
	em.append(mod);
	em.append(" | ");
	em.append(del);
	html.append(em);
	return html;
}
function FormchkModule(f){
	oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
	if (f.title.value == ''){
		alert('������ �Է��� �ּ���!');
		f.title.focus();
		return false;
	}
	var dept = 0;
	for (var i=0;i<f.dept_no.length;i++){
		if (f.dept_no[i].checked == true){
			dept++;
		}
	}
	if (dept == 0){
		alert("�����μ��� ������ �ּ���!");
		f.dept_no[0].focus();
		return false;
	}
	var job = 0;
	for (var i=0;i<f.job_no.length;i++){
		if (f.job_no[i].checked == true){
			job++;
		}
	}
	if (job == 0){
		alert("������å�� ������ �ּ���!");
		f.job_no[0].focus();
		return false;
	}
	if (f.category_no.value == ""){
		alert("ī�װ��� ������ �ּ���!");
		f.category_no.focus();
		return false;
	}
	if (f.contents.value.length() < 10){
		alert("������ �Է��� �ּ���!");
		return false;
	}
	if (f.period_st.value == ""){
		alert("������¥�� ������ �ּ���!");
		f.period_st.focus();
		return false;
	}
	return true;
}
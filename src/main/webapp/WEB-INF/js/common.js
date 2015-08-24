/**
 * 
 */
function callPeriod(obj, setDate){
	var dftDate = new Date(); 
	if (setDate != null) {
		dftDate = setDate;
	}
	var dates = $(obj).datepicker({
        dateFormat: 'yy-mm-dd',
        monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dayNamesMin : ['일','월','화','수','목','금','토'],
        monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        prevText : '이전달',
        nextText : '다음달',
        defaultDate : dftDate,
        showMonthAfterYear: true,
        showOtherMonths: true,
        selectOtherMonths: true,
        //maxDate :0 ,
        constrainInput: true,
        onSelect: function( selectedDate ) {
     	    var option = this.id == "from" ? "minDate" : "maxDate",
     	      instance = $( this ).data( "datepicker" ),
     	      date = $.datepicker.parseDate(
     	        instance.settings.dateFormat ||
     	        $.datepicker._defaults.dateFormat,
     	        selectedDate, instance.settings );
     	    dates.not( this ).datepicker( "option", option, date );
     	  }
    });
}
function setDate(obj, setDate){
	alert(setDate);
	$(obj).datepicker({
		defaultDate :setDate
	});
}


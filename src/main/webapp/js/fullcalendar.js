/**
 * 
 */
$(document).ready(function() {
	$.ajax({
		  url:"calendar"
        , type:"POST"
        , success:function(data){
        	callCalendar(eval(data));
        }
	})

});
function callCalendar(jsonData){
	$('#calendar').fullCalendar({
		defaultDate: new Date(),
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events: jsonData
	});
}
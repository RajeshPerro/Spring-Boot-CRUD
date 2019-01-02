$(document).ready(()=>{
	
	$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
	    $("#success-alert").slideUp(500);
	});
	
//	$(".datetimepicker").on("click",myDateFunction);
	 
})

myDateFunction = ()=>{
	 $('#datetimepicker1').datetimepicker();
}
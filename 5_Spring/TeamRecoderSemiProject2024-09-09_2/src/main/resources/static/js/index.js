$(".text_event1").css({opacity : "0"});
setTimeout(function(){
	$(".text_event1").animate({ opacity: 1 }, 1000);
},1000);

$(".text_event2").css({opacity : "0"});
setTimeout(function(){
	$(".text_event2").animate({ opacity: 1 }, 1000);
},2000);

$(".text_event3").css({opacity : "0"});
setTimeout(function(){
	$(".text_event3").animate({ opacity: 1 }, 1000);
},3000);

$(".text_event4").css({opacity : "0"});
setTimeout(function(){
	$(".text_event4").animate({ opacity: 0.7 }, 1000);
},4000);

window.addEventListener("scroll", () => {	
	
	//#14213d
	if (1765 <= window.innerHeight + window.scrollY) {
		$(".main_header").css({ backgroundColor: "#ADD8E6" })
	} else {
		$(".main_header").css({ backgroundColor: "" })
	}
})

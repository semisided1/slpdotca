
$(document).ready(function() {

		
		//things = $('img');
		//$('div.slideshobob').innerhtml("<h1>tada</h1>");
		
		//things[Math.floor(Math.random()*things.length)]);
		
		
		//$('.slideshowbob').fadeOut(1000);
		
			// put contents into slideshow, fade in
		//	$('#fader').fadeIn(1000); 
		//	$("#fader").hide(); 
		//	$("#fader").fadeToggle("slow","linear");
		//	setInterval( timehandler, 20000); 
	
	// $('div.slideshowbob').html("<h1>tada</h1>"); // works
	things = $('.slideshowdata img');
	// alert(things.length);
	
	$('div.slideshowview').html(things[Math.floor(Math.random()*things.length)]);
	
	var timehandler = function() {
		$('div.slideshowview').html(things[Math.floor(Math.random()*things.length)]);
	}
	setInterval( timehandler, 5000);
	
	$('div.menuselect').click(function() {
		$(this).hide();
		$("div.main").show();
		
	});
	
	$('div.photo').click(function() {
		this.hide();
	});
	
	
	$('div.albumname').click(function () {
		
			// get all the urls and show all the pictures easy
			treefrag = $(this).children();
			//alert(treefrag.html());
			$('.view').html( treefrag.html() );
			$('div.main').hide();
			$('div.menuselect').show();
			window.scrollTo(0,0);
			
		});
});
		
		
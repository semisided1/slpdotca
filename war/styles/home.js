
$(document).ready(function() {

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
		
		
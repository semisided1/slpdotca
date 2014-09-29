
$(document).ready(function() {
 alert('ready');
	$('div.albumname').click(function () {
		alert('click');
			// get all the urls and show all the pictures easy
			treefrag = $(this).children();
			$(this).parent().siblings().html( treefrag );
		});
});
		
		
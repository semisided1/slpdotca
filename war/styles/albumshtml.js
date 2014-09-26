
$(document).ready(function() {
		alert('ready');
		$('div.addthisalbum').click(function () {
			alert('post');
		//	$(this).text( $(this).children('xmp').get(0).outerHTML );
		//	$.post('/addalbum',	 { 'data': $(this).children('xmp').get(0).outerHTML   });
		//	$.post('/addalbum',	 { 'data': 'blahxmlchange type to xml or research '  });
			$.post('/addalbum',	'blahxmlchange type to xml or research ');
		});
});
		
/*
 * 
 * 
		
		$(this).text("huh" ) ); 
		
		$.post('/addalbum',	 { 'data': $(this).children('xmp')   }, function(data){ 
		// callback logic
		alert(data) */
	
		
		
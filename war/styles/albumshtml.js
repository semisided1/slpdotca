
$(document).ready(function() {
		alert('ready');
		$('div.addthisalbum').click(function () {
			alert('post');
		//	$(this).text( $(this).children('xmp').get(0).outerHTML );
		//	$.post('/addalbum',	 { 'data': $(this).children('xmp').get(0).outerHTML   });
		//	$.post('/addalbum',	 { 'data': 'blahxmlchange type to xml or research '  });
			
			
			$.ajax({
			    url: '/addalbum',
			    data: {
			        album: $(this).find('xmp').get(0).outerHTML
			    } , 
			    type: 'POST',
			    contentType: "text/xml",
			    dataType: "text",
			    success : function(w,s){alert('success')},
			    error : function (xhr, ajaxOptions, thrownError){  
			        console.log(xhr.status);          
			        console.log(thrownError);
			    } 
			}); 
		});
});
		
/*
 * 
 * 
		
		$(this).text("huh" ) ); 
		
		$.post('/addalbum',	 { 'data': $(this).children('xmp')   }, function(data){ 
		// callback logic
		alert(data) */
	
		
		
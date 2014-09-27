
$(document).ready(function() {
		//alert('ready');
	
	
		$('#clear').click(function () {
			$.ajax({
			    url: '/clear',
			    data: 'none', 
			    type: 'POST',
			    contentType: "text/xml",
			    dataType: "text",
			    success : function(w,s){ location.reload(); },
			    error : function (xhr, ajaxOptions, thrownError){  
			        console.log(xhr.status);          
			        console.log(thrownError);
			    } 
			}); 
		});
	
	
	
	
	
	
		$('div.addthisalbum').click(function () {
			$.ajax({
			    url: '/addalbum',
			    data: {
			        album: $(this).find('xmp').get(0).outerHTML
			    } , 
			    type: 'POST',
			    contentType: "text/xml",
			    dataType: "text",
			    success : function(w,s){ location.reload(); },
			    error : function (xhr, ajaxOptions, thrownError){  
			        console.log(xhr.status);          
			        console.log(thrownError);
			    } 
			}); 
		});
});
		
		
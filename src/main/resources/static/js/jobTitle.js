$('Document').ready(function(){
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(jobTitle, status){
			$('#idEdit').val(jobTitle.id);
			$('#detailsEdit').val(jobTitle.details);
			$('#descriptionEdit').val(jobTitle.description);
			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(jobTitle, status){
			$('#idDetails').val(jobTitle.id);	
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
			
			$('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
		
		
		// country/delete/?id=1
		$('table #deleteButton').on('click' , function(event){
			
			event.preventDefault();
			
			var href=$(this).attr('href');
			
			$('#confirmDeleteButton').attr('href' , href);
			
			$('#deleteModal').modal();
		});
		
		
		
		
});



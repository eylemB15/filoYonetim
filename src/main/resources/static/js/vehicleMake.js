$('Document').ready(function(){
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idEdit').val(vehicleMake.id);
			$('#detailsEdit').val(vehicleMake.details);
			$('#descriptionEdit').val(vehicleMake.description);
			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMake, status){
			$('#idDetails').val(vehicleMake.id);	
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
			$('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
			
			$('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T", " "));
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



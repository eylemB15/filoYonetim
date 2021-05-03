$('Document').ready(function(){
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#ddlCountryEdit').val(location.countryid);
			$('#cityEdit').val(location.city);
			$('#detailsEdit').val(location.details);
			$('#addressEdit').val(location.address);
			$('#descriptionEdit').val(location.description);
			$('#ddlStateEdit').val(location.stateid);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#ddlCountryDetails').val(location.countryid);			
			$('#ddlStateDetails').val(location.stateid);			
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#cityDetails').val(location.city);
			$('#addressDetails').val(location.address);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
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



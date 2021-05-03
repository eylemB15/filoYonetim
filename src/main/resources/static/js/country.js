$('Document').ready(function(){
	$('table #editButton').on('click',function(event){
	
	    event.preventDefault();
	    
	    // /country/findById/?id=1
	    
	    var href=$(this).attr('href');
	    
	    $.get(href , function(country ,status){
			
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
			
	        });
	    
		$('#editModal').modal();
		
		});
		
		
		
		$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);			
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#codeDetails').val(state.code);
			$('#capitalDetails').val(state.capital);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
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



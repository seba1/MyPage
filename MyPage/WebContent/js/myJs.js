
$(document).ready(function(){
	$('#calc').submit(function(){
		$.ajax({
			url: '/MyPage/calculate',
			type: 'POST',
			dataType: 'json',
			data: $('#calc').serialize(),
		    success: function(data){
		    	if(data.isValid){
		    		$('#kmPerDay').val(data.kmPerDay);
		    		$('#kmPerDayCost').val(data.kmPerDayCost);
		    		$('#kmPerWeek').val(data.kmPerWeek);
		    		$('#kmPerWeekCost').val(data.kmPerWeekCost);
		    		$('#kmPerMnyh').val(data.kmPerMnyh);
		    		$('#kmPerMnyhCost').val(data.kmPerMnyhCost);
		    		$('#kmPerYr').val(data.kmPerYr);
		    		$('#kmPerYrCost').val(data.kmPerYrCost);
		    		$('#tripDist').val(data.tripDist);
		    		$('#tripDistCost').val(data.tripDistCost);
		    	}
		    	else{
		    		alert('FAILED FAILED !!!');
		    	}
		    	},
		        error:function(){
		        	alert('Ops! Something went wrong!');
		        }
		});
		return false;
	});
	$('#clear').click(function(){	
		var elems = ["kmPerDay", "kmPerDayCost", "kmPerWeek", "kmPerWeekCost", "kmPerMnyh", "kmPerMnyhCost", "kmPerYr", "kmPerYrCost", "tripDist", "tripDistCost"];
		for (i = 0; i<elems.length; i++){
			$("#"+elems[i]).val("");	
		}
	});
});

/*
$(document).ready(function(){
    $("#calc").submit(function(){
	// Add an event that triggers when the submit
	// button is pressed.
    	
    	// Get the text from the two inputs.
    	var username = $("#username").val();
    	
    	// Ajax POST request, similar to the GET request.
    	$.post("/calcualte",{"username": username}, 
    			function() { // on success
    			$('#displayName').html('not failed');    
            })
            .fail(function() { //on failure
            	$('#displayName').html('FAILED FAILED FAILED FAILED ');
            });
    });
});
*/
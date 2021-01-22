/**
 * 
 */
//Exemption form
$('#articles-checkbox').change(function() {
	if ($('#articles-checkbox').is(':checked')) {
		$('#articles').show();
		$('.articles-files').prop('required', true);
	} else {
		$('#articles').hide();
		$('.articles-files').prop('required', false);
		$('#articles-1').tooltip('hide');
		$('#articles-2').tooltip('hide');		
	}
});

/*$('#irs-exemption-file').change(function() {
	if($('#irs-exemption-file').val()) {
		$('#state-exemption-file').prop('required', false);
	}
});

$('#state-exemption-file').change(function() {
	if($('#state-exemption-file').val()) {
		$('#irs-exemption-file').prop('required', false);
	}
});*/

function enableSubmit() {
	$('#submit-button').prop('disabled', false);
	$('#submit-button').removeClass('btn-danger');
	$('#submit-button').removeClass('cursor-not-allowed');
	$('#submit-button').addClass('btn-primary');
}

function disableSubmit() {
	$('#submit-button').prop('disabled', true);
	$('#submit-button').addClass('btn-danger');
	$('#submit-button').addClass('cursor-not-allowed');
	$('#submit-button').removeClass('btn-primary');
}

function checkFileSize(id) {
	var field = $(id);
	if(field[0].files[0].size > 10000000 || (field[0].files[0].type != 'image/png' && field[0].files[0].type != 'image/jpeg' && field[0].files[0].type != 'application/pdf') ) {
		field[0].value = '';
		field.tooltip('show');
	} else {
		field.tooltip('hide');
	}
}

function submitExemption() {
	var qualifyForNonProfit = false;
	var c = false;
	$('.fund-class-input').each( function() {
		if($(this).prop('checked')) {
			qualifyForNonProfit = true;
			c = true;
		}
	});
	if(!qualifyForNonProfit) {
		c = confirm("One or more qualifying business activities need to be selected to register as non-profit.\n" +
				"You will be sent to the regular Business Registration.\n" +
				"Click OK to proceed or Cancel to remain on this page.\n");
	}	
	return c;
}

//Registration form
function getMinimumDate() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	if(month<10) {
		month = '0'+ month;
	}
	var day = date.getDate();
	if(day<10) {
		day = '0' + day;
	}
	return year + '-' + month + '-' + day;
}
/*
$('#start-date').attr('min', getMinimumDate());
$('#start-date').val(getMinimumDate());*/

$('#business-description').on('input', function(){
    var maxLength = $(this).attr('maxlength');
    var currentLength = $(this).val().length;    
    $('#characters-remaining').text(maxLength - currentLength)	    
});


function toggleMailing() {
	if ($('#mailing-address-checkbox').is(':checked')) {
		$('#mailing-address-form').hide();
	} else {
		$('#mailing-address-form').show();
	}
}

$('#mailing-address-checkbox').change(function() {
	toggleMailing();
});

$('.phone-input').keyup(function () {
	if ($(this).attr('name') == 'phoneAreaCodeContact') {
		if(this.value.length == this.maxLength) {
			$('#phoneStartContact').focus();    
		}
	}
	if ($(this).attr('name') == 'phoneStartContact') {
		if(this.value.length == this.maxLength) {
			$('#phoneEndContact').focus();    
		}
	}			
});

var phone = $('.phone-input');

function submitForm() {
	var inputs = $('#registration-form').find('input');
	for(var i = 0; i < inputs.length; i++) {
		if(inputs[i].id.indexOf("email") == -1) 
			inputs[i].value = inputs[i].value.toUpperCase();
	}	
	
	if ($('#mailing-address-checkbox').is(':checked')) {
		var businessAddress = $('#business-address').find('input, select');
		var mailingAddress = $('#mailing-address').find('input, select');
		for(var i = 0; i < businessAddress.length; i++) {
			if(mailingAddress[i+2].type!='radio') {
				mailingAddress[i+2].value = businessAddress[i].value;
			} else {
				mailingAddress[i+2].checked = businessAddress[i].checked;
			}		
		}		
	}	
}

//Address validation
function submitAddress() {
	var selected = $('.address-selector');
	var index = -1;
	for (var i = 0; i < selected.length; i++) {
		if (selected[i].checked) {
			index = i;
			break;
		}
	}
	
	if(index > -1) {
		$('#stdAddress').val($('#'+index+'-line1').text());
		$('#city-new').val($('#'+index+'-city').text());
		$('#state-new').val($('#'+index+'-state').text());
		$('#zip-new').val($('#'+index+'-zip').text());
	}
	
	selected = $('.address-selector-mailing');
	index = -1;
	for (var i = 0; i < selected.length; i++) {
		if (selected[i].checked) {
			index = i;
			break;
		}
	}
	
	if(index > -1) {
		$('#stdAddress-mailing').val($('#'+index+'-line1-mailing').text());
		$('#city-mailing-new').val($('#'+index+'-city-mailing').text());
		$('#state-mailing-new').val($('#'+index+'-state-mailing').text());
		$('#zip-mailing-new').val($('#'+index+'-zip-mailing').text());
	}
}
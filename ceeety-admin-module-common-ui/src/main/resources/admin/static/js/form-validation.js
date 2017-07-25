$(function ($) {
    $(".form-validate").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $(".form-validate-signin").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $(".form-validate-signup").validate({
        rules: {
            age: {
                range: [0,100]
            }
        },
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-advanced").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-agency").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-campaign").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-creative").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-creative-group").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-tags").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-area").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-terminal").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-plan").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-release").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    $("#form-user").validate({
        errorPlacement: function(error, element)
        {
            error.insertAfter(element);
        }
    });
    jQuery.validator.addMethod("phone", function(value, element) {
		var length = value.length;
		return /^(\d{3,4})?(\-)?\d{7,8}$/.test(value);
	}, "请输入正确的电话号码");
	
	jQuery.validator.addMethod("mobile", function(value, element) {
		var length = value.length;
		return this.optional(element) || length == 11 && /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/.test(value);
	}, "请输入正确的手机号码");

	jQuery.validator.addMethod("fax", function(value, element) {
		return /^(\d{3,4})?(\-)?\d{7,8}$/.test(value);
	}, "请输入正确的传真号");
    
    jQuery.validator.addMethod("postcode",function (value,element){
    	var length = value.length;
    	return this.optional(element) || length == 6 && /^\d{6}$/.test(value);
    },"请输入正确的邮政编码");
    
    jQuery.validator.addMethod("checkPic",function (value,element){
    	var arr = value.split(".");
    	var str = arr[arr.length-1].toString().toLocaleLowerCase();
    	if(str == "jpg" || str == "png"){
    		return true;
    	}else{
    		return false;
    	}
	}, "请上传一张png或jpg格式的图片");
    
    jQuery.validator.addMethod("picture",function (value,element){
    	var arr = value.split(".");
    	var str = arr[arr.length-1].toString().toLocaleLowerCase();
    	if(str == "jpg" || str == "png" || str == "gif" || str == "bmp" || str == "jpeg" ){
    		return true;
    	}else{
    		return false;
    	}
	}, "请上传一张图片");
    
    jQuery.validator.addMethod("Hanzi",function (value,element){
    	return /^[\u4e00-\u9fa5]*$/.test(value);
	}, "只能输入中文");
    
    var validator = $( "#form-advanced" ).validate();
    if(typeof(formErrors) != "undefined"){
		validator.showErrors(formErrors);
    }
});
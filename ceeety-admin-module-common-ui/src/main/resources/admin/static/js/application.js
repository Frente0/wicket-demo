var dataTableLanguage = {
    "sProcessing": "处理中...",
    "sLengthMenu": "显示 _MENU_ 项结果",
    "sZeroRecords": "没有匹配结果",
    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
    "sInfoPostFix": "",
    "sSearch": "搜索:",
    "sUrl": "",
    "sEmptyTable": "表中数据为空",
    "sLoadingRecords": "载入中...",
    "sInfoThousands": ",",
    "oPaginate": {
        "sFirst": "首页",
        "sPrevious": "上页",
        "sNext": "下页",
        "sLast": "末页"
    },
    "oAria": {
        "sSortAscending": ": 以升序排列此列",
        "sSortDescending": ": 以降序排列此列"
    }
}
//post提交数据
function openBlank(action,data,n){
    var form = $("<form/>").attr('action',action).attr('method','post');
    if(n){
        form.attr('target','_blank');
    }
    var input = '';
    $.each(data, function(i,n){
        input += '<textarea type="hidden" name="'+ i +'">' + n + '</textarea>';
    });
    form.append(input).appendTo("body").css('display','none').submit();
}

$(function($) {
    //先判断是否存在function是避免和js原生方法冲突，自定义方法的效率不如原生的高
    //判断当前字符串是否以str开始 
    if (typeof String.prototype.startWith != 'function'){ 
      String.prototype.startWith = function (str){
         return this.slice(0, str.length) == str;
      };
    }
　　　
    //判断当前字符串是否以str结束
    if(typeof String.prototype.endWith != 'function'){
      String.prototype.endWith = function (str){
         return this.slice(-str.length) == str;
      };
    }
    
    //表单日期选择插件
    $('.datetimepicker-default').datetimepicker({
        language:'zh-cn',
        format:'YYYY-MM-DD HH:mm'
    });
    
    //表单日期选择插件
    $('.datetimepicker-ymd').datetimepicker({
        language:'zh-cn',
        format:'YYYY-MM-DD'
    });
    
    //A标签确认提示
    $(document).on("click", ".myAConfirm", function(){
        var url = $(this).data("url");
        var modalConfirm = $('#modal-confirm');
        modalConfirm.find(".btn-primary").click(function(){
            window.location.href = url;
        });
        modalConfirm.modal('show');
    });
    
    //发送客户端指令
    $(document).on("click", ".myAjaxCommand", function(){
        var url = $(this).data("command");
        var modalConfirm = $('#modal-confirm');
        modalConfirm.find(".btn-primary").unbind("click").click(function(){
            $.getJSON(url, function(data) {
                var modalAlert = $('#modal-alert');
                if(data.result){
                    modalAlert.find('.modal-body').text("指令发送成功");
                }else{
                    modalAlert.find('.modal-body').text(data.info);
                }
                modalAlert.modal('show');
            });
        });
        modalConfirm.modal('show');
    });
    
    //广告排期表单
    $("#ruletype").change(function(){
        if("deviceType" == $(this).val()){
            $("#deviceId").hide();
        }else {
            $("#deviceId").show();
        }
    });
    
    //广告排期表单
    $(".myPlanRuleDeviceType").change(function(){
        var deviceTypeId = $(this).val();
        var url = $(this).data("url");
        $.getJSON(url,{deviceTypeId:deviceTypeId}, function(data) {
            if(data.result){
                var d = $("#deviceId");
                d.empty();
                d.append("<option value=''>---请选择设备---</option>");
                $.each(data.data, function (index,item) {
                    d.append("<option value='" + item.deviceId +"'>" + item.name + "</option>");
                });
            }
        });
    });
    
    //紧急通知预览
    $('.myAlertPreview').click(function(){
        $("button.btn-primary").show();
        var url = $(this).data("url");
        var sHTML = $('.myAlertContent').summernote('code');
        openBlank(url, {'inputAlertContent':sHTML}, true)
    });
    
    //软件管理表单类型选择事件
    $("#inputExecType").change(function(){
        if("JAVA" == $(this).val()){
            $(this).parents(".form-group").next(".form-group").hide();
        }else{
            $(this).parents(".form-group").next(".form-group").show();
        }
    });
});

function add0(m){return m<10?'0'+m:m }
function FormatDate(timestamp)
{
  //timestamp是整数，否则要parseInt转换,不会出现少个0的情况

	var time = new Date(timestamp);
	var year = time.getFullYear();
	var month = time.getMonth()+1;
	var date = time.getDate();
	var hours = time.getHours();
	var minutes = time.getMinutes();
	var seconds = time.getSeconds();
	return year+'-'+add0(month)+'-'+add0(date)+' '+add0(hours)+':'+add0(minutes)+':'+add0(seconds);
}
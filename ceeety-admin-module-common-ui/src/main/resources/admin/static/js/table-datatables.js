// INIT DATATABLES
$(function () {
	// Init
    var spinner = $( ".spinner" ).spinner();
    var opt= {
        "lengthMenu": [[10, 20, 50,100, -1], [10, 20, 50,100, "All"]],
        "bSort": true,
        "stateSave": false,
		"aaSorting": [[ 0, "desc" ]],
		language : dataTableLanguage,
    };
    
    if ($("#table_id").hasClass("dataTable-scroll-x")) {
    	opt.sScrollX = "100%";
        opt.bScrollCollapse = true;
    }
    
    //使用异步的分页，需要在页面自定义url地址以及列数组
    if($("#table_id").hasClass("serverPage")){
    	  opt.serverSide=true;
          opt.paging = true;
          opt.processing=true;
          opt.searching= false;
          opt.pagingType = "full_numbers";
          opt.ajax=dataTableUrl;
          opt.aoColumns= aoColumns;
          if(typeof(fnRowCallback)!='undefined'){
        	  opt.fnRowCallback=fnRowCallback;
          }
    }
    
    oTable = $("#table_id").DataTable(opt);
    
});


/*
 * 实现异步分页的步骤 
	1、给页面table自定义thead内的列名(或者使用js生成也可)
	2、如果需要异步分页，在table上添加'serverPage'的class属性
	3、定义异步加载数据的url地址以及附加查询条件,使用data参数传递，名为‘dataTableUrl’
	4、自定义返回的列数组,名为‘aoColumns’
 * 
 * 实现异步搜索功能的步骤
	1、自定义查询的输入框
	2、查询按钮绑定searchFun()事件
 * 
 * (具体后台处理逻辑可参考com.ceeety.web.controller.service.OrderController.getIndexUnConfirmData()方法)
 * (具体前台实例可参考/ceeety-api-webapp/src/main/webapp/WEB-INF/views/luggage/order/index.jsp页面)
 * */

function searchFuns(){
	var time1 = new Date($('#storeStartTime').val()).getTime();
	var time2 = new Date($('#storeEndTime').val()).getTime();
	if($('#userTel').val()!="" &&!(/^1(3|4|5|7|8)[0-9]\d{8}$/.test($('#userTel').val()))){
		toastr.error('错误', '输入的手机号码错误!')
	}else if(time1>=time2){
		toastr.error('错误', '请输入正确时间!')
	}else{
		searchFun();
	}
}

function searchFun(){
	oTable.ajax.reload();
}


//清空查询条件
//具体前台实例可参考/ceeety-api-webapp/src/main/webapp/WEB-INF/views/luggage/order/index.jsp页面
function clearFun(){
	$(".searchCondition").find("input").val("");
	$(".searchCondition").find("select").find("option[value='-1']").attr("selected",true);
}


/**
 * 分转化为元
 * @param fen
 * @returns
 */
function fenToYuan(fen) {
	var yuan = Math.round(fen);
	if (!yuan) {
		return "";
	}
	yuan = yuan.toString()
	var before = yuan.substr(0, yuan.length - 2);
	var end = yuan.substr(yuan.length - 2, 2);
	yuan = before + "." + end;
	var re = /(-?d+)(d{3})/;
	while (re.test(yuan)) {
		yuan = yuan.replace(re, "$1,$2")
	}
	return yuan;
};

$.addHint = function(str){
    var msg = '<p class="fa fa-lightbulb-o" style="font-size: 35px; float:left;margin-top: 10px;margin-right: 10px;"></p>' + str;
    setTimeout(function(){
    	$.notific8(msg);
    }, 3000);
}
//$.addHint("做的好！您成功添加了消息。");
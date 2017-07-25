$(function() {
    
    //管理员编辑紧急通知
    $('#adminInputAlertContent').summernote({
        lang : 'zh-CN',
        height : 300,
        fontsize :'42px',
        toolbar : [
            ['font', ['bold', 'fontsize', 'clear' ] ],
            ['color', [ 'color' ] ],
            ['view', [ 'fullscreen', 'codeview'] ] 
        ]
    });

    //红字按钮
    var RedButton = function(context) {
        var ui = $.summernote.ui;
        // create button
        var button = ui.button({
            contents : '<font style="color:white;font-weight:bold;">红字</font>',
            tooltip : '红色文字',
            click : function() {
                context.invoke('foreColor', 'red');
            }
        });
        return button.render(); // return button as jquery object
    }
    
    //取消按钮
    var CleanButton = function(context) {
        var ui = $.summernote.ui;
        // create button
        var button = ui.button({
            contents : '<i class="note-icon-eraser"></i>',
            tooltip : '清除格式',
            click : function() {
                var sHTML = $('#inputAlertContent').summernote('code');
                $('#inputAlertContent').summernote('code', '<div style="font-size:42px;">' + $(sHTML).text() + '</div>');
            }
        });
        return button.render(); // return button as jquery object
    }
    
    //机场人员编辑紧急通知
    $('#inputAlertContent').summernote({
        lang : 'zh-CN',
        height : 300,
        toolbar : [ 
            [ 'font', [ 'bold' ] ], 
            [ 'fontsize', [ 'fontsize' ] ], 
            [ 'redbutton', ['red'] ], 
            [ 'cleanbutton', ['clean'] ]
        ],
        buttons: {
            red : RedButton,
            clean : CleanButton
        }
    });
    
    //默认字体大小
    $('.note-current-fontsize').text(42);
    $('.note-redbutton').find('button').css('background-color','red');
    
    //默认内容
    if($('.myAlertContent').text() == ""){
        $('.myAlertContent').summernote('code','<div style="font-size:42px;">由于天气原因，本站航班出现大面积延误和取消的情况。给您造成的不便，我们深表歉意。</div>');
    }
});

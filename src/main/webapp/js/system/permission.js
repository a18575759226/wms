/**
 * Created by liu on 2017/6/18.
 */
/*加载权限*/
$(function () {
    $(".btn_reload").click(function () {
        var url = $(this).data("url");
        $.dialog({
            title:"温馨提示",
            content:"你确定要重新加载页面吗?",
            ok:function () {
                $.post(url,function (data) {
                    $.dialog({
                        title:"温馨提示",
                        content:"加载成功",
                        ok:function () {
                            window.location.reload();
                        }
                    })
                })
            },
            cancel:true
        })
    })
})
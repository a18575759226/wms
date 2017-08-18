//提交的时候有在ids的后面有[]就要把它去掉 因为在php的语言中在获取这个值的时候就应该拿[]的括号
jQuery.ajaxSettings.traditional = true;
/** table鼠标悬停换色* */

$(function () {
    // 如果鼠标移到行上时，执行函数
    $(".table tr").mouseover(function () {
        $(this).css({background: "#CDDAEB"});
        $(this).children('td').each(function (index, ele) {
            $(ele).css({color: "#1D1E21"});
        });
    }).mouseout(function () {
        $(this).css({background: "#FFF"});
        $(this).children('td').each(function (index, ele) {
            $(ele).css({color: "#909090"});
        });
    });

    // 这个是从页面上抽取的js代码
    /!*绑定点击事件*!/
    /*$(".btn_input").click(function () {
     window.location.href = "http://localhost/employee_input.action";
     })*/

    //优化代码
    //选中新增的按钮 在给它绑定一个事件是一个点击事件
    $(".btn_input").click(function () {
        //获取当前btn _input 里面的Action值 然后再进行调用
        var url = $(".btn_input").data("url");
        //然后在给这个点击事件添加一个action 然后这个就可以跳转了
        window.location.href = url;
    });
    /*/!*==================*!/*/
    //翻页
    $(".btn_page").click(function () {
        $(":input[name='qo.currentPage']").val($(this).data("page") || $(":input[name='qo.currentPage']")
                    .val());
        $("#searchForm").submit();
    });
    //每页多少条数据
    $(":input[name='qo.pageSize']").change(function () {
        $("#searchForm").submit();
    });


    $(":input[name='qo.pageSize']").change(function () {
        $("#searchForm").submit();
    });

    //给批量删除添加事件
    //获取里面的样式
    /*$(".btn_batchDelete").click(function () {
     //获取批量删除的url
     var url = $(this).data("url");
     //获取到复选框
     //console.log($(".acb:checked")).get(0);
     var  checkedAll = $(".acb:checked").get(0);
     var  ids=[];
     for( var i=0; i< checkedAll.length; i++){
     //打印获取到id
     //console.log(checkedAll[i]);
     //console.log($(checkedAll[i]));
     //在把拿到的装到到一个集合里面
     ids.push($(checkedAll[i]));
     }
     /!*在使用jQuery的post提交方法提交*!/
     $.post(url,{"ids":ids},function () {
     alert("批量删除成功");
     })
     });*/

    //代码优化
    /*$(".btn_batchDelete").click(function () {
     //获取到要删除的url
     var url =$(this).data("url");
     var  ids = $.map($(".acb:checked"),function (item,index,arr) {
     return $(item).data("oid");
     })
     });*/

    //批量删除操作
    /*$(".btn_batchDelete").click(function () {
     var url = $(this).data("url");if($(".acb:checked").size()==0){
     alert("亲,请选择需要删除的数据");
     return;//直接结束方法
     }
     var ids =$.map($(".acb:checked"),function (item,index,arr) {
     return $(item).data("oid");
     })
     $.post(url, {"ids": ids}, function () {
     alert("删除成功");
     window.location.reload();
     })
     });*/

    //下面用就是用artDialog框架写的
    $(".btn_batchDelete").click(function () {
        var url = $(this).data("url");
        if ($(".acb:checked").size() == 0) {
            $.dialog({
                title: "温馨提示",
                content: "亲,请选择需要删除的数据",
                ok: true,
            })
            return;
        }

        //确认删除操作
        $.dialog({
            title: "温馨提示",
            content: "亲,你确定要批量删除码?",
            ok: function () {
                var ids = $.map($(".acb:checked"), function (item, index, srr) {
                    return $(item).data("oid");
                });
                /*使用Jqueryde的post的提交*/
                $.post(url, {"isd": ids}, function () {
                    $.dialog({
                        title: "温馨提示",
                        content: "删除成功",
                        ok: function () {
                            // "重写加载的页面"
                            window.location.reload()
                        }

                    })
                })

            },
            cancel: true,
        })
        //
    })

});

/*删除单个的页面跳转*/

$(function () {
    $(".bth_delete").click(function () {
        var url = $(this).data("url");
        console.log(url)
        $.dialog({
            title: "温馨提示",
            content: "亲,确定要删除码",
            ok: function () {
                $.get(url, function () {
                    $.dialog({
                        title: "温馨提示",
                        content: "删除成功",
                        ok: function () {
                            window.location.reload();
                        }
                    })
                })
            },
            cancel: true
        })
    })
})


/*这个控制页面跳转*/

$(function () {
    $("#mselect").click(function () {
        $(".all_menu option:selected").appendTo($(".selected_menu"))
    });
    $("#mdeselect").click(function () {
        $(".selected_menu option:selected").appendTo($(".all_menu"))
    });
    $("#mselectAll").click(function () {
        $(".all_menu option").append($(".selected_menu"))
    });
    $("#mdeselectAll").click(function () {
        $(".selected_menu option").append($(".all_menu"))
    });
    /*提交的时候选中所有的已选择的列表option*/
    $("#editForm").submit(function () {
        $(".selected_menu option").prop("selected",true)
    })
})






















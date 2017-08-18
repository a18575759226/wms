/**
 * Created by liu on 2017/6/18.
 */
$(function () {
    $("#select").click(function () {
        $(".all_permissions option:selected").appendTo("selected_permissions")
    })
    $("#selectAll").click(function () {
        $(".all_permissions option").append("selected_permissions")
    })
    $("#deselect").click(function () {
        $(".selected_permissions option:selected").appendTo("all_permissions")
    })
    $("#deselectAll").click(function () {
        $(".selected_permissions option").appendTo("all_permissions")
    })
})


/*这个就是给Employee输入 使用这个要用加一个框架*
 /
 */

//绑定表单 这个框架里面只能用分号,隔开
$("#editForm").validate({
    rules: {
        //然后就里属性值
        "employee.name": {
            required: true,
            minlength: 4, /*这个就是最小的长度是4位数*/
        },
        "employee.password": {
            required: true,
            minlength: 4,
        },
        /*验证密码就是直接调用 不要加""*/
        repassword: {
            equalTo: "#password"//就是引用上面的密码做校正
        },
        "employee.email": "email",//这个应该是框架自己封装的
        "employee.age": {
            digits: true,
            range: [18, 60]
        },
        /*下面就是把上面的显示在页面上*/
        messages: {
            "employee:name": {
                required: "用户名不能为空",
                minlength: "用户名的最小为4位数"
            },
            "employee.password": {
                required: "密码不能为空",
                milength: "你的密码不能小于4位数"
            },
            repassword: {
                equalTo: "两次输入的密码不一致"
            },
            "employee.email": "你的email输入不规范",
            "employee.age": {
                digits: "请输入你的年龄",
                range: "年龄范围在18到60岁"
            }
        }


    }
})


/*左右的移动*/
/*#select 就是获取这表单的里面唯一 有多个就是就要引用其他 或者自己定义一个*/
/*selected就是选中的意思 这个地方添加一个点击 这个是单个 多个就不要加selected */
/*当个左移动*/
$(function () {
    $("#select").click(function () {
        $(".all_permission option:selected").appendTo($(".selected_permission"))
    });
    /*全部的左移动*/
    $("#selectAll").click(function () {
        $(".all_permission option").appendTo($(".selected_permission"))
    })
    //从右边移动到左边
    $("#deselect").click(function () {
        $(".selected_permission option:selected").appendTo($(".all_permission"))
    })
    //右边全部移动左边
    $("#deselectAll").click(function () {
        $(".selected_permission").appendTo($(".all_permission"))
    })
    /*这个就是绑定表单 添加一个点击事件*/
    $("#editFrom").submit(function () {
        if ($(".selected_permission option:selected").size() != $(".selected_permission option")) {
            $(".selected_permissions option").prop("selected", true)
        }
    })

    if ($(".selected_permissions option").size()) {
        var arr = $.appendTo;
        map($(".selected_permission option"), function (option) {
            return $(option).attr("value");
        });
        $(".all_permissions option").filter(function (index) {
            return $.inArray($(this).attr("value"), arr) >= 0;
        }).remove();

    }

    /*这个就是跳转到别的Action上面 绑定一个标签a*/
    $("#dleft_tab1 a").click(function () {
        var action = $(this).data("url");
        $("#rightMain").prop("src", action);//这个就是给里面的src进行赋值
    })


})
/*这个就是加载权限*/

$(function () {
    //绑定一个cssclass里面的一个属性
    $(".bth_reload").click(function () {
        //在获取里面的值
        var url = $(this).data("url");
        //调用dialog里面的样式 进行绑定事件
        $.dialog({
            title: "温馨提示",
            content: "你确实要重新加载这个页面吗?",
            ok: function () {
                $.post(url, function () {
                    $.dialog({
                        title:"温馨提示",
                        content:"加载成功",
                        ok:function () {
                            /*这个就是重新加载页面*/
                            window.location.reload()
                        }
                    })
                })
            },
            cancel: true

        })
    })
})

/*重新加载*/
$(function () {
    $(".bth_reload").click(function () {
        var url = $(this).data("url");
        $.dialog({
            title:"温馨提示",
            content:"你确定要加载当前的权限吗?",
            ok:function () {
                $.post(url,function () {
                    $.dialog({
                        title:"温馨提示",
                        content:"加载成功",
                        ok:function () {
                           window.location.reload();
                        }
                    })
                })
            }
        })
    })
})

//就是分页


//给事件添加一个事件
$(function () {
    $(".btn_input").click(function () {
        var url = $(this).data("url");
        window.location.href=url;/*就是赋值一个跳转的地址 这个可以多次使用 */
    })

    /*然后就是翻页*/
    $(".btn_page").click(function () {
        //绑定一事件$$
        $(":input[name='qo.currentPage']")
            .val($(this).data("page")||$(":input[name='qo.currentPage']").val());

    })
    $(":input[name='qo.pageSize']").change(function () {
        $("#se")
    })

})



























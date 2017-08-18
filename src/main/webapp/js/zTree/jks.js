/**
 * Created by liu on 2017/6/22.
 */


//这个就是绑定一个事件
$(function () {
    /*给点击的事件 一个超链接*/
    $("#dleft_tab1").click(function () {
        var action = $(this).("action");
        //这个就是给一个属性进行赋值
        $("#rightMain").attr("src", action)

    })
});

$(function () {
    //这个就是给tabpage2 li 拿到里面的元素
    $("#TabPage2 li").click(function (index, item) {
        $(item).removeClass("selected");
        $(item).find('img').prop("src","..")

    })
})


var setting={
    data:{
        simpleData:{
            enable:true,
        }
    },
    async:{
        enanle:true,
        url:"/systemmenu_queryMenusByParentSn",
        antoParam:["sn=qo.parentSn"]
    },
    callback:{
        onClick:function (event, treeId,treeNode) {
            var  action=treeNode.action;
            $("#rightMain").prop("src")
        }
    }

}



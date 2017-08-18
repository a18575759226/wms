/*
/!* zTree插件加载目录的处理  *!/
var zTree;

var setting = {
	callback : {
		beforeClick : function(treeId, treeNode) {
			$("#rightMain").attr("src", treeNode.path);
			return false;
		}
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "pId",
			rootPId : ""
		}
	}
};

/!*function loadMenu(resourceType, treeObj) {
	menus = {
		"business" : [ {
			"isParent" : true,
			"name" : "业务模块",
			"sn" : "business"
		} ],
		"systemManage" : [ {
			"id" : 1,
			"pId" : 0,
			"name" : "系统管理"
		}, {
			"id" : 2,
			"pId" : 1,
			"name" : "员工管理",
			"path" : "/employee_execute.action"
		}, {
			"id" : 3,
			"pId" : 1,
			"name" : "部门管理",
			"path" : "/department_execute.action"
		}, {
			"id" : 4,
			"pId" : 1,
			"name" : "权限管理",
			"path" : "/permission_execute.action"
		}, {
			"id" : 5,
			"pId" : 1,
			"name" : "角色管理",
			"path" : "/role_execute.action"
		} ,{
			"id" : 6,
			"pId" : 1,
			"name" : "系统管理",
			"path" : "/systemmenu_execute.action"
		}
		],
		"charts" : [ {
			"isParent" : true,
			"name" : "报表",
			"sn" : "charts"
		} ]
	};
	// 将返回的数据赋给zTree
	$.fn.zTree.init($("#dleft_tab1"), setting, menus[resourceType]);
	zTree = $.fn.zTree.getZTreeObj("dleft_tab1");
}*!/

// 加载当前日期
function loadDate() {
	var time = new Date();
	var myYear = time.getFullYear();
	var myMonth = time.getMonth() + 1;
	var myDay = time.getDate();
	if (myMonth < 10) {
		myMonth = "0" + myMonth;
	}
	document.getElementById("day_day").innerHTML = myYear + "." + myMonth + "."
			+ myDay;
}

/!**
 * 隐藏或者显示侧边栏
 * 
 *!/
function switchSysBar(flag) {
	var side = $('#side');
	var left_menu_cnt = $('#left_menu_cnt');
	if (flag == true) { // flag==true
		left_menu_cnt.show(500, 'linear');
		side.css({
			width : '280px'
		});
		$('#top_nav').css({
			width : '77%',
			left : '304px'
		});
		$('#main').css({
			left : '280px'
		});
	} else {
		if (left_menu_cnt.is(":visible")) {
			left_menu_cnt.hide(10, 'linear');
			side.css({
				width : '60px'
			});
			$('#top_nav').css({
				width : '100%',
				left : '60px',
				'padding-left' : '28px'
			});
			$('#main').css({
				left : '60px'
			});
			$("#show_hide_btn").find('img').attr('src',
					'/images/common/nav_show.png');
		} else {
			left_menu_cnt.show(500, 'linear');
			side.css({
				width : '280px'
			});
			$('#top_nav').css({
				width : '77%',
				left : '304px',
				'padding-left' : '0px'
			});
			$('#main').css({
				left : '280px'
			});
			$("#show_hide_btn").find('img').attr('src',
					'/images/common/nav_hide.png');
		}
	}
}

$(function() {
	loadDate();

	$('#TabPage2 li').click(
			function() {
				loadMenu($(this).data("rootmenu"));

				var index = $(this).index();
				$(this).find('img').attr('src',
						'/images/common/' + (index + 1) + '_hover.jpg');
				$(this).css({
					background : '#fff'
				});
				$('#nav_module').find('img').attr('src',
						'/images/common/module_' + (index + 1) + '.png');
				$('#TabPage2 li').each(
						function(i, ele) {
							if (i != index) {
								$(ele).find('img').attr('src',
										'/images/common/' + (i + 1) + '.jpg');
								$(ele).css({
									background : '#044599'
								});
							}
						});

				// 显示侧边栏
				switchSysBar(true);
			});
	loadMenu('business');

	// 显示隐藏侧边栏
	$("#show_hide_btn").click(function() {
		switchSysBar();
	});
});

/!*

$(function () {
	$("#dleft_tab1 a").click(function () {
		var action = $(this).data("url");
		$("#rightMain").prop("src",action);
	})
})
*!/


//==============================================================
//zTrree
//==============================================================

var zNodes={
    "business":[{ id:1, pId:0, isParent:true,name:"业务模块", open:true,sn:"business"}],
    "systemManage": [{ id:2, pId:0, isParent:true,name:"系统管理模块", open:true,sn:"system"}],
    "charts": [{ id:3, pId:0, isParent:true,name:"其他", open:true,sn:"chart"}]
}

var setting = {
    data: {
        simpleData: {
            enable: true //启用简单模式
        }
    },
    callback: {
        onClick: function(event,treeId,treeNode){
            // console.log(treeNode);
            if(treeNode.action){
                //修改frame的src属性来显示页面
                $("#rightMain").prop("src","/"+treeNode.action+".action");
                //设置当前位置的东西
                $("#here_area").html("当前位置："+treeNode.getParentNode().name+"&nbsp;>&nbsp;"+treeNode.name);
            }
        }
    },
    /!*异步加载配置*!/
    async: {
        enable: true,
        url: "/systemMenu_queryMenusByParentSn.action",
        autoParam: ["sn=qo.parentSn"]
    }
};

//用于显示系统菜单的函数
function loadMenus(nodeSn){
    $.fn.zTree.init($("#dleft_tab1"), setting, zNodes[nodeSn]);
}
$(function(){''
    //初始化的时候显示业务模块
    loadMenus("business");
});
*/


/*=============================================*/
/*
//加载当前日期
function loadDate() {
	var time = new Date();
	var myYear = time.getFullYear();
	var myMonth = time.getMonth() + 1;
	var myDay = time.getDate();
	if (myMonth < 10) {
		myMonth = "0" + myMonth;
	}
	// $("#day_day").html(myYear + "." + myMonth + "." + myDay);
	setInterval(function () {
		$("#day_day").html( new Date().toLocaleString()) ;

	},1000)
}

/!**
 * 隐藏或者显示侧边栏
 *
 *!/
function switchSysBar(flag) {
	var side = $('#side');
	var left_menu_cnt = $('#left_menu_cnt');
	if (flag == true) { // flag==true
		left_menu_cnt.show(500, 'linear');
		side.css({
			width: '280px'
		});
		$('#top_nav').css({
			width: '77%',
			left: '304px'
		});
		$('#main').css({
			left: '280px'
		});
	} else {
		if (left_menu_cnt.is(":visible")) {
			left_menu_cnt.hide(10, 'linear');
			side.css({
				width: '60px'
			});
			$('#top_nav').css({
				width: '100%',
				left: '60px',
				'padding-left': '28px'
			});
			$('#main').css({
				left: '60px'
			});
			$("#show_hide_btn").find('img').attr('src',
				'/images/common/nav_show.png');
		} else {
			left_menu_cnt.show(500, 'linear');
			side.css({
				width: '280px'
			});
			$('#top_nav').css({
				width: '77%',
				left: '304px',
				'padding-left': '0px'
			});
			$('#main').css({
				left: '280px'
			});
			$("#show_hide_btn").find('img').attr('src',
				'/images/common/nav_hide.png');
		}
	}
}

// =====================================
$(function () {
	// 加载日期
	loadDate();

});

//============================================
//菜单显示
//============================================
$(function () {
	$("#dleft_tab1 a").click(function () {
		var action=$(this).data("url");
		//根据id获取到iframe
		$("#rightMain").prop("src",action);
	})
})

//============================================
//菜单面板项切换
//============================================
$(function () {
	//给li元素绑定一个而点击事件
	$("#TabPage2 li").click(function(){
		//回到过去
		//去掉所有的样式
		$("#TabPage2 li").removeClass("selected");
		//把图标改成都是原始状态的图标
		//遍历所有的li元素,然后设置器属性
		$.each($("#TabPage2 li"),function (index,item) {
			$(item).find("img").prop("src","/images/common/"+(index+1)+".jpg");
		})
		///images/common/3_hover.jpg
		//图标的改变
		$(this).find("img").prop("src","/images/common/"+($(this).index()+1)+"_hover.jpg")
		//样式的改变
		$(this).addClass("selected");

		//修改菜单标题
		$("#nav_module img").prop("src","/images/common/module_"+($(this).index()+1)+".png");

		//点击事件 加载系统对应的菜单
		var sn=$(this).data("rootmenu");
		// console.log(sn);
		loadMenus(sn);
	});

	// 显示隐藏侧边栏
	$("#show_hide_btn").click(function () {
		switchSysBar();
	});
})

//==============================================================
//zTrree
//==============================================================

var zNodes={
	"business":[{ id:1, pId:0, isParent:true,name:"业务模块", open:false,sn:"business"}],
	"systemManage": [{ id:2, pId:0, isParent:true,name:"系统管理模块", open:false,sn:"system"}],
	"charts": [{ id:3, pId:0, isParent:true,name:"其他", open:false,sn:"chart"}]
}

var setting = {
	data: {
		simpleData: {
			enable: true //启用简单模式
		}
	},
	callback: {
		onClick: function(event,treeId,treeNode){
			// console.log(treeNode);
			if(treeNode.action){
				//修改frame的src属性来显示页面
				$("#rightMain").prop("src","/"+treeNode.action+".action");
				//设置当前位置的东西
				$("#here_area").html("当前位置："+treeNode.getParentNode().name+"&nbsp;>&nbsp;"+treeNode.name);
			}
		}
	},
	/!*异步加载配置*!/
	async: {
		enable: true,
		url: "/systemMenu_queryMenusByParentSn.action",
		autoParam: ["sn=qo.parentSn"]
	}
};

//用于显示系统菜单的函数
function loadMenus(nodeSn){
	$.fn.zTree.init($("#dleft_tab1"), setting, zNodes[nodeSn]);
}
$(function(){''
	//初始化的时候显示业务模块
	loadMenus("business");
});*/

/*=============================================================================*/



$(function () {
	//给点击的超链接标签配置事件
	$('#dleft_tab1 a').click(function () {
		//获取点击标签的action
		var action = $(this).data("action");
		console.debug(action);
		$('#rightMain').attr("src",action);
	})
});
$(function () {
	//菜单项面板的切换
	//获取菜单项面板ul元素中的li元素,配置点击事件
	$('#TabPage2 li').click(function () {
		//每次点击先清除所有样式
		$.each( $('#TabPage2 li'),function (index,item) {
			$(item).removeClass("selected");
			$(item).find('img').prop("src","../../images/common/"+(index+1)+".jpg");
		})

		//点击后将class样式设置为selected
		$(this).addClass("selected")
		//点击后将图标图片更改
		$(this).find('img').prop("src","../../images/common/"+($(this).index()+1)+"_hover.jpg");
		//更改模块标题
		$('#nav_module').find('img').prop("src","../../images/common/module_"+($(this).index()+1)+".png")
		//调用函数加载相应的zTree
		loadMenu($(this).data("rootmenu"));
	})
});

var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	async:{
		enable:true,
		url:"/systemmenu_queryMenusByParentSn",
		autoParam:["sn=qo.parentSn"]
	},
	callback: {
		onClick: function(event, treeId, treeNode) {
			if(treeNode.action){
				//获取每个子节点中的action地址
				var action = treeNode.action;
				//改变主页面显示页面
				$('#rightMain').prop("src","/"+action+".action");
				//主页面显示页面上的导航条
				$('#here_area').html("当前位置：系统&nbsp;>&nbsp;"+treeNode.name);
			}
		}
	}
};

zNodes1 =[
	{ id:1, pId:0, name:"业务模块",isParent:true,open:false,sn:"business"},
];
zNodes2 =[
	{ id:2, pId:0, name:"系统模块",isParent:true,open:false,sn:"system"},
];
zNodes3 =[
	{ id:3, pId:0, name:"报表模块", isParent:true,open:false,sn:"chart"},
];
//定义zNodes的json对象
zNodes={
	"business":zNodes1,
	"systemManage":zNodes2,
	"charts":zNodes3
}
function loadMenu(sn) {
	$.fn.zTree.init($("#dleft_tab1"), setting, zNodes[sn]);
}
//第一次加载页面时加载业务模块的zTree
$(function () {
	$.fn.zTree.init($("#dleft_tab1"), setting, zNodes1);
});
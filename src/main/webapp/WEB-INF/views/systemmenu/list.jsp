<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/artDialog/jquery.artDialog.js?skin=blue"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>PSS-系统菜单管理</title>
    <style>
        .alt td {
            background: black !important;
        }
    </style>
</head>
<body>
<%--<%@include file="/WEB-INF/views/common/common_message.jsp"%>--%>
<s:debug/>
<s:form id="searchForm" action="systemmenu" namespace="/" method="post">
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_bottom">
                        <s:url namespace="/" action="systemmenu_input" var="inputUrl">
                            <s:param name="qo.parentId" value="qo.parentId"/>
                        </s:url>
                        <input type="button" value="新增" class="ui_input_btn01 btn_input"
                                data-url="<s:property value="inputUrl"/>"/>
                    </div>
                </div>
            </div>
        </div>
        <s:a action="systemmenu">根目录</s:a>
        <s:iterator value="#parentList">
            >
            <s:a action="systemmenu">
                <s:param name="qo.parentId" value="id"/>
                <s:property value="name"/>
            </s:a>
        </s:iterator>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tr>
                        <th width="30"><input type="checkbox" id="all"/></th>
                        <th>编号</th>
                        <th>菜单编号</th>
                        <th>菜单名称</th>
                        <th>上级菜单</th>
                        <th>URL</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <s:iterator value="#result.listData">
                        <tr>
                            <td><input type="checkbox" name="IDCheck" class="acb" data-oid="<s:property value="id"/>"/>
                            </td>
                            <td><s:property value="id"/></td>
                            <td><s:property value="sn"/></td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="parent.name" default="根目录"/></td>
                            <td><s:property value="url"/></td>
                            <td>
                                <s:a namespace="/" action="systemmenu_input">
                                    <s:param name="systemmenu.id" value="id"></s:param>
                                    <s:param name="qo.parentId" value="qo.parentId"></s:param>
                                    编辑</s:a>
                                <s:url namespace="/" action="systemmenu_delete" var="deleteUrl">
                                    <s:param name="systemmenu.id" value="id"></s:param>
                                </s:url>
                                <a href="javascript:;" class="btn_delete" data-url="<s:property value="#deleteUrl"/>">
                                    删除
                                </a>
                                <s:a namespace="/" action="systemmenu">
                                    <s:param name="qo.parentId" value="id"></s:param>查看子菜单
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="/WEB-INF/views/common/common_page.jsp" %>
    </div>
</s:form>
</body>
</html>

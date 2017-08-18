<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/artDialog/jquery.artDialog.js?skin=black"></script>
    <script type="text/javascript" src="/js/jquery/jquery.validate.min.js"></script>
     <script type="text/javascript" src="/js/commonAll.js"></script>
    <%--<script>
        <s:if test="hasActionMessages()">
        $(function () {
            $.dialog({
                title:"温馨提示",
                content:"保存成功",
                ok:true
            })
        })
        </s:if>
    </script>--%>
    <title>PSS-账户管理</title>
    <style>
        .alt td {
            background: black !important;
        }
    </style>
    <script type="text/javascript">

    </script>
</head>
<%--<%@include file="/WEB-INF/views/nopermission.jsp"%>--%>
<body>
<s:debug/>
<s:actionerror/>
<s:actionmessage/>
<s:form id="searchForm" action="employee" namespace="/" method="post">
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_center">
                        姓名/邮箱
                            <%--  <input type="text" class="ui_input_txt02" name=""/>--%>
                        <s:textfield name="qo.keyword" class="ui_input_txt02"></s:textfield>
                        所属部门

                        <s:select list="#depts" name="qo.deptId" headerKey="-1" headerValue="全部部门"
                                  listKey="id" listValue="name" cssClass="ui_select01"></s:select>
                    </div>
                    <div id="box_bottom">
                        <input type="button" value="查询" class="ui_input_btn01 btn_page" data_page="1"/>
                            <%--新增这个地方增加一个跳转的连接--%>
                        <input type="button" value="新增" class="ui_input_btn01 btn_input" data-url="<s:url namespace="/" action="employee_input"/>">
                        <input type="button" value="批量删除" class="ui_input_btn01 btn_batchDelete" data-url="<s:url namespace="/" action="employee_batchDelete"/>">

                    </div>
                </div>
            </div>
        </div>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tr>
                        <th width="30"><input type="checkbox" id="all"/></th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>EMAIL</th>
                        <th>年龄</th>
                        <th>所属部门</th>
                        <th>角色</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <s:iterator value="#result.listData">
                        <tr>
                            <%--给id绑定一个属性--%>
                            <td><input type="checkbox" name="IDCheck" class="acb" data-oid=" <s:property value="id"/>"/></td>
                                <%--这个是jsp--%>
                            <td><s:property value="id"/></td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="email"/></td>
                            <td><s:property value="age"/></td>
                            <td><s:property value="dept.name"/></td>
                            <td><s:property value="roleNames"/> </td>
                            <td>
                                    <%--<a href="#">编辑</a>--%>
                                <s:a namespace="/" action="employee_input">编辑
                                    <%--后面的id就是传过来的--%>
                                    <s:param name="e.id" value="id"></s:param>
                                </s:a>
                                <%--<s:a namespace="/" action="employee_delete">删除
                                    <s:param name="e.id" value="id"></s:param>
                                </s:a>--%>
                                 <s:url namespace="/" action="employee_delete" var="deleteUrl">
                                     <s:param name="e.id" value="id"><</s:param>
                                 </s:url>

                                <a href="javascript:;" class="btn_delete" data-url="<s:property value="#deleteUrl"/>">删除</a>
                                    <%--<a href="#">删除</a>--%>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
              <%--  这个引入分页的效果--%>
                <%@include file="/WEB-INF/views/common/common_page.jsp"%>
        </div>
    </div>
</s:form>
</body>
</html>

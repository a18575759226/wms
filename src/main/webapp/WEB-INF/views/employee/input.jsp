<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/artDialog/jquery.artDialog.js?skin=black"></script>
    <script type="text/javascript" src="/js/jquery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/js/system/employee.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <script>
        <s:if test="hasActionMessages()">
        $(function () {
            $.dialog({
                title:"温馨提示",
                content:"保存成功",
                ok:true
            })
        })
        </s:if>

        <s:if test="hasActionErrors()">
        $(function () {
            $.dialog({
                title:"温馨提示",
                content:"保存成功",
                ok:true
            })
        })
        </s:if>
    </script>
    <script>
        /*就是这个validate只能打分号*/
        $(function () {
            $("#editForm").validate({
                rules:{
                    'e.name' : {
                        required:true,
                        minlength:2,
                    },
                    'e.password':{
                        required:true,
                        minlength:2,
                    },
                    'repassword':{
                        equalTo:"#password",
                    },
                    'e.email':{
                       email:true,
                    },
                    'e.age':{
                       range:[18,61],
                        digits:true,
                    },
                },
                messages:{
                    'e.name':{
                        required:"用户名不能为空",
                        minlength:"最小的长度4位",
                    },
                    'e.password':{
                        required:"用户名不能为空",
                        minlength:"最小的长度4位",
                    },
                    'repassword':{
                        equalTo:"重复密码",
                    },
                    'e.email':{
                        email:"请输入合法的邮箱",
                    },
                    'e.age':{
                        range:[18,61],
                        digits:true,
                    },
                },
            })
        })

    </script>
</head>
<body>

<%--执行页面的跳转--%>
<s:form name="editForm" namespace="/" action="employee_saveOrUpdate" method="post" id="editForm">
    <%--这个地方要带id过去--%>
    <s:hidden name="e.id"></s:hidden>
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;">用户编辑</span>
            <div id="page_close">
                <a>
                    <img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="140">用户名</td>
                    <td class="ui_text_lt">
                       <%-- <input name="" class="ui_input_txt02"/>--%>
                        <s:textfield name="e.name" class="ui_input_txt02" ></s:textfield>
                    </td>
                </tr>
            <s:if test="e.id ==null">
                <tr>
                    <td class="ui_text_rt" width="140">密码</td>
                    <td class="ui_text_lt">
                        <%--<input type="password" name="" id="password" class="ui_input_txt02"/>--%>
                        <s:textfield name="e.password" class="ui_input_txt02"  id="password"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">验证密码</td>
                    <td class="ui_text_lt">
                        <s:textfield name="repassword" class="ui_input_txt02"></s:textfield>
                    </td>
                </tr>
            </s:if>
                <tr>
                    <td class="ui_text_rt" width="140">Email</td>
                    <td class="ui_text_lt">
                        <s:textfield name="e.email"  class="ui_input_txt02"></s:textfield>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">年龄</td>
                    <td class="ui_text_lt">
                        <s:textfield name="e.age" class="ui_input_txt02"></s:textfield>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">所属部门</td>
                    <td class="ui_text_lt">
                          <s:select list="#depts" name="e.dept.id"
                             listKey="id" listValue="name" class="ui_select01"></s:select>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">超级管理员</td>
                    <td class="ui_text_lt">
                   <%--     <input type="checkbox" name="" class="ui_checkbox01"></input>--%>
                        <s:checkbox name="e.admin" class="ui_checkbox01"></s:checkbox>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">角色</td>
                    <td class="ui_text_lt">
                        <table>
                            <%--<tr>
                                <td>
                                    &lt;%&ndash;<select multiple="true" class="ui_multiselect01"></select>&ndash;%&gt;
                                    <s:select list="#roles" listKey="id" listValue="name"
                                              multiple="true" cssclass="ui_multiselect01  all_roles"/>
                                </td>
                                <td align="center">
                                    <input type="button" id="select" value="-->" class="left2right"/><br/>
                                    <input type="button" id="selectAll" value="==>" class="left2right"/><br/>
                                    <input type="button" id="deselect" value="<--" class="left2right"/><br/>
                                    <input type="button" id="deselectAll" value="<==" class="left2right"/>
                                </td>
                                <td>
                                   &lt;%&ndash; <select multiple="true" class="ui_multiselect01"></select>&ndash;%&gt;
                                    <s:select list="e.roles" name="e.roles.id" multiple="true" listValue="name" listKey="id"
                                              cssClass="ui_multiselect01 selected_roles"/>
                                </td>
                            </tr>--%>

                            <%--==============================================--%>
                             <tr>
                                 <td>
                                         <%--<s:select list="#permissions"
                                             listKey="id" listValue="name" multiple="true"
                                             cssClass="ui_multiselect01 all_permissions" />--%>
                                     <s:select list="#roles" listKey="id" listValue="name"
                                               multiple="true" cssClass="ui_multiselect01 all_permissions"/>


                                 </td>
                                 <td align="center">
                                     <input type="button" id="select" value="--->"
                                            class="left2right" />
                                     <br />
                                     <input type="button" id="selectAll" value="==>"
                                            class="left2right" />
                                     <br />
                                     <input type="button" id="deselect" value="<---"
                                            class="left2right" />
                                     <br />
                                     <input type="button" id="deselectAll" value="<=="
                                            class="left2right" />
                                 </td>
                                 <td>
                                         <%--<s:select name="r.permissions.id" list="r.permissions"
                                             listKey="id" listValue="name" multiple="true"
                                             cssClass="ui_multiselect01 selected_permissions" />--%>
                                     <s:select list="e.roles" name="e.roles.id"
                                               listKey="id" listValue="name" multiple="true"
                                               cssClass="ui_multiselect01   selected_permissions"/>

                                 </td>
                             </tr>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td class="ui_text_lt">
                        &nbsp;<input type="submit" value="确定保存" class="ui_input_btn01"/>
                        &nbsp;<input id="cancelbutton" type="button" value="重置" class="ui_input_btn01"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    </s:form>
</body>
</html>
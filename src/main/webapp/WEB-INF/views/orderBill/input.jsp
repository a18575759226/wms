<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css"/>
    <link href="/style/common_style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery-validate/jquery.validate.min.js"></script>
</head>
<body>
<!-- =============================================== -->
<%@include file="/WEB-INF/views/common/common_message.jsp"%>
<s:form name="editForm" namespace="/" action="orderBill_saveOrUpdate" method="post" id="editForm">
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;">采购订单编辑</span>
            <div id="page_close">
                <a>
                    <img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <s:hidden name="orderBill.id"></s:hidden>
                            <tr>
                                <td class="ui_text_rt" width="140">业务时间</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.vdata" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">订单编码</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.sn" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">审核人</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.auditor" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">订单明细</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.items" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">审核状态</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.status" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">审核时间</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.auditTime" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">录入时间</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.inputTime" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">采购总金额</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.totalAmount" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">采购总数量</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.totalNumber" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">录入人</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.inputUser" cssClass="ui_input_txt02" ></s:textfield>
                                </td>
                            </tr>
                            <tr>
                                <td class="ui_text_rt" width="140">供应商</td>
                                <td class="ui_text_lt">
                                    <s:textfield name="orderBill.supplier" cssClass="ui_input_txt02" ></s:textfield>
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
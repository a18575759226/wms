<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="style/common_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/js/fancyBox/jquery.fancybox.css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/artDialog/jquery.artDialog.js?skin=blue"></script>
    <script type="text/javascript" src="/js/fancyBox/jquery.fancybox.pack.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>

    <title>PSS-商品管理管理</title>
    <script>
        $(function () {
            $('.fancybox').fancybox();
        })
    </script>
    <style>
        .alt td {
            background: black !important;
        }
    </style>
</head>
<body>
<%--<%@include file="/WEB-INF/views/common/common_message.jsp"%>--%>
<s:form id="searchForm" action="product" namespace="/" method="post">
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_center">
                        姓名/邮箱
                        <s:textfield name="qo.keyword" class="ui_input_txt02"/>
                              所属部门
                              <s:select list="#brands" listKey="id" listValue="name" name="qo.brandId"
                                        headerKey="-1" headerValue="全部" class="ui_select01"/>
                    </div>
                    <div id="box_bottom">
                                                    <input type="button" value="查询" class="ui_input_btn01 btn_page"  data-page="1"/>
                        <input type="button" value="新增" class="ui_input_btn01 btn_input"
                               data-url="<s:url namespace="/" action="product_input"/>"/>
                            <%--          <input type="button" value="批量删除" class="ui_input_btn01 btn_batchDelete"
                                             data-url="<s:url namespace="/" action="product_batchDelete"/>"/>--%>
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
                        <th>货品图片</th>
                        <th>货品名称</th>
                        <th>货品编码</th>
                        <th>货品品牌</th>
                        <th>成本价格</th>
                        <th>销售价格</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <s:iterator value="#result.listData">
                        <tr>
                            <td><input type="checkbox" name="IDCheck" class="acb" data-oid="<s:property value="id"/>"/>
                            </td>
                                <%--   <td><s:property value="id"/></td>
                                   <td><s:property value="costPrice"/></td>--%>
                                <%--<td><s:property value="imagePath"/></td>--%>
                            <td>
                                <a class="fancybox" href="<s:property value="imagePath"/>"
                                   title="<s:property value="name"/>">
                                    <img src="<s:property value="smallImagePath"/>" width="50" >
                                </a>

                            </td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="sn"/></td>
                            <td><s:property value="brand.name"/></td>
                            <td><s:property value="costPrice"/></td>
                            <td><s:property value="salePrice"/></td>
                            <td>
                                <s:a namespace="/" action="product_input">
                                    <s:param name="product.id" value="id"></s:param>
                                    编辑</s:a>
                                <s:url namespace="/" action="product_delete" var="deleteUrl">
                                    <s:param name="product.id" value="id"></s:param>
                                </s:url>
                                <a href="javascript:;" class="bth_delete" data-url="<s:property value="#deleteUrl"/>">
                                    删除
                                </a>
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

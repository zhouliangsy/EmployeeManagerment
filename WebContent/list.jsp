<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#999"> 厂商管理</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
   		<th width="450">公司名称</th>
   		<th  width="450">编辑</th>
   	</tr>
</thead>
<tbody>
	<s:iterator value="list" var="c">
	<tr>
		<td align="center"><s:property value="#c.cname"/></td>
		<td align="center"><a href="addCompany.jsp">添加</a></td>
	</tr>
	</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/></span>&nbsp;&nbsp;
   <apan>
   <s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath }/company_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/company_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if>
   <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath }/company_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/company_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>
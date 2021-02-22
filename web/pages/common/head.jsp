<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 2020/7/25
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath =request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
    request.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">
<%--<link rel="stylesheet" type="text/css" media="screen" href="static/css/jquery-ui-1.7.1.custom.css" />--%>

<%--<link rel="stylesheet" type="text/css" media="screen" href="static/css/ui.jqgrid.css" />--%>

<%--<link rel="stylesheet" type="text/css" media="screen" href="static/css/jquery.searchFilter.css" />--%>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<%--<script src="static/script/grid.loader.js" type="text/javascript"></script>--%>


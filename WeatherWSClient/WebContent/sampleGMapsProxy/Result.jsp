<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleGMapsProxyid" scope="session" class="tools.GMapsProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleGMapsProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleGMapsProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleGMapsProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        tools.GMaps getGMaps10mtemp = sampleGMapsProxyid.getGMaps();
if(getGMaps10mtemp == null){
%>
<%=getGMaps10mtemp %>
<%
}else{
        if(getGMaps10mtemp!= null){
        String tempreturnp11 = getGMaps10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String ori_1id=  request.getParameter("ori16");
            java.lang.String ori_1idTemp = null;
        if(!ori_1id.equals("")){
         ori_1idTemp  = ori_1id;
        }
        String dest_2id=  request.getParameter("dest18");
            java.lang.String dest_2idTemp = null;
        if(!dest_2id.equals("")){
         dest_2idTemp  = dest_2id;
        }
        tools.WeatherInfo[] googleMap13mtemp = sampleGMapsProxyid.googleMap(ori_1idTemp,dest_2idTemp);
if(googleMap13mtemp == null){
%>
<%=googleMap13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(googleMap13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(googleMap13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>
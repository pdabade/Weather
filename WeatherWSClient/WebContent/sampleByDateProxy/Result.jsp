<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleByDateProxyid" scope="session" class="tools.ByDateProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleByDateProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleByDateProxyid.getEndpoint();
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
        sampleByDateProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        tools.ByDate getByDate10mtemp = sampleByDateProxyid.getByDate();
if(getByDate10mtemp == null){
%>
<%=getByDate10mtemp %>
<%
}else{
        if(getByDate10mtemp!= null){
        String tempreturnp11 = getByDate10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String zip_1id=  request.getParameter("zip16");
            java.lang.String zip_1idTemp = null;
        if(!zip_1id.equals("")){
         zip_1idTemp  = zip_1id;
        }
        String city_2id=  request.getParameter("city18");
            java.lang.String city_2idTemp = null;
        if(!city_2id.equals("")){
         city_2idTemp  = city_2id;
        }
        tools.WeatherInfo[] dataByDate13mtemp = sampleByDateProxyid.dataByDate(zip_1idTemp,city_2idTemp);
if(dataByDate13mtemp == null){
%>
<%=dataByDate13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(dataByDate13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(dataByDate13mtemp);
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
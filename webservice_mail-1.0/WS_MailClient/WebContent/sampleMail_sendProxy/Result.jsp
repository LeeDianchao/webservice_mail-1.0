<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H2><font color=Olive>运行结果</font></H2>

<jsp:useBean id="sampleMail_sendProxyid" scope="session" class="Mail.Mail_sendProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMail_sendProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleMail_sendProxyid.getEndpoint();
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
        sampleMail_sendProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Mail.Mail_send getMail_send10mtemp = sampleMail_sendProxyid.getMail_send();
if(getMail_send10mtemp == null){
%>
<%=getMail_send10mtemp %>
<%
}else{
        if(getMail_send10mtemp!= null){
        String tempreturnp11 = getMail_send10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String url_1id=  request.getParameter("url16");
            java.lang.String url_1idTemp = null;
        if(!url_1id.equals("")){
         url_1idTemp  = url_1id;
        }
        String payload_2id=  request.getParameter("payload18");
            java.lang.String payload_2idTemp = null;
        if(!payload_2id.equals("")){
         payload_2idTemp  = payload_2id;
        }
        boolean sendEmail13mtemp = sampleMail_sendProxyid.sendEmail(url_1idTemp,payload_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendEmail13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String url_3id=  request.getParameter("url23");
            java.lang.String url_3idTemp = null;
        if(!url_3id.equals("")){
         url_3idTemp  = url_3id;
        }
        boolean validateEmailAddress20mtemp = sampleMail_sendProxyid.validateEmailAddress(url_3idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validateEmailAddress20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
case 25:
        gotMethod = true;
        String urls_4id=  request.getParameter("urls28");
            java.lang.String urls_4idTemp = null;
        if(!urls_4id.equals("")){
         urls_4idTemp  = urls_4id;
        }
        String payload_5id=  request.getParameter("payload30");
            java.lang.String payload_5idTemp = null;
        if(!payload_5id.equals("")){
         payload_5idTemp  = payload_5id;
        }
        boolean sendEmails25mtemp = sampleMail_sendProxyid.sendEmails(urls_4idTemp,payload_5idTemp);
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendEmails25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
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
<%@page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
</HEAD>
<BODY>
<H2><font color=Navy>输入界面</font></H2>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H2>getEndpoint</H2>
<BR>
<INPUT TYPE="SUBMIT" VALUE="运行">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 5:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>setEndpoint</H3>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">endpoint:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="endpoint8" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="运行">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 10:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>getMail_send</H3>
<BR>
<INPUT TYPE="SUBMIT" VALUE="运行">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 13:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>" >
<H3>邮件发送</H3>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">邮箱地址:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url16" SIZE=30></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">邮件内容:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="payload18" SIZE=60></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="发送">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 20:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>验证邮箱</H3>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">邮箱地址:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url23" SIZE=30></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="验证">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 25:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>批量邮件<font size=2 color=Purple><u>(邮箱地址以","分隔)</u></font></H3>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">邮箱地址:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="urls28" SIZE=60></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">邮件内容:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="payload30" SIZE=60></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="发送">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 1111111111:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>输入界面</H3>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">URLString:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url1111111111" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="发送">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
case 1111111112:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<H3>输入界面</H3>
<BR>
<INPUT TYPE="SUBMIT" VALUE="发送">
<INPUT TYPE="RESET" VALUE="清空">
</FORM>
<%
break;
}
if (valid) {
%>
请选择功能.
<%
}
%>

</BODY>
</HTML>

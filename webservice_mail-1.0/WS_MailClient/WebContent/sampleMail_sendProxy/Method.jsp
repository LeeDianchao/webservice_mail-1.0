<%@page contentType="text/html;charset=UTF-8"%><HTML>
<HEAD>
<TITLE>Methods</TITLE>
</HEAD>
<BODY>
<H2>功能列表</H2>
<UL>
<LI>
<H10><span style="color:blue">发送邮件:</span></H10>
<A HREF="Input.jsp?method=13" TARGET="inputs"> sendEmail(java.lang.String,java.lang.String)</A>
</LI>
<LI>
<H10><span style="color:blue">批量邮件:</span></H10>
<A HREF="Input.jsp?method=25" TARGET="inputs"> sendEmails(java.lang.String,java.lang.String)</A>
</LI>
<LI>
<H10><span style="color:blue">验证邮箱:</span></H10>
<A HREF="Input.jsp?method=20" TARGET="inputs"> validateEmailAddress(java.lang.String)</A>
</LI>
<%--
<LI><A HREF="Input.jsp?method=2" TARGET="inputs"> getEndpoint()</A></LI>
<LI><A HREF="Input.jsp?method=5" TARGET="inputs"> setEndpoint(java.lang.String)</A></LI>
<LI><A HREF="Input.jsp?method=10" TARGET="inputs"> getMail_send()</A></LI>
--%>
</UL>
</BODY>
</HTML>
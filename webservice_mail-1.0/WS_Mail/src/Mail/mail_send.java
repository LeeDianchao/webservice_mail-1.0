package Mail;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import com.aliyun.mns.common.utils.ServiceSettings;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class mail_send
{
	//邮件地址为url，内容为payload
	public boolean sendEmail(String url,String payload)
	{
		IAcsClient client;
		SingleSendMailRequest request;
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ServiceSettings.getMNSAccessKeyId(),ServiceSettings.getMNSAccessKeySecret());
	    client = new DefaultAcsClient(profile);
	    request = new SingleSendMailRequest();
		try {
	        request.setAccountName("lidianchao@aliyunmns.xyz");//控制台创建的发信地址
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//控制台创建的标签
	        request.setReplyToAddress(true);
	        if(validateEmailAddress(url)==true)
	        {
	        	request.setToAddress(url);
	        	request.setSubject("主题");
	        	request.setHtmlBody(payload);
	        	SingleSendMailResponse httpResponse = client.getAcsResponse(request);
	        }
	        else
	        {
	        	throw new Exception("邮箱地址无效!");
	        }
	    } catch (ServerException e) {
	        e.printStackTrace();
	        return false;
	    }
	    catch (ClientException e) {
	        e.printStackTrace();
	        return false;
	    }
		catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("邮箱地址无效!");
	        return false;
	    }
		return true;
	}
	
	//批量发送邮件
	public boolean sendEmails(String urls,String payload)
	{
		IAcsClient client;
		SingleSendMailRequest request;
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ServiceSettings.getMNSAccessKeyId(),ServiceSettings.getMNSAccessKeySecret());
	    client = new DefaultAcsClient(profile);
	    request = new SingleSendMailRequest();
	    String []url=null;
	      
	    url = urls.split(",");
		try {
	        request.setAccountName("lidianchao@aliyunmns.xyz");//控制台创建的发信地址
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//控制台创建的标签
	        request.setReplyToAddress(true);
	        
	        String Email="";
	        for(int i=0;i<url.length;i++)
	        {
                System.out.println(url[i]);
                if(validateEmailAddress(url[i]))
                {
                	if(i==0)
                	{
                		Email=url[i];
                	}
                	else
                	{
                		Email=Email+","+url[i];
                	}
                }
                else
                {
                	System.out.println("第"+(i+1)+"个邮箱地址无效："+url[i]);
                }
                
            }
	        if(Email=="")
	        {
	        	throw new Exception("邮箱地址无效!");
	        }
	        else
	        {
	        	request.setToAddress(Email);
	        	request.setSubject("主题");
		        request.setHtmlBody(payload);
		        SingleSendMailResponse httpResponse = client.getAcsResponse(request);
	        }
	        
	    } catch (ServerException e) {
	        e.printStackTrace();
	        return false;
	    }
	    catch (ClientException e) {
	        e.printStackTrace();
	        return false;
	    }
		catch (Exception e) {
	        e.printStackTrace();
	        
	        return false;
	    }
		return true;
	}
	
	//批量发送邮件
	public boolean sendEmailBatch(String[] url,String payload)
	{
		IAcsClient client;
		SingleSendMailRequest request;
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ServiceSettings.getMNSAccessKeyId(),ServiceSettings.getMNSAccessKeySecret());
	    client = new DefaultAcsClient(profile);
	    request = new SingleSendMailRequest();
		try {
	        request.setAccountName("lidianchao@aliyunmns.xyz");//控制台创建的发信地址
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//控制台创建的标签
	        request.setReplyToAddress(true);
	        
	        String Email="";
	        for(int i=0;i<url.length;i++)
	        {
                System.out.println(url[i]);
                if(validateEmailAddress(url[i]))
                {
                	if(i==0)
                	{
                		Email=url[i];
                	}
                	else
                	{
                		Email=Email+","+url[i];
                	}
                }
                else
                {
                	System.out.println("第"+(i+1)+"个邮箱地址无效："+url[i]);
                }
                
            }
	        if(Email=="")
	        {
	        	throw new Exception("邮箱地址无效!");
	        }
	        else
	        {
	        	request.setToAddress(Email);
	        	request.setSubject("主题");
		        request.setHtmlBody(payload);
		        SingleSendMailResponse httpResponse = client.getAcsResponse(request);
	        }
	        
	    } catch (ServerException e) {
	        e.printStackTrace();
	        return false;
	    }
	    catch (ClientException e) {
	        e.printStackTrace();
	        return false;
	    }
		catch (Exception e) {
	        e.printStackTrace();
	        
	        return false;
	    }
		return true;
	}
	
	
	//验证是否为有效的邮件地址
	public boolean validateEmailAddress(String url)
	{
		if (!url.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return false;
        }
  
        String host = "";
        String hostName = url.split("@")[1];
        Record[] result = null;
        SMTPClient client = new SMTPClient();
  
        try {
            // 查找MX记录
            Lookup lookup = new Lookup(hostName, Type.MX);
            lookup.run();
            if (lookup.getResult() != Lookup.SUCCESSFUL) {
                return false;
            } else {
                result = lookup.getAnswers();
            }
  
            // 连接到邮箱服务器
            for (int i = 0; i < result.length; i++) {
                host = result[i].getAdditionalName().toString();
                client.connect(host);
                if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
                    client.disconnect();
                    continue;
                } else {
                    break;
                }
            }
  
            //以下2项自己填写快速的，有效的邮箱
            client.login("163.com");
            client.setSender("sxgkwei@163.com");
            client.addRecipient(url);
            if (250 == client.getReplyCode()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
            }
        }
        return false;
	}
	
}

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
	//�ʼ���ַΪurl������Ϊpayload
	public boolean sendEmail(String url,String payload)
	{
		IAcsClient client;
		SingleSendMailRequest request;
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ServiceSettings.getMNSAccessKeyId(),ServiceSettings.getMNSAccessKeySecret());
	    client = new DefaultAcsClient(profile);
	    request = new SingleSendMailRequest();
		try {
	        request.setAccountName("lidianchao@aliyunmns.xyz");//����̨�����ķ��ŵ�ַ
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//����̨�����ı�ǩ
	        request.setReplyToAddress(true);
	        if(validateEmailAddress(url)==true)
	        {
	        	request.setToAddress(url);
	        	request.setSubject("����");
	        	request.setHtmlBody(payload);
	        	SingleSendMailResponse httpResponse = client.getAcsResponse(request);
	        }
	        else
	        {
	        	throw new Exception("�����ַ��Ч!");
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
	        System.out.println("�����ַ��Ч!");
	        return false;
	    }
		return true;
	}
	
	//���������ʼ�
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
	        request.setAccountName("lidianchao@aliyunmns.xyz");//����̨�����ķ��ŵ�ַ
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//����̨�����ı�ǩ
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
                	System.out.println("��"+(i+1)+"�������ַ��Ч��"+url[i]);
                }
                
            }
	        if(Email=="")
	        {
	        	throw new Exception("�����ַ��Ч!");
	        }
	        else
	        {
	        	request.setToAddress(Email);
	        	request.setSubject("����");
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
	
	//���������ʼ�
	public boolean sendEmailBatch(String[] url,String payload)
	{
		IAcsClient client;
		SingleSendMailRequest request;
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ServiceSettings.getMNSAccessKeyId(),ServiceSettings.getMNSAccessKeySecret());
	    client = new DefaultAcsClient(profile);
	    request = new SingleSendMailRequest();
		try {
	        request.setAccountName("lidianchao@aliyunmns.xyz");//����̨�����ķ��ŵ�ַ
	        request.setFromAlias("aliyunmns.xyz");
	        request.setAddressType(1);
	        request.setTagName("test");//����̨�����ı�ǩ
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
                	System.out.println("��"+(i+1)+"�������ַ��Ч��"+url[i]);
                }
                
            }
	        if(Email=="")
	        {
	        	throw new Exception("�����ַ��Ч!");
	        }
	        else
	        {
	        	request.setToAddress(Email);
	        	request.setSubject("����");
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
	
	
	//��֤�Ƿ�Ϊ��Ч���ʼ���ַ
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
            // ����MX��¼
            Lookup lookup = new Lookup(hostName, Type.MX);
            lookup.run();
            if (lookup.getResult() != Lookup.SUCCESSFUL) {
                return false;
            } else {
                result = lookup.getAnswers();
            }
  
            // ���ӵ����������
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
  
            //����2���Լ���д���ٵģ���Ч������
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

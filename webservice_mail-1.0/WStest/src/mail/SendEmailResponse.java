
package mail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sendEmailReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sendEmailReturn"
})
@XmlRootElement(name = "sendEmailResponse")
public class SendEmailResponse {

    protected boolean sendEmailReturn;

    /**
     * ��ȡsendEmailReturn���Ե�ֵ��
     * 
     */
    public boolean isSendEmailReturn() {
        return sendEmailReturn;
    }

    /**
     * ����sendEmailReturn���Ե�ֵ��
     * 
     */
    public void setSendEmailReturn(boolean value) {
        this.sendEmailReturn = value;
    }

}

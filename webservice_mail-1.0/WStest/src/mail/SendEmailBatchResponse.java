
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
 *         &lt;element name="sendEmailBatchReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sendEmailBatchReturn"
})
@XmlRootElement(name = "sendEmailBatchResponse")
public class SendEmailBatchResponse {

    protected boolean sendEmailBatchReturn;

    /**
     * ��ȡsendEmailBatchReturn���Ե�ֵ��
     * 
     */
    public boolean isSendEmailBatchReturn() {
        return sendEmailBatchReturn;
    }

    /**
     * ����sendEmailBatchReturn���Ե�ֵ��
     * 
     */
    public void setSendEmailBatchReturn(boolean value) {
        this.sendEmailBatchReturn = value;
    }

}


package mail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取sendEmailBatchReturn属性的值。
     * 
     */
    public boolean isSendEmailBatchReturn() {
        return sendEmailBatchReturn;
    }

    /**
     * 设置sendEmailBatchReturn属性的值。
     * 
     */
    public void setSendEmailBatchReturn(boolean value) {
        this.sendEmailBatchReturn = value;
    }

}

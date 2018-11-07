
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
 *         &lt;element name="sendEmailsReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sendEmailsReturn"
})
@XmlRootElement(name = "sendEmailsResponse")
public class SendEmailsResponse {

    protected boolean sendEmailsReturn;

    /**
     * 获取sendEmailsReturn属性的值。
     * 
     */
    public boolean isSendEmailsReturn() {
        return sendEmailsReturn;
    }

    /**
     * 设置sendEmailsReturn属性的值。
     * 
     */
    public void setSendEmailsReturn(boolean value) {
        this.sendEmailsReturn = value;
    }

}

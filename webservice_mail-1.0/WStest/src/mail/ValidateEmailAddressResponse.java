
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
 *         &lt;element name="validateEmailAddressReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "validateEmailAddressReturn"
})
@XmlRootElement(name = "validateEmailAddressResponse")
public class ValidateEmailAddressResponse {

    protected boolean validateEmailAddressReturn;

    /**
     * ��ȡvalidateEmailAddressReturn���Ե�ֵ��
     * 
     */
    public boolean isValidateEmailAddressReturn() {
        return validateEmailAddressReturn;
    }

    /**
     * ����validateEmailAddressReturn���Ե�ֵ��
     * 
     */
    public void setValidateEmailAddressReturn(boolean value) {
        this.validateEmailAddressReturn = value;
    }

}

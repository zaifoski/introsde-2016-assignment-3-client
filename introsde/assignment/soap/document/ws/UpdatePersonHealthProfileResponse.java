
package introsde.assignment.soap.document.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per updatePersonHealthProfileResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="updatePersonHealthProfileResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hpId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonHealthProfileResponse", propOrder = {
    "hpId"
})
public class UpdatePersonHealthProfileResponse {

    protected int hpId;

    /**
     * Recupera il valore della propriet� hpId.
     * 
     */
    public int getHpId() {
        return hpId;
    }

    /**
     * Imposta il valore della propriet� hpId.
     * 
     */
    public void setHpId(int value) {
        this.hpId = value;
    }

}

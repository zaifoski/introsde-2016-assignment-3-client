
package introsde.assignment.soap.document.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://ws.document.soap.assignment.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @return
     *     returns java.util.List<introsde.assignment.soap.document.ws.Person>
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.ReadPersonListResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/readPersonListRequest", output = "http://ws.document.soap.assignment.introsde/People/readPersonListResponse")
    public List<Person> readPersonList();

    /**
     * 
     * @param personId
     * @return
     *     returns introsde.assignment.soap.document.ws.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "http://ws.document.soap.assignment.introsde/")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.ReadPersonResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/readPersonRequest", output = "http://ws.document.soap.assignment.introsde/People/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        int personId);

    /**
     * 
     * @param personId
     * @param healthProfile
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "hpId", targetNamespace = "")
    @RequestWrapper(localName = "updatePersonHealthProfile", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.UpdatePersonHealthProfile")
    @ResponseWrapper(localName = "updatePersonHealthProfileResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.UpdatePersonHealthProfileResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/updatePersonHealthProfileRequest", output = "http://ws.document.soap.assignment.introsde/People/updatePersonHealthProfileResponse")
    public int updatePersonHealthProfile(
        @WebParam(name = "personId", targetNamespace = "")
        int personId,
        @WebParam(name = "healthProfile", targetNamespace = "")
        LifeStatus healthProfile);

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.CreatePersonResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/createPersonRequest", output = "http://ws.document.soap.assignment.introsde/People/createPersonResponse")
    public int createPerson(
        @WebParam(name = "person", targetNamespace = "http://ws.document.soap.assignment.introsde/")
        Person person);

    /**
     * 
     * @param personId
     */
    @WebMethod
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.DeletePersonResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/deletePersonRequest", output = "http://ws.document.soap.assignment.introsde/People/deletePersonResponse")
    public void deletePerson(
        @WebParam(name = "personId", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Integer> personId);

    /**
     * 
     * @param person
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://ws.document.soap.assignment.introsde/", className = "introsde.assignment.soap.document.ws.UpdatePersonResponse")
    @Action(input = "http://ws.document.soap.assignment.introsde/People/updatePersonRequest", output = "http://ws.document.soap.assignment.introsde/People/updatePersonResponse")
    public int updatePerson(
        @WebParam(name = "person", targetNamespace = "http://ws.document.soap.assignment.introsde/")
        Person person);

}

package introsde.assignment.soap.client;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import introsde.assignment.soap.document.ws.LifeStatus;
import introsde.assignment.soap.document.ws.MeasureDefinition;
import introsde.assignment.soap.document.ws.People;
import introsde.assignment.soap.document.ws.PeopleService;
import introsde.assignment.soap.document.ws.Person;
import introsde.assignment.soap.document.ws.Person.Measurements;

public class PeopleClient{
	

    static PeopleService service = new PeopleService();
    static People people = service.getPeopleImplPort();
	
	public static Person readPerson(int idPerson){
		/*
		 * Method #2: readPerson(Long id) => Person | should give
		 *  all the Personal information plus current measures of one 
		 *  Person identified by {id} (e.g., current measures means 
		 *  current healthProfile)
		 */
		Person p = people.readPerson(idPerson);
		//System.out.println("Result ==> "+p);
		String result = "Method #2: readPerson(Long id) => Person";
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
		result += "\n\t Response: " + p.getIdPerson() + " " + p.getName();
		System.out.println(result);
        return p;
	}
	
	public static String deletePerson(int idPerson){        
        /*
         * Method #5: deletePerson(Long id) should delete the 
         * Person identified by {id} from the system
         */
		Holder<Integer> holder=new Holder<Integer>(idPerson);
		people.deletePerson(holder);
		//System.out.println("Result ==> "+p);
		String result = "Method #5: deletePerson(Long id)";
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
        return result;
	}
	
	public static String updatePerson(int idPerson){      
        /*
         * Method #3: updatePerson(Person p) => Person | should update 
         * the Personal information of the Person identified by {id} 
         * (e.g., only the Person's information, not the measures of the 
         * health profile)
         */
		String newName = "NewName";
		Person toUpdate = readPerson(idPerson);
		toUpdate.setName(newName);
		people.updatePerson(toUpdate);
		String result = "Method #3: updatePerson(Person p) => Person";
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
		result += "\n\t\t new name: " + newName;
        return result;
	}
	
	public static String readPersonList(){
    	/*
    	 *  Method #1: readPersonList() => List | should list 
    	 *  all the people in the database (see below 
    	 *  Person model to know what data to return here) 
    	 *  in your database
    	 */
        List<Person> pList = people.readPersonList();
        /*
        System.out.println("Result ==> "+pList);
        System.out.println("First Person in the list ==> "+pList.get(0).getName());
        */
        String result = "Method #1: readPersonList() => List";
        result += "\n\t Parameters: none";
        result += "\n\t Response: ";
        for(Person pers: pList){
        	result += "\n\t\t" + pers.getIdPerson() + " " + pers.getName();
        }
        return result;
	}
	
	public static int createPerson() throws DatatypeConfigurationException{
		/*
         * Method #4: createPerson(Person p) => Person | should 
         * create a new Person and return the newly created Person 
         * with its assigned id (if a health profile is included, 
         * create also those measurements for the new Person).
         */
        String result = "Method #4: createPerson(Person p) => Person";
        result += "\n\t Parameters: ";
		Person newPerson = new Person();
		newPerson.setName("Sofia");
		newPerson.setLastname("Chimirri");
		newPerson.setEmail("sofia@chimirri.com");
		/*
		XMLGregorianCalendar birthdate = DatatypeFactory.newInstance()
			    .newXMLGregorianCalendar(
				new GregorianCalendar(1991,11,18)
		);
		newPerson.setBirthdate(birthdate);
        result += "\n\t "+ newPerson.getBirthdate();
		*/
        result += "\n\t\t "+ newPerson.getName();
        result += "\n\t\t "+ newPerson.getLastname();
        result += "\n\t\t "+ newPerson.getEmail();
        
        result += "\n\t Response: ";
		int success = people.createPerson(newPerson);
        if (success!=-1)
        	result+= success;
        else
        	result+="ERROR";
		System.out.println(result);
        return success;
	}
	
	
	public static String updatePersonHP(int id){
	    /*
	     * Method #10: updatePersonMeasure(Long id, Measure m) => Measure | should
	     *  update the measure identified with {m.mid}, related to the Person 
	     *  identified by {id}
	     */
		/*
        LifeStatus hp = new LifeStatus();
        MeasureDefinition md = new MeasureDefinition();
        md.setIdMeasureDef(2);
        md.setMeasureName("height");
        md.setMeasureType("double");
        hp.setMeasureDefinition(md);
        hp.setValue("168");
        hp.setIdMeasure(2);
        Person p = readPerson(id);
        Measurements m = new Measurements();
        HealthMeasureHistory hmh = new HealthMeasureHistory();
        hp.set
        p.setMeasurements();
        int measureId = people.updatePersonHealthProfile(id,hp);
        String result = "Method #10: updatePersonMeasure(Long id, Measure m) => Measure";
        result += "\n\t Parameters: TODO";
        result += "\n\t Response: " + measureId;
        return result;
        */
		return "";
	}
	
    public static void main(String[] args) throws Exception {
        
        /*
         * Decide yourself what kind of attribute values, person ID's you want
         *  to use for certain methods. For each method - print into your log file
         *   methods name and number, parameters you passed and response you received
         *    (decide yourself - whether you want to print data in details or ids only).
         *     It is fine to run a given method only 1 time (not as in Assignment 2 when
         *      you were asked to run several requests 
         * at the same endpoint with different parameters). Still you can run more.
         */deletePerson(1560);
        System.out.println(readPersonList());
        int created = createPerson();
        System.out.println(readPerson(created));
        System.out.println(readPersonList());
        updatePerson(created);
        System.out.println("\n-------------> After I update the person:\n");
        System.out.println(readPersonList());
        
        updatePersonHP(created);
        /*
        System.out.println(deletePerson(created));
        System.out.println("\n-------------> After I delete the person:\n");
        System.out.println(readPersonList());
        */
        
        /*
         * Method #10: updatePersonMeasure(Long id, Measure m) => Measure | should
         *  update the measure identified with {m.mid}, related to the Person 
         *  identified by {id}
         */
        
        /*
         * Method #6: readPersonHistory(Long id, String measureType) => List 
         * should return the list of values (the history) of {measureType}
         *  (e.g. weight) for Person identified by {id}
         */

        /*
         * Method #7: readMeasureTypes() => List should return the list of measures
         */
        
        /*
         * Method #8: readPersonMeasure(Long id, String measureType, Long mid) => Measure
         *  should return the value of {measureType} (e.g. weight) identified by 
         *  {mid} for Person identified by {id}
         */
        
        /*
         * Method #9: savePersonMeasure(Long id, Measure m) =>should save a new 
         * measure object {m} (e.g. weight) of Person identified by {id} and 
         * archive the old value in the history
         */
    }
}
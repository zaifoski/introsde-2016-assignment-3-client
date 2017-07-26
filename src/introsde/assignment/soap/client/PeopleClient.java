package introsde.assignment.soap.client;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.Holder;

import introsde.assignment.soap.document.ws.Measure;
import introsde.assignment.soap.document.ws.People;
import introsde.assignment.soap.document.ws.PeopleService;
import introsde.assignment.soap.document.ws.Person;

public class PeopleClient{
	

    static PeopleService service = new PeopleService();
    static People people = service.getPeopleImplPort();
    
	public static void setLogFile(Boolean append){
		try {
		    System.setOut(new PrintStream(new FileOutputStream("logfile.log",append)));
		} catch (Exception e) {
		     e.printStackTrace();
		}
	}
    
	/*
	 *  Method #1: readPersonList() => List | should list 
	 *  all the people in the database (see below 
	 *  Person model to know what data to return here) 
	 *  in your database
	 */
	public static String readPersonList(){
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

	/*
	 * Method #2: readPerson(Long id) => Person | should give
	 *  all the Personal information plus current measures of one 
	 *  Person identified by {id} (e.g., current measures means 
	 *  current healthProfile)
	 */
	public static Person readPerson(int idPerson){
		Person p = people.readPerson(idPerson);
		String result = "Method #2: readPerson(Long id) => Person";
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
		result += "\n\t Response: " + p.getIdPerson() + " " + p.getName();
		System.out.println(result);
        return p;
	}
	
    /*
     * Method #3: updatePerson(Person p) => Person | should update 
     * the Personal information of the Person identified by {id} 
     * (e.g., only the Person's information, not the measures of the 
     * health profile)
     */
	public static String updatePerson(int idPerson){      
		String newName = "NewName";
		Person toUpdate = readPerson(idPerson);
		toUpdate.setName(newName);
		people.updatePerson(toUpdate);
		String result = "Method #3: updatePerson(Person p) => Person";
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
		result += "\n\t\t new name: " + newName;
        return result;
	}
	
	/*
     * Method #4: createPerson(Person p) => Person | should 
     * create a new Person and return the newly created Person 
     * with its assigned id (if a health profile is included, 
     * create also those measurements for the new Person).
     */
	public static int createPerson(){
        String result = "Method #4: createPerson(Person p) => idPerson";
        result += "\n\t Parameters: ";
		Person newPerson = new Person();
		newPerson.setName("Mario");
		newPerson.setLastname("Rossi");
		newPerson.setEmail("mario@rossi.com");
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
	
    /*
     * Method #5: deletePerson(Long id) should delete the 
     * Person identified by {id} from the system
     */
	public static int deletePerson(int idPerson){
        String result = "Method #5: deletePerson(int idPerson)"; 
		Holder<Integer> holder=new Holder<Integer>(idPerson);
		int personExists = people.deleteP(idPerson);
		result += "\n\t Parameters: "+  "\n\t\t idPerson: " + idPerson;
		if(personExists==0){
			result += "\n\t Result: "+  "\n\t\t OK";
		} else {
			result += "\n\t Result: "+  "\n\t\t PERSON DOES NOT EXIST";
		}
		System.out.println(result);
        return personExists;
	}

    /*
     * Method #6: readPersonHistory(Long id, String measureType) => List 
     * should return the list of values (the history) of {measureType}
     *  (e.g. weight) for Person identified by {id}
     */	
	public static List<String> readPersonHistory(int id, String measureType){

        String result = "Method #6: readPersonHistory(int id, String measureType) => List "; 
		List<String> personHistory = people.readPersonHistory(id,measureType);
		result += "\n\t Parameters: ";
		result += "\n\t\t idPerson: " + id;
		result += "\n\t\t measureType: " + measureType;
		result += "\n\t Result: ";
		for(String measure: personHistory){
			result += "\n\t\t "+measure;
		}
		System.out.println(result);
		return personHistory;
	}

    /*
     * Method #7: readMeasureTypes() => List should return the list of measures
     */
	public static List<Measure> readMeasureTypes(){
        String result = "Method #7: readMeasureTypes() => List "; 
		List<Measure> listMeasure = people.readMeasureTypes();
		result += "\n\t Parameters: none";
		result += "\n\t Result: ";
		for(Measure measure: listMeasure){
			result += "\n\t\t "+measure.getValue() + " " + measure.getType();
		}
		System.out.println(result);
		return listMeasure;
	}
    
    /*
     * Method #8: readPersonMeasure(Long id, String measureType, Long mid) => Measure
     *  should return the value of {measureType} (e.g. weight) identified by 
     *  {mid} for Person identified by {id}
     */
    public static String readPersonMeasure(int id, String measureType, int mid){
        String result = "Method #8: readPersonMeasure(int id, String measureType, int mid) => String "; 
		result += "\n\t Parameters: ";
		result += "\n\t\t idPerson: " + id;
		result += "\n\t\t measureType: " + measureType;
		result += "\n\t\t idMeasure: " + mid;
		result += "\n\t Result: ";
		String measure = people.readPersonMeasure(id,measureType,mid);
		result += "\n\t\t "+measure;
		System.out.println(result);
		return measure;
	}
    
    /*
     * Method #9: savePersonMeasure(Long id, Measure m) =>should save a new 
     * measure object {m} (e.g. weight) of Person identified by {id} and 
     * archive the old value in the history
     */
	public static Long savePersonMeasure(int id){
		Measure newMeasure = new Measure();
		newMeasure.setType("weight");
		newMeasure.setValue("80");
		newMeasure.setValueType("double");
		String result = "Method #9: savePersonMeasure(int id, Measure newMeasure) => Long "; 
		result += "\n\t Parameters: ";
		result += "\n\t\t idPerson: " + id;
		result += "\n\t\t newMeasure: " + newMeasure;
		Long newMeasureID = people.savePersonMeasure(id,newMeasure);
		if(newMeasureID==-1){result += "\n\t Result: "+  "\n\t\t ERROR";}
		else{result += "\n\t Result: "+  "\n\t\t New Measure Id: "+newMeasureID;}
		System.out.println(result);
		return newMeasureID;
	}
	
    /*
     * Method #10: updatePersonMeasure(Long id, Measure m) => Measure | should
     *  update the measure identified with {m.mid}, related to the Person 
     *  identified by {id}
     */
	public static Long updatePersonHP(int id, Long mid){

		Measure m = new Measure();
		m.setMid(mid);
		m.setType("weight");
		m.setValue("75");
		m.setValueType("double");
		
		String result = "Method #10: updatePersonMeasure(Long id, Measure m) => Measure";
		result += "\n\t Parameters: ";
		result += "\n\t\t idPerson: " + id;
		result += "\n\t\t measureId: " + m.getMid();
		result += "\n\t Result: ";
		Long measureId = people.updatePersonHealthProfile(id, m);
        if (measureId<0)
        	result+="\n\t\t"+measureId+" ERROR, the value isn't changed ";
        else
        	result+="\n\t\t OK, the value is changed for mid " + measureId;
        System.out.println(result);
        return measureId;
	}
	
    public static void main(String[] args) throws Exception {
    	
    	setLogFile(false);System.out.println("\nhttps://chimirri-assignment-3-server.herokuapp.com:6907/ws/people?wsdl/\n");people.cleanDb();

        System.out.println("\n-------------> At the beginning:\n");
        System.out.println(readPersonList());
    	readPersonMeasure(1,"weight",2);
    	readMeasureTypes();
        
        System.out.println("\n-------------> I update a measure:\n");
    	updatePersonHP(1,new Long(2));

        System.out.println("\n-------------> I save a new measure and read it:\n");
    	Long newMeasureId = savePersonMeasure(1);
    	readPersonMeasure(1,"weight",(int) (long) newMeasureId);
        readPersonHistory(1,"weight");
    	
        System.out.println("\n-------------> I create a new person:\n");
    	int newPerson = createPerson();
        System.out.println(readPersonList());
        readPerson(newPerson);
        
        System.out.println("\n-------------> I update and read the newly created person:\n");
    	System.out.println(updatePerson(newPerson));
        readPerson(newPerson);

        System.out.println("\n-------------> I delete the newly created person:\n");
    	deletePerson(newPerson);
        System.out.println(readPersonList());
    	
    }
}
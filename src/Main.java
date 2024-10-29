import Model.Person;
import Model.TestedPerson;
import Service.SisCovidService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("franco","soria",28,"fortunato",22345678);
        Person p2 = new Person("lucas","galarce",22,"las heras",11112222);
        Person p3 = new Person("omar","chavez",38,"san antonio",33334444);
        Person p4 = new Person("marcos","ortiz",48,"los troncos",15556666);
        Map<Integer,Person> personList = new HashMap<>();
        Map<Integer, TestedPerson> testedList = new HashMap<>();
        Map<Integer, String> urgentData = new HashMap<>();
        Map<Map,Map> results = new HashMap<>();
        SisCovidService covidService = new SisCovidService(2);

        personList=covidService.registerPerson(p1);
        personList=covidService.registerPerson(p2);
        personList=covidService.registerPerson(p3);
        personList=covidService.registerPerson(p4);
       // personList=covidService.registerPerson(p1);
        //System.out.println(personList);
      //  System.out.println("//////////////////////");
        testedList=covidService.testear(personList);
       // System.out.println(testedList.entrySet());
        urgentData=covidService.aislar(testedList,personList);
        System.out.println(urgentData);
        results=covidService.exportJson((HashMap<Integer, Person>) personList, (HashMap<Integer, TestedPerson>) testedList);




    }
}
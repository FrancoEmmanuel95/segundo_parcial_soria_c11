package Service;

import Model.HighTempException;
import Model.InsufficientKitsException;
import Model.Person;
import Model.TestedPerson;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SisCovidService {
    private Integer quantity_Kits;
    private Integer kitNumber = 1;
    private Integer temperature;
    Map<Integer, Person> personList = new HashMap<>();
    Random random = new Random();

    public SisCovidService(Integer quantity_Kits) {
        this.quantity_Kits = quantity_Kits;
    }

    public Map<Integer, Person> registerPerson(Person p) {
        Boolean flag = false;
        while (flag == false) {
            try {
                if (quantity_Kits > 0) {
                    personList.put(kitNumber, p);
                    quantity_Kits--;
                    kitNumber++;

                    flag = true;
                } else {
                    throw new InsufficientKitsException(quantity_Kits);
                }
            } catch (InsufficientKitsException e) {
                quantity_Kits = e.incrementKits(true, 10);
            }
        }
        return personList;

    }

    public Map<Integer, TestedPerson> testear(Map<Integer, Person> personList) {
        Map<Integer, TestedPerson> testedList = new HashMap<>();

        Integer kit = 0;
        Person person = null;
        for (Map.Entry<Integer, Person> entry : personList.entrySet()) {
            temperature = random.nextInt(4) + 36;
            testedList.put(entry.getKey(), new TestedPerson(entry.getValue().getDni(), Double.valueOf(temperature)));
        }
        return testedList;
    }

    public Map<Integer, String> aislar(Map<Integer, TestedPerson> testedList, Map<Integer, Person> personList) {
        Map<Integer, String> urgentData = new HashMap<>();
        try {
            for (Map.Entry<Integer, TestedPerson> entry : testedList.entrySet()) {
                if (entry.getValue().getTemp() >= 38D) {
                    urgentData.put(entry.getKey(), personList.get(entry.getKey()).getNeighborhood());
                    throw new HighTempException();
                }


            }
        } catch (HighTempException e) {
            try {
                File file = new File("urgente");
                FileWriter fw = new FileWriter(file);
                fw.write(urgentData.toString());
                fw.close();
            } catch (IOException f) {
                System.out.println("el archivo no pudo crearse");
            }
        } finally {
            return urgentData;
        }
    }
    public Map<Map,Map> exportJson(HashMap<Integer,Person> personList,HashMap<Integer,TestedPerson> testedList) {
        Map<Map, Map> jsonFile = new HashMap<>();
        Map<Integer, Person> sanos = new HashMap<>();
        Map<Integer, TestedPerson> aislar = new HashMap<>();
        for (Map.Entry<Integer, TestedPerson> testedEntry : testedList.entrySet()) {
            if (testedEntry.getValue().getTemp() < 38D) {
                sanos.put(testedEntry.getKey(), personList.get(testedEntry.getKey()));
            }
            else{
                aislar.put(testedEntry.getKey(),testedEntry.getValue());
            }
        }
        jsonFile.put(sanos,aislar);
        try{
            File file = new File("resultados.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file,jsonFile);
        }
        catch(IOException e){
            System.out.println("el archivo no se pudo crear");
        }
        return jsonFile;
    }
}
package cz.ictpro.collections.lesson.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        final Map<Integer, String> ageToNames = new LinkedHashMap<>(); // creating LinkedHashMap
        ageToNames.put(20, "Maggie");
        ageToNames.put(40, "Kate");
        ageToNames.put(30, "Anne");

        for (final Integer key : ageToNames.keySet()) { // key iteration using keySet()
            System.out.println("Key is map: " + key);     // the order of the keys is always the same -> 20, 40, 30
        }

        for (final String value : ageToNames.values()) {   // iteration over values using values()
            System.out.println("Value in map is: " + value); // the order of the values is always the same -> Maggie, Anne, Kate
        }

        for (final Map.Entry<Integer, String> ageToName : ageToNames.entrySet()) { // iteration over pairs with entrySet()
            System.out.println("Value for key " + ageToName.getKey() + " is " + ageToName.getValue());
          /* the result will always be the following 3 lines, in this exact order (results from the use of LinkedHashMap)
             Value for key 20 is Maggie
             Value for key 40 is Kate
             Value for key 30 is Anne
           */
        }
    }
}

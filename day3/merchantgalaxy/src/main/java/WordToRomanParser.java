import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
public class WordToRomanParser {
    private static final TreeMap<String,Double> romanSymbols = new TreeMap<>(){{
        put("I",1.0);
        put("V",5.0);
        put("X",10.0);
        put("L",50.0);
        put("C",100.0);
        put("D",500.0);
        put("M",1000.0);
    }};
    public HashMap<String, Double> setItemValues(ArrayList<String> input){
        HashMap<String,Double> words = new HashMap<>();
        for(String line : input){
            String word = line.split(" ")[0];
            String romanNumeral = line.split(" ")[2];
            double value = romanSymbols.get(romanNumeral);
            words.put(word,value);
        }
        return words;
    }
}

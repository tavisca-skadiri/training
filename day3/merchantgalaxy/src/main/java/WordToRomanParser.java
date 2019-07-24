import java.util.ArrayList;
import java.util.HashMap;
public class WordToRomanParser {
    private static final HashMap<String,Integer> romanSymbols = new HashMap<>(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
    }};
    public HashMap<String, Integer> setItemValues(ArrayList<String> input){
        HashMap<String,Integer> words = new HashMap<>();
        for(String line : input){
            String word = line.split(" ")[0];
            String romanNumeral = line.split(" ")[2];
            int value = romanSymbols.get(romanNumeral);
            words.put(word,value);
        }
        return words;
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Converter {
    private HashMap<String,Integer> words;
    private static HashMap<String,Integer> romanSymbols = new HashMap<>(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",250);
        put("C",100);
        put("D",500);
        put("M",1000);
    }};
    public Converter() {
        words = new HashMap<>();
    }
    public HashMap<String, Integer> setItemValues(ArrayList<String> input){
        for(String line : input){
            String word = line.split(" ")[0];
            String romanNumeral = line.split(" ")[2];
            int value = romanSymbols.get(romanNumeral);
            words.put(word,value);
        }
        return words;
    }
    public HashMap<String, Integer> setUnknownItemAndCredit(ArrayList<String> input){
        for(String line : input) {
            String word1 = line.split(" ")[0];
            String word2 = line.split(" ")[1];
            String unknownWord = line.split(" ")[2];
            int credits = Integer.parseInt(line.split(" ")[4]);
            words.put(unknownWord,credits);
        }
        return words;
    }
}

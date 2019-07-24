import java.util.ArrayList;
import java.util.HashMap;

public class Converter {
    private HashMap<String,Integer> arabicSymbols;
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
        arabicSymbols = new HashMap<>();
    }
    public HashMap<String, Integer> getArabicSymbols(ArrayList<String> input){
        return setArabicSymbols(input);
    }
    private HashMap<String, Integer> setArabicSymbols(ArrayList<String> input){
        for(String line : input){
            String arabicNumeral  = line.split(" ")[0];
            String romanNumeral = line.split(" ")[2];
            int value = romanSymbols.get(romanNumeral);
            arabicSymbols.put(arabicNumeral,value);
        }
        return arabicSymbols;
    }
}

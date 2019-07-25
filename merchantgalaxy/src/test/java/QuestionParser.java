import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class QuestionParser {
    private static final TreeMap<Character,Integer> romanSymbols = new TreeMap<>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};
    double romanToDecimal(String str) {
        double res = 0;
        for (int i=0; i<str.length(); i++) {
            double s1 = romanSymbols.get(str.charAt(i));
            if (i+1 <str.length()) {
                double s2 = romanSymbols.get(str.charAt(i + 1));
                if (s1 >= s2) {
                    res = res + s1;
                }
                else {
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }
    public String generateRomanNumber(String words, HashMap<String, String> alias){
        StringBuilder romanNumber= new StringBuilder();
        for(String word : words.split(" ")){
            if(alias.containsKey(word.trim())){
                romanNumber.append(alias.get(word));
            }
        }
        return romanNumber.toString();
    }
    int findHowMuchValue(ArrayList<String> input, HashMap<String, Double> metals, HashMap<String,String> alias){
        StringBuilder romanString = new StringBuilder();
        for(String line : input){
            String[] words = line.split(" ");
            for (String word : words){
                if(alias.containsKey((word))) {
                    romanString.append(word);
                    romanString.append(" ");
                }
                else if(metals.containsKey(word)) {
                    romanString.append(word);
                    romanString.append(" ");
                }
            }
        }
        String romanNumber = generateRomanNumber(romanString.toString(),alias);
        return (int)romanToDecimal(romanNumber);
    }
}

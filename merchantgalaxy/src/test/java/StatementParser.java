import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class StatementParser {
    private static final TreeMap<Character,Integer> romanSymbols = new TreeMap<>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};
    public ArrayList<Statement> setUnknownItem(ArrayList<String> input, HashMap<String, String> alias){
        ArrayList<Statement> statements = new ArrayList<>();
        for(String line : input) {
            String[] words = line.split(" is ");
            String[] words2 = words[0].split(" ");
            String unknownMetal = words2[words2.length - 1];
            int credits = Integer.parseInt(words[1].split(" ")[0]);

            String romanNumber = generateRomanNumber(words[0],alias);
            Statement statement = new Statement(romanNumber,credits,unknownMetal);
            statements.add(statement);
//            String[] aliases = line.split(words[0]);
//            String unknownWord = line.split(" ")[2];
//            int credits = Integer.parseInt(line.split(" ")[4]);
//            double value = calculateValueFromCredits(credits,word1,word2,words);
//            unknownWords.put(unknownWord,value);
        }
        return statements;
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
    int romanToDecimal(String str) {
        int res = 0;
        for (int i=0; i<str.length(); i++) {
            int s1 = romanSymbols.get(str.charAt(i));
            if (i+1 <str.length()) {
                int s2 = romanSymbols.get(str.charAt(i + 1));
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
    public HashMap<String, Double> setUnknownItemAndCredit(ArrayList<String> input, HashMap<String, Double> words){
        HashMap<String, Double> unknownWords = new HashMap<>();
        for(String line : input) {
            String word1 = line.split(" ")[0];
            String word2 = line.split(" ")[1];
            String unknownWord = line.split(" ")[2];
            int credits = Integer.parseInt(line.split(" ")[4]);
            double value = calculateValueFromCredits(credits,word1,word2,words);
            unknownWords.put(unknownWord,value);
        }
        return unknownWords;
    }
    public HashMap<String, Double> setUnknownWords(ArrayList<String> input, HashMap<String, Double> words){
        HashMap<String, Double> unknownWords = new HashMap<>();
        for(String line : input) {
            String word1 = line.split(" ")[0];
            String word2 = line.split(" ")[1];
            String unknownWord = line.split(" ")[2];
            int credits = Integer.parseInt(line.split(" ")[4]);
            double value = calculateValueFromCredits(credits,word1,word2,words);
            unknownWords.put(unknownWord,value);
        }
        return unknownWords;
    }
    private double calculateValueFromCredits(int credits,String word1, String word2,HashMap<String,Double> words){
        double value;
        if(words.get(word1) < words.get(word2))
            value = credits / (words.get(word2) - words.get(word1));
        else
            value = credits / ((words.get(word2) + words.get(word1)));
        return value;
    }
}
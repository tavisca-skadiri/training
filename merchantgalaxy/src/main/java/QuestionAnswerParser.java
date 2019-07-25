import java.util.ArrayList;
import java.util.HashMap;

public class QuestionAnswerParser {
    public String generateRomanNumber(String words, HashMap<String, String> aliasToRomanMap){
        StringBuilder romanNumber= new StringBuilder();
        for(String word : words.split(" "))
            if(aliasToRomanMap.containsKey(word.trim()))
                romanNumber.append(aliasToRomanMap.get(word));
        return romanNumber.toString();
    }
    int findHowMuchValue(ArrayList<String> lines, HashMap<String,String> aliasToRomanMap){
        StringBuilder romanString = new StringBuilder();
        for(String line : lines){
            String[] words = line.split(" ");
            for (String word : words)
                if(aliasToRomanMap.containsKey((word)))
                    romanString.append(word).append(" ");
        }
        String romanNumber = generateRomanNumber(romanString.toString(),aliasToRomanMap);
        return (int)RomanNumberUtils.romanToDecimal(romanNumber);
    }
    ArrayList<Integer> findHowManyCredits(ArrayList<String> lines, HashMap<String, Double> metals, HashMap<String,String> alias){
        ArrayList<Integer> credits = new ArrayList<>();
        for(String line : lines) {
            StringBuilder romanString = new StringBuilder();
            String[] words = line.split(" ");
            double metalValue = 0.0;
            for (String word : words) {
                if (alias.containsKey((word)))
                    romanString.append(word).append(" ");
                else if (metals.containsKey(word))
                    metalValue = metals.get(word);
            }
            String romanNumberString = generateRomanNumber(romanString.toString(), alias);
            int romanNumber = (int) RomanNumberUtils.romanToDecimal(romanNumberString);
            credits.add((int) (romanNumber * metalValue));
        }
        return credits;
    }
}
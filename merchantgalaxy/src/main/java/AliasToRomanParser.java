import java.util.ArrayList;
import java.util.HashMap;
public class AliasToRomanParser {
    public HashMap<String, String> parseAliasToRoman(ArrayList<String> inputLines){
        HashMap<String,String> aliasToRomanMap = new HashMap<>();
        for(String currentLine : inputLines){
            String alias = currentLine.split(" ")[0];
            String romanNumeral = currentLine.split(" ")[2];
            aliasToRomanMap.put(alias,romanNumeral);
        }
        return aliasToRomanMap;
    }
    public HashMap<String, Double> parseAliasToNumber(ArrayList<String> inputLines, HashMap<String, String> aliasToRomanMap){
        HashMap<String,Double> aliasToNumberMap = new HashMap<>();
        for(String currentLine : inputLines) {
            String alias = currentLine.split(" ")[0];
            String romanNumeral = aliasToRomanMap.get(alias);
            double value = RomanNumberUtils.romanToIntegerMap.get(romanNumeral);
            aliasToNumberMap.put(alias,value);
        }
        return aliasToNumberMap;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
public class CreditsToMetalParser {
    public ArrayList<Statement> getStatements(ArrayList<String> lines, HashMap<String, String> aliasToRomanMap){
        ArrayList<Statement> statements = new ArrayList<>();
        for(String currentLine : lines) {
            String[] aliases = currentLine.split(" is ");
            String[] credits = aliases[0].split(" ");

            String unknownMetal = credits[credits.length - 1];
            int creditValue = Integer.parseInt(aliases[1].split(" ")[0]);
            String romanNumber = generateRomanNumberFromAliases(aliases[0],aliasToRomanMap);

            Statement statement = new Statement(romanNumber,creditValue,unknownMetal);
            statements.add(statement);
        }
        return statements;
    }
    public String generateRomanNumberFromAliases(String aliases, HashMap<String, String> aliasToRomanMap){
        StringBuilder romanNumber = new StringBuilder();
        for(String alias : aliases.split(" "))
            if(aliasToRomanMap.containsKey(alias.trim()))
                romanNumber.append(aliasToRomanMap.get(alias));
        return romanNumber.toString();
    }
    public HashMap<String,Double> getMetalValues(ArrayList<Statement> statements){
        HashMap<String,Double> metalsToValueMap = new HashMap<>();
        for(Statement statement:statements){
            double romanNumber = RomanNumberUtils.romanToDecimal(statement.getRomanNumber());
            double metalValue = statement.getCredits() / romanNumber;
            metalsToValueMap.put(statement.getUnknownMetal(),metalValue);
        }
        return metalsToValueMap;
    }
}
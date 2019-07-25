import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MerchantGalaxyTest {
    @Test
    void setAlias(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");

        HashMap<String,String> items  = new HashMap<>();
        items.put("glob","I");
        items.put("prok","V");
        items.put("pish","X");
        items.put("tegj","L");

        assertEquals(items, wordToRomanParser.setAlias(input));
    }
    @Test
    void checkAliasToNumberConversion(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = wordToRomanParser.setAlias(input);

        HashMap<String,Double> items  = new HashMap<>();
        items.put("glob",1.0);
        items.put("prok",5.0);
        items.put("pish",10.0);
        items.put("tegj",50.0);

        assertEquals(items, wordToRomanParser.parseAliasToNumber(input,alias));
    }
    @Test
    void setRomanString(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = wordToRomanParser.setAlias(input);

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        StatementParser statementParser = new StatementParser();
        ArrayList<Statement> statements = new ArrayList<>();
        statements.add(new Statement("II",34,"Silver"));
        statements.add(new Statement("IV",57800,"Gold"));
        statements.add(new Statement("XX",3910,"Iron"));
        assertEquals(statements.toString(), statementParser.setUnknownItem(input2,alias).toString());
    }
    @Test
    void generateRomanString(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = wordToRomanParser.setAlias(input);

        String input3 = "glob glob Silver";
        StatementParser statementParser = new StatementParser();
        ArrayList<Statement> statements = new ArrayList<>();
        assertEquals("II", statementParser.generateRomanNumber(input3,alias).toString());
    }
    @Test
    void getValueOfRomanNumber(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = wordToRomanParser.setAlias(input);

        StatementParser statementParser = new StatementParser();

        assertEquals(2, statementParser.romanToDecimal("II"));
    }
}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MerchantGalaxyTest {
    @Test
    void setAlias(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
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

        assertEquals(items, aliasToRomanParser.parseAliasToRoman(input));
    }
    @Test
    void checkAliasToNumberConversion(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        HashMap<String,Double> items  = new HashMap<>();
        items.put("glob",1.0);
        items.put("prok",5.0);
        items.put("pish",10.0);
        items.put("tegj",50.0);

        assertEquals(items, aliasToRomanParser.parseAliasToNumber(input,alias));
    }
    @Test
    void generateRomanString(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        String input3 = "glob glob Silver";
        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        assertEquals("II", creditsToMetalParser.generateRomanNumberFromAliases(input3,alias));
    }
    @Test
    void setStatement(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        ArrayList<Statement> statements = new ArrayList<>();
        statements.add(new Statement("II",34,"Silver"));
        statements.add(new Statement("IV",57800,"Gold"));
        statements.add(new Statement("XX",3910,"Iron"));
        assertEquals(statements.toString(), creditsToMetalParser.getStatements(input2,alias).toString());
    }
    @Test
    void getValueOfRomanNumberString(){
        assertEquals(2, RomanNumberUtils.romanToDecimal("II"));
        assertEquals(34, RomanNumberUtils.romanToDecimal("XXXIV"));
        assertEquals(1903, RomanNumberUtils.romanToDecimal("MCMIII"));
    }
    @Test
    void findValueOfMetals(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        ArrayList<Statement> statements = creditsToMetalParser.getStatements(input2,alias);

        HashMap<String,Double> items  = new HashMap<>();
        items.put("Silver",17.0);
        items.put("Gold",14450.0);
        items.put("Iron",195.5);

        assertEquals(items, creditsToMetalParser.getMetalValues(statements));
    }
    @Test
    void findHowMuchValue(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        ArrayList<Statement> statements = creditsToMetalParser.getStatements(input2,alias);

        ArrayList<String> input3 = new ArrayList<>();
        input3.add("how much is pish tegj glob glob ?");

        QuestionAnswerParser questionAnswerParser = new QuestionAnswerParser();

        assertEquals(42, questionAnswerParser.findHowMuchValue(input3,alias));
    }
    @Test
    void findHowManyCredits(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        ArrayList<Statement> statements = creditsToMetalParser.getStatements(input2,alias);
        HashMap<String,Double> metals = creditsToMetalParser.getMetalValues(statements);

        ArrayList<String> input3 = new ArrayList<>();
        input3.add("how many Credits is glob prok Silver ?");
        input3.add("how many Credits is glob prok Gold ?");
        input3.add("how many Credits is glob prok Iron ?");

        QuestionAnswerParser questionAnswerParser = new QuestionAnswerParser();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(68);
        result.add(57800);
        result.add(782);
        assertEquals(result.toString(), questionAnswerParser.findHowManyCredits(input3,metals,alias).toString());
    }
}
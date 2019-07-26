import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class MerchantGalaxyTest {
    private ArrayList<String> input,input2;
    @BeforeEach
    void beforeAll(){
        input = new ArrayList<>(){{
            add("glob is I");
            add("prok is V");
            add("pish is X");
            add("tegj is L");
        }};
        input2 = new ArrayList<>(){{
            add("glob glob Silver is 34 Credits");
            add("glob prok Gold is 57800 Credits");
            add("pish pish Iron is 3910 Credits");
        }};
    }
    @Test
    void setAlias(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> result  = new HashMap<>();
        result.put("glob","I");
        result.put("prok","V");
        result.put("pish","X");
        result.put("tegj","L");
        assertEquals(result, aliasToRomanParser.parseAliasToRoman(input));
    }
    @Test
    void checkAliasToNumberConversion(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        HashMap<String,Double> result  = new HashMap<>();
        result.put("glob",1.0);
        result.put("prok",5.0);
        result.put("pish",10.0);
        result.put("tegj",50.0);
        assertEquals(result, aliasToRomanParser.parseAliasToNumber(input,alias));
    }
    @Test
    void generateRomanString(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        String input3 = "glob glob Silver";
        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        assertEquals("II", creditsToMetalParser.generateRomanNumberFromAliases(input3,alias));
    }
    @Test
    void setStatement(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

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
    void checkIfRomanNumberValid(){
        assertTrue(RomanNumberUtils.isRomanNumberValid("II"));
        assertTrue(RomanNumberUtils.isRomanNumberValid("XXXIV"));
        assertTrue(RomanNumberUtils.isRomanNumberValid("MCMIII"));
        assertFalse(RomanNumberUtils.isRomanNumberValid("VX"));
    }
    @Test
    void findValueOfMetals(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        CreditsToMetalParser creditsToMetalParser = new CreditsToMetalParser();
        ArrayList<Statement> statements = creditsToMetalParser.getStatements(input2,alias);

        HashMap<String,Double> result  = new HashMap<>();
        result.put("Silver",17.0);
        result.put("Gold",14450.0);
        result.put("Iron",195.5);
        assertEquals(result, creditsToMetalParser.getMetalValues(statements));
    }
    @Test
    void findHowMuchValue(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

        ArrayList<String> input3 = new ArrayList<>();
        input3.add("how much is pish tegj glob glob ?");

        QuestionAnswerParser questionAnswerParser = new QuestionAnswerParser();

        assertEquals(42, questionAnswerParser.findHowMuchValue(input3,alias));
    }
    @Test
    void findHowManyCredits(){
        AliasToRomanParser aliasToRomanParser = new AliasToRomanParser();
        HashMap<String,String> alias = aliasToRomanParser.parseAliasToRoman(input);

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
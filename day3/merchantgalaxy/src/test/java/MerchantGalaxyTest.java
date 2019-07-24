import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
class MerchantGalaxyTest {
    @Test
    void checkRomanToArabicConversion(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");

        HashMap<String,Double> items  = new HashMap<>();
        items.put("glob",1.0);
        items.put("prok",5.0);
        items.put("pish",10.0);
        items.put("tegj",50.0);

        assertEquals(items, wordToRomanParser.setItemValues(input));
    }
    @Test
    void setItemAndCredits(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> input2 = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String, Double> words = wordToRomanParser.setItemValues(input);

        input2.add("glob glob Silver is 34 Credits");

        StatementParser statementParser = new StatementParser();
        HashMap<String,Double> itemAndCredit  = new HashMap<>();
        itemAndCredit.put("Silver",17.0);

        assertEquals(itemAndCredit, statementParser.setUnknownItemAndCredit(input2,words));
    }
    @Test
    void calculateCreditsInOrder(){
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> input2 = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");
        HashMap<String, Double> words = wordToRomanParser.setItemValues(input);

        input2.add("glob glob Silver is 34 Credits");
        input2.add("glob prok Gold is 57800 Credits");
        input2.add("pish pish Iron is 3910 Credits");

        StatementParser statementParser = new StatementParser();
        HashMap<String,Double> itemAndCredit = new HashMap<>();
        itemAndCredit.put("Silver",17.0);
        itemAndCredit.put("Gold",14450.0);
        itemAndCredit.put("Iron",195.5);

        assertEquals(itemAndCredit, statementParser.setUnknownItemAndCredit(input2,words));
    }
}
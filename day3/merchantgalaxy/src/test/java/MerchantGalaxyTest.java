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

        HashMap<String,Integer> items  = new HashMap<>();
        items.put("glob",1);
        items.put("prok",5);
        items.put("pish",10);
        items.put("tegj",50);

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
        HashMap<String, Integer> words = wordToRomanParser.setItemValues(input);

        input2.add("glob glob Silver is 34 Credits");

        StatementParser statementParser = new StatementParser();
        HashMap<String,Integer> itemAndCredit  = new HashMap<>();
        itemAndCredit.put("Silver",17);

        assertEquals(itemAndCredit, statementParser.setUnknownItemAndCredit(input2,words));
    }
}

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
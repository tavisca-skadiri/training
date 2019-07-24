import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
class MerchantGalaxyTest {
    @Test
    void checkRomanToArabicConversion(){
        Converter converter = new Converter();
        ArrayList<String> input = new ArrayList<>();
        input.add("glob is I");
        input.add("prok is V");
        input.add("pish is X");
        input.add("tegj is L");

        HashMap<String,Integer> items  = new HashMap<>();
        items.put("glob",1);
        items.put("prok",5);
        items.put("pish",10);
        items.put("tegj",250);

        assertEquals(items,converter.setItemValues(input));
    }
    @Test
    void setItemAndCredits(){
        Converter converter = new Converter();
        ArrayList<String> input = new ArrayList<>();

        input.add("glob glob Silver is 34 Credits");
        input.add("glob prok Gold is 57800 Credits");
        input.add("pish pish Iron is 3910 Credits");

        HashMap<String,Integer> itemAndCredit  = new HashMap<>();
        itemAndCredit.put("Silver",34);
        itemAndCredit.put("Gold",57800);
        itemAndCredit.put("Iron",3910);

        assertEquals(itemAndCredit,converter.setUnknownItemAndCredit(input));
    }
}

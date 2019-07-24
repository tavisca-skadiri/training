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

        HashMap<String,Integer> arabicSymbols  = new HashMap<>();
        arabicSymbols.put("glob",1);
        arabicSymbols.put("prok",5);
        arabicSymbols.put("pish",10);
        arabicSymbols.put("tegj",250);

        assertEquals(arabicSymbols,converter.getArabicSymbols(input));
    }
}

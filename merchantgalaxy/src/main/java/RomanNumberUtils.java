import java.util.HashMap;
class RomanNumberUtils {
    static final HashMap<String,Double> romanToIntegerMap = new HashMap<>(){{
        put("I",1.0);
        put("V",5.0);
        put("X",10.0);
        put("L",50.0);
        put("C",100.0);
        put("D",500.0);
        put("M",1000.0);
    }};
    static double romanToDecimal(String romanNumber) {
        double res = 0;
        for (int alphabet=0; alphabet<romanNumber.length(); alphabet++) {
            double currentRomanNumber = romanToIntegerMap.get(String.valueOf(romanNumber.charAt(alphabet)));
            if ( alphabet+1 < romanNumber.length()) {
                double nextRomanNumber = romanToIntegerMap.get(String.valueOf(romanNumber.charAt(alphabet + 1)));
                if (currentRomanNumber >= nextRomanNumber)
                    res += currentRomanNumber;
                else {
                    res += nextRomanNumber - currentRomanNumber;
                    alphabet++;
                }
            }
            else {
                res += currentRomanNumber;
                alphabet++;
            }
        }
        return res;
    }
}
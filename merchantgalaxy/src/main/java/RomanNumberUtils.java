import java.util.HashMap;
import java.util.regex.Pattern;
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
        double result = 0;
        if(isRomanNumberValid(romanNumber)) {
            for (int alphabet = 0; alphabet < romanNumber.length(); alphabet++) {
                double currentRomanNumber = romanToIntegerMap.get(String.valueOf(romanNumber.charAt(alphabet)));
                if (alphabet + 1 < romanNumber.length()) {
                    double nextRomanNumber = romanToIntegerMap.get(String.valueOf(romanNumber.charAt(alphabet + 1)));
                    if (currentRomanNumber >= nextRomanNumber)
                        result += currentRomanNumber;
                    else {
                        result += nextRomanNumber - currentRomanNumber;
                        alphabet++;
                    }
                } else {
                    result += currentRomanNumber;
                    alphabet++;
                }
            }
        }
        return result;
    }
    static boolean isRomanNumberValid(String romanNumeral){
        return Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$")
                    .matcher(romanNumeral)
                    .matches();
    }
}
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionParser {
    int getHowMuchValue(ArrayList<String> input, HashMap<String, Double> knownWords, HashMap<String, Double> unknownWords ){
        int value = 0;
        for(String line : input) {
            String[] elements = line.split(" ");
            for (String element : elements){
                if(knownWords.containsKey(element)){

                }
            }
        }
        return value;
    }
}
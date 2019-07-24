import java.util.ArrayList;
import java.util.HashMap;

public class StatementParser {
    public HashMap<String, Integer> setUnknownItemAndCredit(ArrayList<String> input, HashMap<String, Integer> words){
        HashMap<String, Integer> unknownWords = new HashMap<>();
        for(String line : input) {
            String word1 = line.split(" ")[0];
            String word2 = line.split(" ")[1];
            String unknownWord = line.split(" ")[2];
            int credits = Integer.parseInt(line.split(" ")[4]);
            int value = credits / (words.get(word1) + words.get(word2));
            unknownWords.put(unknownWord,value);
        }
        return unknownWords;
    }

}

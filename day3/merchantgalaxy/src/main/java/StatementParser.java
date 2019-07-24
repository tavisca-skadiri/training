import java.util.ArrayList;
import java.util.HashMap;

public class StatementParser {
    public HashMap<String, Double> setUnknownItemAndCredit(ArrayList<String> input, HashMap<String, Double> words){
        HashMap<String, Double> unknownWords = new HashMap<>();
        for(String line : input) {
            String word1 = line.split(" ")[0];
            String word2 = line.split(" ")[1];
            String unknownWord = line.split(" ")[2];
            int credits = Integer.parseInt(line.split(" ")[4]);
            double value = calculateValueFromCredits(credits,word1,word2,words);
            unknownWords.put(unknownWord,value);
        }
        return unknownWords;
    }
    private double calculateValueFromCredits(int credits,String word1, String word2,HashMap<String,Double> words){
        double value;
        if(words.get(word1) < words.get(word2))
            value = credits / (words.get(word2) - words.get(word1));
        else
            value = credits / ((words.get(word2) + words.get(word1)));
        return value;
    }
}
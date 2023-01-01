import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfWords {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("src/utils/economistArticle.txt");
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader(path.toFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Map<String, Integer> wordOccurrences = new HashMap<>();
        String currentLine = bf.readLine();
        while (currentLine != null){
           // System.out.println(currentLine);
            if (!currentLine.trim().equals("")) {  //to skip over empty lines, to not try to split empty lines
                String[] lineWords = currentLine.split(" ");
                for (String word: lineWords) {
                    if (word == null || word.trim().equals(" ")) {
                        continue;
                    }
                    String processedWord = word.toLowerCase().replace(",","").replace(".","")
                            .replace("(","").replace(")","");

                        if (!wordOccurrences.containsKey(processedWord)) {
                            wordOccurrences.put(processedWord, 1);
                        } else {
                            wordOccurrences.replace(processedWord, wordOccurrences.get(processedWord)+1);
                        }

                }
            }
            currentLine = bf.readLine();

        }
        System.out.println(wordOccurrences);

        int mostFrequentWordCount = 0;
        String mostFrequentWord = "";
        for (String s : wordOccurrences.keySet()){
            if (wordOccurrences.get(s) > mostFrequentWordCount) {
                mostFrequentWordCount = wordOccurrences.get(s);
                mostFrequentWord = s;
            }

        }
        System.out.printf("The most frequently used word is: '%s', used %d times", mostFrequentWord, mostFrequentWordCount );
    }
}



















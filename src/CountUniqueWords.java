import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class CountUniqueWords {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"))   //gets pwd of running program
                .resolve("src/utils/economistArticle.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path.toFile()));
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException(fnfe);
        }

        Set<String> wordSet = new HashSet<>();
        String currentLine = br.readLine();
        int totalWords = 0;
        while(currentLine!=null) {
            if (!currentLine.trim().equals(" ")) {  //skips over empty lines
                String[] words = currentLine.split(" ");
                totalWords+= words.length;
                for (String word : words) {
                    if (word == null || word.trim().equals(" ")) {
                        continue;
                    }
                    String processedWord = word.toLowerCase().replace(" ", "").replace(",", "")
                            .replace(".", "").replace("(", "").replace(")", "")
                            .replace("/","").replace("\n","").replace(":","");
                    wordSet.add(processedWord);
                }
                currentLine = br.readLine();
            }
        }
        System.out.println(wordSet);
        System.out.printf("The number of unique words in the article = %d, out of %d total words", wordSet.size(), totalWords);

    }























}

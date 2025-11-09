package Lab7.MapReduce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class WordCountTask implements Callable<Map<String, Integer>> {
    private File file;

    public WordCountTask(File file) {
        this.file = file;
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        var wordCount = new HashMap<String, Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            var sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            var words = Arrays.stream(sb.toString().split("\\s+")).map(String::toLowerCase).toList();

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

        } catch (Exception e) {
            System.out.println("Error processing file: " + file.getName());
        }

        return wordCount;
    }


}

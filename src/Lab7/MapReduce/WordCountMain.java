package Lab7.MapReduce;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executors;

public class WordCountMain {
    public static void main(String[] args) throws Exception {
        var files = new File("src/Lab7/MapReduce/files").listFiles();
        var wordCount = new HashMap<String, Integer>();
        var executor = Executors.newFixedThreadPool(10);


        for (File file : files) {
            try {
                var wordCountMap = executor.submit(new WordCountTask(file)).get();

                for (var entry : wordCountMap.entrySet()) {
                    String word = entry.getKey();
                    Integer count = entry.getValue();

                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + count);
                    }
                    else {
                        wordCount.put(word, count);
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        for (var entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }



    }
}

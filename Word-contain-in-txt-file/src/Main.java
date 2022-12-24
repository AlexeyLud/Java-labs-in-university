import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Задан файл с текстом на английском языке. Выделить все различные слова.
        // Для каждого слова подсчитать частоту его встречаемости.
        // Слова, отличающиеся регистром букв, считать различными. Использовать класс HashMap.
        File myFile = new File("D:\\Labs\\src\\text.txt");

        List<String> list = listFromFile(myFile);
        System.out.println("-----------------");
        System.out.println("|Text on english|");
        System.out.println("-----------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("\n");

        HashMap<String, Integer> map = toMap(list);
        System.out.println("-------------------------------------");
        System.out.println("|Count of word contained in our text|");
        System.out.println("-------------------------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            System.out.println("Word is |" + word + "| contain in text = " + count);
        }

        System.exit(0);
    }


    public static List<String> listFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }


    public static HashMap<String, Integer> toMap(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        list.forEach(line -> {
            String words[] = line.split(" ");
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }
        });
        return map;
    }

}

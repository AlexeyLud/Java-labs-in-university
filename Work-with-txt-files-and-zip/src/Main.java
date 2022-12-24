import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Подсчитать, сколько слов в заданном тексте начинается с прописной буквы. Текст находится в файле
        File myFile = new File("D:\\Lab2\\src\\text.txt");
        try (final BufferedReader br = Files.newBufferedReader(myFile.toPath(), StandardCharsets.UTF_8)) {
            int lineCounter = 1;
            String line;
            int summ = 0;
            while ((line = br.readLine()) != null) {
                final int lowerCaseWordsInThisLine = countLowerCaseWords(line);
                System.out.println("Line " + lineCounter + " has " + lowerCaseWordsInThisLine
                        + " lower case word" + (lowerCaseWordsInThisLine == 1 ? "" : "s") + ".");
                lineCounter++;
                summ += lowerCaseWordsInThisLine;
            }
            System.out.println("Count of lowerCase words = " + summ + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        printArr();
        printInfo();
        System.exit(0);
    }

    private static int countLowerCaseWords(final String line) {
        int ret = 0;
        final int length = line.length();
        boolean newWord = true;
        for (int i = 0; i < length; i++) {
            final char c = line.charAt(i);
            if (" .,;/".indexOf(c) >= 0) {
                newWord = true;
            }
            else if (newWord) {
                newWord = false;
                if (Character.isLowerCase(c)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    // Необходимо вывести внизу фамилию разработчика, а также дату и время выполнения задания,
    // а также добавить комментарии в программы в виде /** комментарий */.
    // Вывести элементы массива в обратном порядке
    public static void printInfo() {
        System.out.println("prod. by Mikulchik Alexandr");
        Date date = new Date();
        System.out.println("Date and Time are |" + date + "|");
    }

    public static void printArr() {
        String[] a = { "Это "," вторая "," лаб "," работа"};
        System.out.print("Before: "); //Выводим изначальный массив в консоль
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println();
        int n = a.length;
        String temp; //Переменная, которая будет использоваться при обмене элементов
        for (int i = 0; i < n/2; i++) {
            temp = a[n-i-1];
            a[n-i-1] = a[i];
            a[i] = temp;
        }
        System.out.print("After: "); //Выводим конечный массив в консоль
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println("\n");
    }
}

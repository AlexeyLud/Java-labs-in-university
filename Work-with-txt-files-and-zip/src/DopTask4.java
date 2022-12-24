import java.util.Scanner;

public class DopTask4 {
    public static void main(String[] args) {

        // 4.Напишите программу, печатающую все перестановки строки (из 4 символов)
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("\nВведите строку: ");
            String str = in.next();
            if(str.length() != 4){
                System.out.println("Строка должна содержать 4 символа!");
                System.out.println("Попробуё ещё)");
            }
            else if (str.equals("exit")) {
                break;
            } else {
                printPerestanovki(str,"");
            }
        }
    }

    static void printPerestanovki(String str, String ans) {
        if (str.length() == 0) {
            System.out.println("|" + ans + "|");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPerestanovki(ros, ans + ch);
        }
    }

}

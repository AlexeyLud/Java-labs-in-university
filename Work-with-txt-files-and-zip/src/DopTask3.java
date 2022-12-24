import java.util.Scanner;

public class DopTask3 {
    public static void main(String[] args) {

        // 3.Замените в строке все вхождения одного слова на другое

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("\nВведите строку: ");
            String str = in.nextLine();
            if(str.equals("exit")){
                break;
            }
            else{
                int a = 0;
                System.out.print("Введите заменяемое слово: ");
                String replaseWord = in.nextLine();
                System.out.println("replase word = " + replaseWord);
                System.out.print("Введите слово, которым будем заменять: ");
                String whichWord = in.nextLine();
                System.out.println("which word = " + whichWord);
                a = containWord(str,replaseWord, a);
                if(a == 1){
                    System.out.println("Слово " + replaseWord + " найдено в строке. Можем менять");
                    str = str.replaceAll("\\b" + replaseWord + "\\b", whichWord);
                    System.out.println("newstr = " + str);
                }
                else{
                    System.out.println("Такое слово в данной строке не содержится");
                    System.out.println("Попробуй другую строку либо выйди)");
                }
            }
        }
        System.exit(0);
    }

    public static int containWord(String str, String search, int a){
        if (str.toLowerCase().contains(search.toLowerCase())) {
            a = 1;
        }
        return a;
    }
}

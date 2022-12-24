import java.util.Scanner;

public class DopTask2 {
    public static void main(String[] args) {

        // 2.Напишите метод проверки, является ли строка палиндромом (Строка
        // считается полиндромом, если она одинаково читается в обоих направлениях)

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("\nВведите строку: ");
            String str = in.next();
            if(str.equals("exit")){
                break;
            }
            else{
                String newstr = str.replaceAll("\\W","");
                StringBuilder sb = new StringBuilder(newstr).reverse();
                System.out.println("newstr = " + sb.toString());
                System.out.println("they equals? - " + newstr.equalsIgnoreCase(sb.toString()));
                if(newstr.equalsIgnoreCase(sb.toString())){
                    System.out.println("Строка " + str + " - является полиндромом");
                }
                else{
                    System.out.println("Строка " + str + " - не является полиндромом");
                    System.out.println("Попробуй другую строку либо выйди)");
                }
            }
        }

        System.exit(0);

    }
}

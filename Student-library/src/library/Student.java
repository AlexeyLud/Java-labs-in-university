package library;
import java.util.Scanner;
public class Student {
   String studentName;
    String regNum;
    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;
    Scanner input = new Scanner(System.in);
    public Student(){
        System.out.print("Введите имя студента: ");
        this.studentName = input.nextLine();
        System.out.print("Введите регистрационный номер: ");
        this.regNum = input.nextLine();
    }
}

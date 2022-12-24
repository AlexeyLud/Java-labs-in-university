package library;
import java.util.Scanner;
public class Book {
    public int sNo;
    public String bookName;
    public String authorName;
    public int year;
    public int kolstr;
    public int bookQty;
    public int bookQtyCopy;
    Scanner input = new Scanner(System.in);

    public Book(){
        System.out.print("Введите серийный номер книги: ");
        this.sNo = input.nextInt();
        input.nextLine();
        System.out.print("Введите название книги: ");
        this.bookName = input.nextLine();
        System.out.print("Введите имя автора: ");
        this.authorName = input.nextLine();
        System.out.print("Введите год издания: ");
        this.year = input.nextInt();
        System.out.print("Введите количество страниц: ");
        this.kolstr = input.nextInt();
        System.out.print("Введите количество книг: ");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}

package library;
import java.util.Scanner;
public class Books {
    Book theBooks[] = new Book[50];     // Array that stores 'book' Objects.
    public static int count;    // Counter for No of book objects Added in Array.
    Scanner input = new Scanner(System.in);
    public int compareBookObjects(Book b1, Book b2){
        if (b1.bookName.equalsIgnoreCase(b2.bookName)){
            System.out.println("Книга с таким названием уже существует.");
            return 0;
        }
        if (b1.sNo==b2.sNo){
            System.out.println("Книги этого номера уже не существует.");
            return 0;
        }
        return 1;
    }

    public void addBook(Book b){
        for (int i=0; i<count; i++){
            if (this.compareBookObjects(b, this.theBooks[i]) == 0)
                return;
        }
        if (count<50){
            theBooks[count] = b;
            count++;
        }
        else{
            System.out.println("Нет места для добавления новых книг.");
        }
    }

    public void searchBySno(){
        System.out.println("\t\t\t\t\tПОИСК ПО СЕРИЙНОМУ НОМЕРУ\n");
        int sNo;
        System.out.print("Введите серийный номер книги: ");
        sNo = input.nextInt();
        int flag = 0;
        System.out.printf("%-5s %11s %11s %15s %15s %20s %15s %n", "№", "Название", "Автор", "Год изд-я", "Кол-во стр", "Доступное Кол-во", "Общее Кол-во");
        for (int i=0; i<count; i++){
            if (sNo == theBooks[i].sNo){
                System.out.printf("%-9d %-14s %-12s %-14s %-15s %-19d %-18d %n", theBooks[i].sNo, theBooks[i].bookName, theBooks[i].authorName, theBooks[i].year,
                        theBooks[i].kolstr, theBooks[i].bookQtyCopy, theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("Книги с серийным номером № " + sNo + " не найдено.");
    }

    public void searchByAuthorName(){
        System.out.println("\t\t\t\t\tПОИСК ПО ИМЕНИ АВТОРА");
        input.nextLine();
        System.out.print("Введите имя автора: ");
        String authorName = input.nextLine();
        int flag = 0;
        System.out.printf("%-5s %11s %11s %15s %15s %20s %15s %n", "№", "Название", "Автор", "Год изд-я", "Кол-во стр", "Доступное Кол-во", "Общее Кол-во");
        for (int i=0; i<count; i++){
            if (authorName.equalsIgnoreCase(theBooks[i].authorName)){
                System.out.printf("%-9d %-14s %-12s %-14s %-15s %-19d %-18d %n", theBooks[i].sNo, theBooks[i].bookName, theBooks[i].authorName, theBooks[i].year,
                        theBooks[i].kolstr, theBooks[i].bookQtyCopy, theBooks[i].bookQty);
                flag++;
            }
        }
        if (flag == 0)
            System.out.println("Книги с автором " + authorName + " не найдено.");
    }

    public void showAllBooks(){
        System.out.println("\t\t\t\t\tПОКАЗ ВСЕХ КНИГ\n");
        System.out.printf("%-5s %11s %11s %15s %15s %20s %15s %n", "№", "Название", "Автор", "Год изд-я", "Кол-во стр", "Доступное Кол-во", "Общее Кол-во");
        for (int i=0; i<count; i++){
            System.out.printf("%-9d %-14s %-14s %-14s %-15s %-19d %-18d %n", theBooks[i].sNo, theBooks[i].bookName, theBooks[i].authorName, theBooks[i].year,
                    theBooks[i].kolstr, theBooks[i].bookQtyCopy, theBooks[i].bookQty);
        }
    }

    public void upgradeBookQty(){
        System.out.println("\t\t\t\tОБНОВЛЕНИЕ КОЛИЧЕСТВА КНИГ\n");
        System.out.print("Введите серийный номер книги: ");
        int sNo = input.nextInt();
        for (int i=0; i<count; i++){
            if (sNo == theBooks[i].sNo){
                System.out.print("Введите количество добавляемых книг: ");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
                return;
            }
        }
    }

    public void dispMenu(){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Введите 0. чтобы выйти из приложения");
        System.out.println("Введите 1. чтобы добавить новую книгу");
        System.out.println("Введите 2. чтобы увеличить количество книг");
        System.out.println("Введите 3. для поиска книги");
        System.out.println("Введите 4. чтобы показать все книги");
        System.out.println("Введите 5. чтобы зарегистрировать студента");
        System.out.println("Введите 6. чтобы показать всех зарегистрированных студентов");
        System.out.println("Введите 7. чтобы взять книгу");
        System.out.println("Введите 8. чтобы вернуть книгу");
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(int sNo){
        //returns the index number if available
        for (int i=0; i<count; i++){
            if (sNo == theBooks[i].sNo){
                if(theBooks[i].bookQtyCopy > 0){
                    System.out.println("Книга доступна.");
                    return i;
                }
                System.out.println("Книга недоступна");
                return -1;
            }
        }
        System.out.println("Книга с серийным номером " + sNo + " отсутствует в библиотеке.");
        return -1;
    }

    public Book checkOutBook(){
        System.out.print("Введите серийный номер книги, которую хотите взять: ");
        int sNo = input.nextInt();
        int bookIndex =isAvailable(sNo);
        if (bookIndex!=-1){
            //int bookIndex = isAvailable(sNo);
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInBook(Book b){
        for (int i=0; i<count; i++){
            if (b.equals(theBooks[i]) ){
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}

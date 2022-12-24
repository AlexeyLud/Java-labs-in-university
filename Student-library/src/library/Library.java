package library;
import java.util.Scanner;
public class Library {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    System.out.println("********************Добро пожаловать в Студенческую библиотеку!********************");
    System.out.println("              Пожалуйста, Выберите Один Из Следующих Вариантов:               ");
System.out.println("**********************************************************************");
    Books ob = new Books();
    Students obStudent = new Students();
    int choice;
    int searchChoice;
    do{
        ob.dispMenu();
        choice = input.nextInt();
        switch(choice){
            case 1:
                Book b = new Book();
                ob.addBook(b);
                break;
            case 2:
                ob.upgradeBookQty();
                break;
            case 3:
                System.out.println("Введите 1 для поиска по серийному номеру.");
                System.out.println("Введите 2 для поиска по имени автора.");
                searchChoice = input.nextInt();
                switch(searchChoice){
                    case 1:
                        ob.searchBySno();
                        break;
                    case 2:
                        ob.searchByAuthorName();
                }
                break;
            case 4:
                ob.showAllBooks();
                break;
            case 5:
                Student s = new Student();
                obStudent.addStudent(s);
                break;
            case 6:
                obStudent.showAllStudents();
                break;
            case 7:
                obStudent.checkOutBook(ob);
                break;
            case 8:
                obStudent.checkInBook(ob);
                break;
            default:
                System.out.println("ВЫБОР ДОЛЖЕН БЫТЬ ОТ 0 ДО 8.");
        }
    }
    while (choice!=0);
    }  
}

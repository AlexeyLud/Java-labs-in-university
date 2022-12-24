package library;
import java.util.Scanner;
public class Students {
    Scanner input = new Scanner(System.in);
    Student theStudents[] = new Student[50];//books book;
    public static int count = 0;
    
    public void addStudent(Student s){
        for (int i=0; i<count; i++){
            if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){
                System.out.println("Студент с рег номером " + s.regNum + " уже зарегистрирован.");
                return;
            }
        }
        if (count<=50){
            theStudents[count] = s;
            count++;
        }
    }

    public void showAllStudents(){
        System.out.println("Имя студента\t\tРегистрационный номер");
        for (int i=0; i<count; i++){
            System.out.println(theStudents[i].studentName + "\t\t\t" + theStudents[i].regNum);
        }
    }

    public int isStudent(){
        //return index number of student if available
         //System.out.println("Enter Student Name:");
        //String studentName = input.nextLine();
        System.out.print("Введите регистрационный номер: ");
        String regNum = input.nextLine();
        for (int i=0; i<count; i++){
            if (theStudents[i].regNum.equalsIgnoreCase(regNum)){
                return i;
            }
        }
        System.out.println("Студент не зарегистрирован.");
        System.out.println("Сначала зарегистрируйтесь.");
        return -1;
    }

    public void checkOutBook(Books book){
        int studentIndex =this.isStudent();
        if (studentIndex!=-1){
            System.out.println("проверка...");
            book.showAllBooks();
            Book b = book.checkOutBook();
            System.out.println("проверка окончена");
            if (b!= null){
                if (theStudents[studentIndex].booksCount<=5){
                    System.out.println("добавление книги...");
                    theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                    theStudents[studentIndex].booksCount++;
                    System.out.println("книга добавлена");
                    return;
                }
                else {
                    System.out.println("Студент не может брать более 5 Книг.");
                    return;
                }
            }
            System.out.println("Книга недоступна.");
        }
    }

    public void checkInBook(Books book){
        int studentIndex = this.isStudent();
        if (studentIndex != -1){
            System.out.println("№\t\t\tНазвание книги\t\t\tИмя автора");
            Student s = theStudents[studentIndex];
            for (int i=0; i<s.booksCount; i++){
                System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t\t"+
                        s.borrowedBooks[i].authorName);
            }
            System.out.print("Введите серийный номер книги, которую хотите вернуть: ");
            int sNo = input.nextInt();
            for (int i=0; i<s.booksCount; i++){
                if (sNo == s.borrowedBooks[i].sNo){
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i]=null;
                    System.out.println("Книга успешно возвращена");
                    return;
                }
            }
            System.out.println("Книга серийного номера " + sNo + " не найдена");
        }
    }
}

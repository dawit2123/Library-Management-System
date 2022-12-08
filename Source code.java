import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class LMS {
    int flag = 0;

    public static void main(String[] args) {
        LMS Menu = new LMS();
        Menu = Menu.mainMenu(Menu);
        System.out.println("\n\t\tApplication has been shut down\n");
    }

    private LMS mainMenu(LMS Menu) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        try {
            do {
                System.out.println("\t\t===========================================================================\n");
                System.out.println("\t\t\t\t           Library Management System\n");
                System.out.println("\t\t===========================================================================\n");
                System.out
                        .println("\t\t--------------------------------Main Menu------------------------------------\n");
                System.out.println("\t\t\tPress 1 if you are Librarian or 2 if you are a Member \n");
                System.out.println("\t1. Librarian \n");
                System.out.println("\t2. Member \n");
                System.out.println("\t3. Quit \n");
                System.out
                        .println("\t\t-----------------------------------------------------------------------------\n");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        clearScreen();
                        flag = 1;
                        return Menu.LibrarianMenu(Menu);
                    case 2:
                        clearScreen();
                        flag = 0;
                        return Menu.MembersMenu(Menu);
                    case 3:
                        return Menu;
                    default:
                        clearScreen();
                        System.out.print("Wrong input, please try again !!\n");
                }
            } while (option != 3);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private LMS LibrarianMenu(LMS Menu) {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Librarian Menu--------\n");
        System.out.println("\t\tPlease Enter your name and password\n");
        Librarian Li = new Librarian();
        boolean flag = false;
        boolean login_check = false;
        while (!flag) {
            flag = true;
            Console console = System.console();
            String name = console.readLine("Name:");
            char[] password = console.readPassword("Password:");
            String pwd = new String(password);

            if (name.equals(Li.getLibrarian_name()) && pwd.equals(Li.getPassword())) {
                System.out.println("\t\t\tLogin Successful \n");
                login_check = true;
            } else {
                System.out.println("\t\t\tLogin Failed. Incorrect Name or Password. Please try again !!\n");
                flag = false;
            }
        }
        if (login_check == true) {
            int libMenu_option = 0;
            Book L = new Book();
            Member Me = new Member();
            try {
                do {
                    System.out.println("\t\tChoose what you want to do\n\n");
                    System.out.println("\t1. Add Book \n");
                    System.out.println("\t2. Delete Book\n");
                    System.out.println("\t3. Update Book Information\n");
                    System.out.println("\t4. Search Book\n");
                    System.out.println("\t5. Display All Books\n");
                    System.out.println("\t6. Display All Borrowed Books\n");
                    System.out.println("\t7. Display members who borrowed a book\n");
                    System.out.println("\t8. Back to Main Menu\n");
                    libMenu_option = input.nextInt();
                    switch (libMenu_option) {
                        case 1:
                            L.addBook();
                            break;
                        case 2:
                            L.deleteBook();
                            break;
                        case 3:
                            clearScreen();
                            return Menu.UpdateMenu(Menu);
                        case 4:
                            clearScreen();
                            return Menu.SearchMenu(Menu);
                        case 5:
                            Book.displayAllBooks();
                            break;
                        case 6:
                            Li.displayBooks();
                            break;
                        case 7:
                            Me.displayMembersBorrowed();
                            break;
                        case 8:
                            clearScreen();
                            return Menu.mainMenu(Menu);
                        default:
                            clearScreen();
                            System.out.println("Wrong input, please enter valid option");
                    }
                } while (libMenu_option != 9);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        }
        return Menu;
    }

    private LMS MembersMenu(LMS Menu) {
        clearScreen();
        Scanner input = new Scanner(System.in);
        Member Me = new Member();
        System.out.println("\t\t--------Members Menu--------\n");
        int memMenu_option = 0;
        try {
            do {
                System.out.println("\n\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Issue Book\n");
                System.out.println("\t2. Return Book\n");
                System.out.println("\t3. Search Book\n");
                System.out.println("\t4. Display All Books\n");
                System.out.println("\t5. Display Available Books\n");
                System.out.println("\t6. Back to Main Menu\n");
                BookIssue bi = new BookIssue();
                memMenu_option = input.nextInt();
                switch (memMenu_option) {
                    case 1:
                        BookIssue.issue_book_interface();
                        break;
                    case 2:
                        bi.return_book();
                        break;
                    case 3:
                        clearScreen();
                        return Menu.SearchMenu(Menu);
                    case 4:
                        Book.displayAllBooks();
                        break;
                    case 5:
                        Me.displayBooks();
                        break;
                    case 6:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (memMenu_option != 6);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private LMS SearchMenu(LMS Menu) {
        clearScreen();
        Book S = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Search Menu--------\n");
        int s_option = 0, case_check;
        try {
            do {
                System.out.println("\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Search by Title\n");
                System.out.println("\t2. Search by Book ID\n");
                System.out.println("\t3. Search by Author\n");
                System.out.println("\t4. Search by Genre\n");
                System.out.println("\t5. Back to Previous Menu\n");
                System.out.println("\t6. Back to Main Menu\n");
                s_option = input.nextInt();
                switch (s_option) {
                    case 1:
                        System.out.println("Enter the title of the Book you want to search");
                        case_check = 1;
                        S.searchBook(case_check);
                        break;
                    case 2:
                        System.out.println("Enter the Book ID of the Book you want to search");
                        case_check = 2;
                        S.searchBook(case_check);
                        break;
                    case 3:
                        System.out.println("Enter the Author of the Book you want to search");
                        case_check = 3;
                        S.searchBook(case_check);
                        break;
                    case 4:
                        System.out.println("Enter the Genre of the Book you want to search");
                        case_check = 4;
                        S.searchBook(case_check);
                        break;
                    case 5:
                        clearScreen();
                        if (flag == 0)
                            return MembersMenu(Menu);
                        else
                            return LibrarianMenu(Menu);
                    case 6:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (s_option != 6);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private LMS UpdateMenu(LMS Menu) {
        clearScreen();
        Book S = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Information Update Menu--------\n");
        System.out.print("Which attribute do you want to update\n");
        int s_option = 0, case_check;
        try {
            do {
                System.out.println("\n\t\tChoose what you want to update\n\n");
                System.out.println("\t1. Title\n");
                System.out.println("\t2. Book ID\n");
                System.out.println("\t3. Author\n");
                System.out.println("\t4. Genre\n");
                System.out.println("\t5. Quantity\n");
                System.out.println("\t6. Back to Librarian Menu\n");
                System.out.println("\t7. Back to Main Menu\n");
                s_option = input.nextInt();
                switch (s_option) {
                    case 1:
                        case_check = 1;
                        S.updateBook(case_check);
                        break;
                    case 2:
                        case_check = 2;
                        S.updateBook(case_check);
                        break;
                    case 3:
                        case_check = 3;
                        S.updateBook(case_check);
                        break;
                    case 4:
                        case_check = 4;
                        S.updateBook(case_check);
                        break;
                    case 5:
                        case_check = 5;
                        S.updateBook(case_check);
                        break;
                    case 6:
                        clearScreen();
                        return LibrarianMenu(Menu);
                    case 7:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (s_option != 7);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

interface Person {
    public void displayBooks();
}

class Member implements Person {
    private String member_ID;
    private String name;
    private String phone_no;
    private String email;
    private Address address;

    static ArrayList<Member> MemberList = new ArrayList<Member>(0);

    public Member() {

    }

    public Member(String member_ID, String name, String phone_no, String email, Address address) {
        this.member_ID = member_ID;
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.address = address;
    }

    public String getMember_ID() {
        return this.member_ID;
    }

    public void setMember_ID(String member_ID) {
        this.member_ID = member_ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static Member searchMember(String Mname) {
        Member searchedMember = null;
        for (int i = 0; i < MemberList.size(); i++) {
            if (MemberList.get(i).getName().equalsIgnoreCase(Mname) || MemberList.get(i).getName().contains(Mname)) {
                searchedMember = MemberList.get(i);
            }
        }
        return searchedMember;
    }

    public Member memberForm(String membername) {
        Address A1 = new Address();
        System.out.print("\n\t\tWelcome, new user. Please fill the following form\n");
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t\t+++ Form for new users +++\n");
        System.out.println("Enter Your ID: ");
        member_ID = input.nextLine();
        System.out.println("Enter Your Phone number: ");
        phone_no = input.nextLine();
        System.out.println("Enter your Email: ");
        email = input.nextLine();
        System.out.println("Enter your Address: ");
        char member_type_check = member_ID.charAt(3);
        if (member_type_check != 'S') {
            try {
                System.out.println("Enter the name of the Builing you stay in: ");
                String Bu_name = input.nextLine();
                A1.setBuilding_name(Bu_name);
                System.out.println("Enter your Dorm No.: ");
                int d_no = input.nextInt();
                A1.setDorm_no(d_no);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        } else {
            try {
                System.out.println("Enter the Block number of the Builing your office is found: ");
                int Bl_no = input.nextInt();
                A1.setBuilding_no(Bl_no);
                System.out.println("Enter your Office No.: ");
                int o_no = input.nextInt();
                A1.setOffice_no(o_no);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        }
        Member m1 = new Member(member_ID, membername, phone_no, email, A1);
        MemberList.add(m1);
        return m1;
    }

    public void displayBooks() {
        BookIssue.displayBooksAvailable();
    }

    public void displayMembersBorrowed() {
        boolean flag = false;
        System.out.print("\t\tInformation about Members Who Borrowed a Book \n");
        for (int i = 0; i < MemberList.size(); i++) {
            flag = true;
            System.out.print("\nNo.: " + (i + 1) + "\t");
            System.out.print("\tMember ID: " + MemberList.get(i).getMember_ID() + "\t");
            System.out.print("\tMember Name: " + MemberList.get(i).getName() + "\t");
            System.out.print("\tPhone No.: " + MemberList.get(i).getPhone_no() + "\t");
            System.out.print("\tEmail: " + MemberList.get(i).getEmail() + "\t");
            System.out.print("\nBook Name: " + BookIssue.IssuedBookList.get(i).book_issued.getTitle());

        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
        System.out.println("\n");
    }

}

class Librarian implements Person {
    private String librarian_name = "dawit";
    private String password = "1235";

    public Librarian() {

    }

    Librarian(String name, String password) {
        this.librarian_name = name;
        this.password = password;
    }

    public String getLibrarian_name() {
        return this.librarian_name;
    }

    public void setLibrarian_name(String librarian_name) {
        this.librarian_name = librarian_name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayBooks() {
        BookIssue.displayBooksIssued();
    }
}

class Student extends Member {
    Address A = new Address();

    public void displayMemberAddress() {
        System.out.print("Building Name: " + A.getBuilding_name());
        System.out.print("Dorm No.: " + A.getDorm_no());
    }

}

class Staff extends Member {
    Address A = new Address();

    public void displayMemberAddress() {
        System.out.print("Building No.: " + A.getBuilding_no());
        System.out.print("Office No.: " + A.getOffice_no());
    }

}

class Book {
    private String title;
    private String book_ID;
    private int quantity;
    private String author;
    private String genre;

    static ArrayList<Book> BookList = new ArrayList<Book>(0);

    public Book() {

    }

    public Book(String title, String book_ID, int quantity, String author, String genre) {
        this.title = title;
        this.book_ID = book_ID;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
    }

    public Book(Book B) {
        this.title = B.title;
        this.book_ID = B.book_ID;
        this.quantity = B.quantity;
        this.author = B.author;
        this.genre = B.genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_ID() {
        return this.book_ID;
    }

    public void setBook_ID(String book_ID) {
        this.book_ID = book_ID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void display() {
        LMS.clearScreen();
        System.out.println("\t\t---Book Details---");
        System.out.println("\tNo.: " + (BookList.size() + 1));
        System.out.println("\tBook Name: " + this.title);
        System.out.println("\tBook ID: " + this.book_ID);
        System.out.println("\tAuthor Name: " + this.author);
        System.out.println("\tGenre : " + this.genre);
        System.out.println("\tAvailable Books: " + this.quantity);
    }

    public static void displayAllBooks() {
        boolean flag = false;
        System.out.print("\t\tAll Books in the Library \n");
        for (int i = 0; i < BookList.size(); i++) {
            flag = true;
            System.out.print("\nNo.: " + (i + 1) + "\t");
            System.out.print("\tBook ID: " + BookList.get(i).getBook_ID() + "\t");
            System.out.print("\tBook name: " + BookList.get(i).getTitle() + "\t");
            System.out.print("\tAuthor: " + BookList.get(i).getAuthor() + "\t");
            System.out.print("\tGenre: " + BookList.get(i).getGenre() + "\t");
            System.out.print("\tQuantity: " + BookList.get(i).getQuantity());

        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
        System.out.println("\n");
    }

    public static void displayBooks(int n) {
        System.out.print("\nNo.: " + (n + 1) + "\t");
        System.out.print("\tBook ID: " + BookList.get(n).getBook_ID() + "\t");
        System.out.print("\tBook name: " + BookList.get(n).getTitle() + "\t");
        System.out.print("\tAuthor: " + BookList.get(n).getAuthor() + "\t");
        System.out.print("\tGenre: " + BookList.get(n).getGenre() + "\t");
        System.out.print("\tQuantity: " + BookList.get(n).getQuantity());

    }

    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("\t\t+++ Menu for Adding Book +++\n");
        System.out.println("Enter Book Name: ");
        title = input.nextLine();
        System.out.println("Enter Book ID: ");
        book_ID = input.nextLine();
        System.out.println("Enter Author Name: ");
        author = input.nextLine();
        System.out.println("Enter Genre: ");
        genre = input.nextLine();
        try {
            System.out.println("Enter Quantity(int): ");
            quantity = input.nextInt();

            Book b1 = new Book(title, book_ID, quantity, author, genre);
            b1.display();
            BookList.add(b1);
            System.out.println("\n*Book Added Successflly*\n");
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
    }

    public void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--- Book Deletion ---\n");
        System.out.println("Enter the Book Name to delete: ");
        title = input.nextLine();

        boolean flag = false;
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(title)) {
                BookList.remove(i);
                flag = true;
                System.out.println("\n*BOOK DELETED SUCCESSFULLY*\n");
            }
        }
        if (flag == false)
            System.out.println("\n*BOOK IS NOT FOUND*\n");

    }

    public void searchBook(int case_check) {
        Scanner input = new Scanner(System.in);
        String att = input.nextLine();
        boolean avail = false;
        if (case_check == 1) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getTitle().equalsIgnoreCase(att) || BookList.get(i).getTitle().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n*Book Not Found*\n");

        } else if (case_check == 2) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getBook_ID().equalsIgnoreCase(att)
                        || BookList.get(i).getBook_ID().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n*Book Not Found*\n");

        } else if (case_check == 3) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getAuthor().equalsIgnoreCase(att)
                        || BookList.get(i).getAuthor().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n*Book Not Found*\n");

        } else if (case_check == 4) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getGenre().equalsIgnoreCase(att) || BookList.get(i).getGenre().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n*Book Not Found*\n");
        }

    }

    public static Book searchBook(String Bname) {
        Book searchedBook = null;
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(Bname) || BookList.get(i).getTitle().contains(Bname)) {
                searchedBook = BookList.get(i);
            }
        }
        return searchedBook;
    }

    public void updateBook(int case_check) {
        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String attribute;
        int quantity;
        System.out.print("Enter the position of the book you want to update: ");
        int pos = input.nextInt();
        int index = pos - 1;
        while (pos > BookList.size()) {
            System.out.print("The number of books available is less than waht you entered, please try again\n");
            pos = input.nextInt();
        }
        if (case_check == 1) {
            try {
                System.out.println("Enter the new title of the Book");
                attribute = reader.readLine();
                BookList.get(index).setTitle(attribute);
                System.out.print("\t\tTitle updated successfully!!\n");
                displayBooks(index);
            } catch (IOException e) {
                System.out.println("Menu.Error()");
            }
        } else if (case_check == 2) {
            try {
                System.out.println("Enter the new Book ID of the Book");
                attribute = reader.readLine();
                BookList.get(index).setBook_ID(attribute);
                System.out.print("\t\tBook ID updated successfully!!\n");
                displayBooks(index);
            } catch (IOException e) {
                System.out.println("Menu.Error()");
            }
        } else if (case_check == 3) {
            try {
                System.out.println("Enter the new Author of the Book");
                attribute = reader.readLine();
                BookList.get(index).setAuthor(attribute);
                System.out.print("\t\tAuthor updated successfully!!\n");
                displayBooks(index);
            } catch (IOException e) {
                System.out.println("Menu.Error()");
            }
        } else if (case_check == 4) {
            try {
                System.out.println("Enter the new Genre of the Book");
                attribute = reader.readLine();
                BookList.get(index).setGenre(attribute);
                System.out.print("\t\tGenre updated successfully!!\n");
                displayBooks(index);
            } catch (IOException e) {
                System.out.println("Menu.Error()");
            }
        } else if (case_check == 5) {
            try {
                System.out.println("Enter the new Quantity of the Book");
                quantity = input.nextInt();
                BookList.get(index).setQuantity(quantity);
                System.out.print("\t\tQuantity updated successfully!!\n");
                displayBooks(index);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        }

    }

    public static void increaseBookQuantity(Book b) {
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(b.getTitle())) {
                BookList.get(i).setQuantity(BookList.get(i).getQuantity() + 1);
            }
        }
    }

    public static void decreaseBookQuantity(Book b) {
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(b.getTitle())) {
                BookList.get(i).setQuantity(BookList.get(i).getQuantity() - 1);
            }
        }
    }

}

class BookIssue {
    private Member member;
    Book book_issued;
    private Date issue_date;
    private Date return_date;

    static ArrayList<BookIssue> IssuedBookList = new ArrayList<BookIssue>(0);

    public BookIssue() {

    }

    public BookIssue(Member member, Book book_issued, Date issue_date) {
        this.member = member;
        this.book_issued = book_issued;
        this.issue_date = new Date(issue_date);
    }

    public Date getIssue_date() {
        return this.issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return this.return_date;
    }

    public void setReturn_date(Date issueDate) {
        int day = issue_date.getDay();
        int month = issue_date.getMonth();
        int year = issue_date.getYear();
        if (day > 28 && month == 12) {
            day = (day + 3) - 30;
            month = 1;
            year++;
        } else if (day > 28) {
            day = (day + 3) - 30;
            month++;
        } else
            day = day + 3;
        return_date = new Date(day, month, year);
    }

    public static Date issueDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t---- Issue Date Details ----\n");
        System.out.println("Enter Day: ");
        int day = input.nextInt();
        System.out.println("Enter Month: ");
        int month = input.nextInt();
        System.out.println("Enter Year: ");
        int year = input.nextInt();
        Date iDate = new Date(day, month, year);
        return iDate;

    }

    public static void issue_book_interface() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t--------Book Issue Option--------\n");
        System.out.println("Enter the title of the book you want to borrow: ");
        String issueBookName = input.nextLine();
        Book book1 = Book.searchBook(issueBookName);
        if (book1 != null) {
            if (book1.getQuantity() > 0) {
                System.out.println("Enter Member name: ");
                String memberName1 = input.nextLine();
                Member member1 = Member.searchMember(memberName1);
                if (member1 != null) {
                    System.out.print(memberName1 + " , Welcome once again !!\n");
                    Date stDate = issueDetails();
                    BookIssue BI = new BookIssue(member1, book1, stDate);
                    BI.setReturn_date(stDate);
                    BI.issue_book();
                    System.out.print("\n\t\tBook Issued Successfully, Happy Reading " +
                            memberName1);
                } else {
                    Member M1 = new Member();
                    M1 = M1.memberForm(memberName1);
                    Date stDate = issueDetails();
                    BookIssue BI = new BookIssue(M1, book1, stDate);
                    BI.setReturn_date(stDate);
                    BI.issue_book();
                    System.out.print("\n\t\tBook Issued Successfully, Happy Reading " +
                            memberName1);
                }
            } else
                System.out.print("\nBook is not Available");
        } else
            System.out.print("\nBook Not Found");

    }

    public void issue_book() {
        Book.decreaseBookQuantity(this.book_issued);
        IssuedBookList.add(this);
        System.out.println("\n*BOOK ISSUED SUCCESSFULLY*\n");
    }

    public void return_book() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t--------Book Return Option--------\n");
        System.out.println("Enter the title of the book you want to return: ");
        String returnBookName = input.nextLine();
        System.out.println("Enter Your name, Please: ");
        String memberName1 = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < IssuedBookList.size(); i++) {
            if (IssuedBookList.get(i).book_issued.getTitle().equalsIgnoreCase(returnBookName) &&
                    IssuedBookList.get(i).member.getName().equalsIgnoreCase(memberName1)) {
                flag = true;
                Book.increaseBookQuantity(IssuedBookList.get(i).book_issued);
                IssuedBookList.remove(i);
                System.out.println("\n*BOOK RETURNED SUCCESSFULY*\n");
            }
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }

    }

    public static void displayBooksIssued() {
        boolean flag = false;
        for (int i = 0; i < IssuedBookList.size(); i++) {
            flag = true;
            System.out.print("\n\nBook Name: " + IssuedBookList.get(i).book_issued.getTitle());
            System.out.println("\t\tBorrowed By: " + IssuedBookList.get(i).member.getName());
            System.out.print("Issued Date: ");
            IssuedBookList.get(i).issue_date.display();
            System.out.print("\t\tReturn Date: ");
            IssuedBookList.get(i).return_date.display();
            System.out.print("\n");
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
    }

    public static void displayBooksAvailable() {
        System.out.print("\n\t\t---- Books Currently Available ----");
        boolean flag = false;
        for (int i = 0; i < Book.BookList.size(); i++) {
            if (Book.BookList.get(i).getQuantity() > 0) {
                flag = true;
                System.out.print("\nNo.: " + (i + 1) + "\t");
                System.out.print("\tBook ID: " + Book.BookList.get(i).getBook_ID() + "\t");
                System.out.print("\tBook name: " + Book.BookList.get(i).getTitle() + "\t");
                System.out.print("\tAuthor: " + Book.BookList.get(i).getAuthor() + "\t");
                System.out.print("\tGenre: " + Book.BookList.get(i).getGenre() + "\t");
                System.out.print("\tQuantity: " + Book.BookList.get(i).getQuantity());
            }
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
    }

}

class Address {
    private String building_name;
    private int dorm_no;
    private int building_no;
    private int office_no;

    public Address() {

    }

    public Address(String building_name, int dorm_no, int building_no, int office_no) {
        this.building_name = building_name;
        this.dorm_no = dorm_no;
        this.building_no = building_no;
        this.office_no = office_no;
    }

    public Address(Address A) {
        this.building_name = A.building_name;
        this.dorm_no = A.dorm_no;
        this.building_no = A.building_no;
        this.office_no = A.office_no;
    }

    public String getBuilding_name() {
        return this.building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public int getDorm_no() {
        return this.dorm_no;
    }

    public void setDorm_no(int dorm_no) {
        this.dorm_no = dorm_no;
    }

    public int getBuilding_no() {
        return this.building_no;
    }

    public void setBuilding_no(int building_no) {
        this.building_no = building_no;
    }

    public int getOffice_no() {
        return this.office_no;
    }

    public void setOffice_no(int office_no) {
        this.office_no = office_no;
    }

}

class Date {
    private int month;
    private int day;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2022;
    }

    public Date(int day, int month, int year) {
        this.year = year;
        this.month = checkMonth(month);
        this.day = checkDay(day);
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = checkDay(day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = checkMonth(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) {
            return testMonth;
        } else {
            return 1;
        }
    }

    public int checkDay(int testDay) {
        int[] daysMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (testDay > 0 && testDay <= daysMonth[this.month]) {
            return testDay;
        }

        if ((this.month == 2 && testDay == 29)
                && ((this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0))) {
            return testDay;
        } else {
            return 1;
        }
    }

    public String toString() {
        return String.format("%d,%d,%d", month, day, year);
    }

    public void display() {
        System.out.print(this.day + " / " + this.month + " / " + this.year);
    }
}

package Library_Management_System;
import java.util.*;

// Book Class with fields
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    // Create contructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

// User Class with fields
class User {
    private int id;
    private String name;

    //Create constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

// Library Class with fields
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // create method for Add Book  
    public void addBook(Book book) {
        books.add(book);
    }

    // create method for Add User 
    public void addUser(User user) {
        users.add(user);
    }

    // create method for Show Book
    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // create method for Issue Books
    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (!book.isIssued()) {
                book.issue();
                System.out.println(user.getName() + " issued " + book.getTitle());
            } else {
                System.out.println("Book already issued!");
            }
        } else {
            System.out.println("Book or User not found.");
        }
    }

    // create method for Return Books
    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (book.isIssued()) {
                book.returnBook();
                System.out.println(user.getName() + " returned " + book.getTitle());
            } else {
                System.out.println("Book was not issued!");
            }
        } else {
            System.out.println("Book or User not found.");
        }
    }

    // create method for Find the Books by Id
    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    // create method for Find Users by Id
    private User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));
        library.addUser(new User(1, "Ram"));
        library.addUser(new User(2, "Shyam"));

        while (true) {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                 library.showBooks();
                 break;
                case 2:{
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                    break;
                }
                case 3:{
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.returnBook(bookId, userId);
                    break;
                }
                case 4:{
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default:{
                    System.out.println("Invalid choice!");
                }
            }
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create users...
        Admin admin = new Admin();
        User user = new User();
        Library library = new Library();
        user.id = "id";
        user.name = "name";

        User user1 = new User();
        user1.id = "unique-id";
        user1.name = "Mike";

        admin.addUser(user, library);
        admin.addUser(user1, library);

        System.out.println("====================================================");
        List<User> users = user.viewAllAvailableUsers(library);
        users.stream()
                .map(item -> item.name)
                .forEach(System.out::println);
        // Create books...
        // View all books...
        // View all users...

        // Borrow book...
        // Change book title...
        // check if issued...
    }
}

class Book {
    public String title;
    private boolean isIssued;

    public Book( String title, boolean isIssued ) {
        this.title = title;
        this.isIssued = isIssued;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
        System.out.println("Title successfully changed to " + title);
    }
    public String checkIfIssued() {
        String issueMessage = "The book is:";
        if(isIssued) issueMessage = issueMessage + "Issued.";
        else issueMessage = issueMessage + "Not issued.";
        return issueMessage;
    };
    public void borrowBook() {
        if(isIssued) System.out.println("Could not borrow. Book already borrowed!");
        else {
            isIssued = true;
            System.out.println("Book borrowed successfully.");
        };
    }
}

class User {
    public String id;
    public String name;

    public void borrowBook(Book book) {
        book.borrowBook();
    };
    public List<Book> viewAllAvailableBooks(Library library) {
        System.out.println("Getting books...");
        return library.viewAllAvailableBooks();
    };
    public List<User> viewAllAvailableUsers(Library library) {
        System.out.println("Getting users...");
        return library.viewAllAvailableUsers();
    };
}

class Admin extends User {
    public void addBook(Book book, Library library) {
        library.addBook(book);
    }
    public void addUser(User user, Library library) {
        System.out.println("Adding user " + user.name);
        library.addUser(user);
        System.out.println(user.name + " " + "Was added successfully.");
    }
}

class Library {
    public List<Book> books;
    public List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        System.out.println("Adding the book: " + book.title + "into the system...");
        books.add(book);
        System.out.println(book.title + "was added successfully.");
    };
    public void addUser(User user) {
        if(user != null) users.add(user);
        else System.out.println("Could not create user because user was not provided");
    };
    public List<Book> viewAllAvailableBooks() {
        return books;
    }
    public List<User> viewAllAvailableUsers() {
        return users;
    }
}
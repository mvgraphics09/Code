import java.util.*;

class Book {
    int id;
    String title;
    boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name;
    }
}

class IssueRecord {
    Book book;
    User user;
    Date issueDate;
    Date endDate;

    public IssueRecord(Book book, User user, Date issueDate, Date endDate) {
        this.book = book;
        this.user = user;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Book: " + book.title + ", User: " + user.name + ", Issue Date: " + issueDate + ", Due Date: " + endDate;
    }
}

public class project {
    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static List<IssueRecord> issueRecords = new ArrayList<>();

    static final int PENALTY_PER_DAY = 10;

    public static void addBook(int id, String title) {
        books.add(new Book(id, title));
        System.out.println("Book added successfully!");
    }

    public static void addUser(int id, String name) {
        users.add(new User(id, name));
        System.out.println("User added successfully!");
    }

    public static void issueBook(int bookId, int userId, Date issueDate, Date endDate) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null) {
            if (!book.isIssued) {
                book.isIssued = true;
                issueRecords.add(new IssueRecord(book, user, issueDate, endDate));
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Invalid book or user ID.");
        }
    }

    public static void returnBook(int bookId, Date returnDate) {
        IssueRecord record = findIssueRecordByBookId(bookId);
        if (record != null) {
            Book book = record.book;
            book.isIssued = false;
            issueRecords.remove(record);

            long diff = returnDate.getTime() - record.endDate.getTime();
            long daysLate = diff / (1000 * 60 * 60 * 24);

            if (daysLate > 0) {
                System.out.println("Book returned late! Penalty: " + (daysLate * PENALTY_PER_DAY) + " units.");
            } else {
                System.out.println("Book returned on time!");
            }
        } else {
            System.out.println("No record found for the given book ID.");
        }
    }

    private static Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.id == bookId) {
                return book;
            }
        }
        return null;
    }

    private static User findUserById(int userId) {
        for (User user : users) {
            if (user.id == userId) {
                return user;
            }
        }
        return null;
    }

    private static IssueRecord findIssueRecordByBookId(int bookId) {
        for (IssueRecord record : issueRecords) {
            if (record.book.id == bookId) {
                return record;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adding sample data
        addBook(1, "Java Programming");
        addBook(2, "Data Structures");
        addUser(1, "Alice");
        addUser(2, "Bob");

        // Menu-driven program
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    addBook(bookId, title);
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    addUser(userId, name);
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Enter issue date (dd-mm-yyyy): ");
                    String issueDateStr = scanner.next();
                    System.out.print("Enter due date (dd-mm-yyyy): ");
                    String dueDateStr = scanner.next();
                    try {
                        Date issueDate = new Date(issueDateStr);
                        Date endDate = new Date(dueDateStr);
                        issueBook(bookId, userId, issueDate, endDate);
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter return date (yyyy-mm-dd): ");
                    String returnDateStr = scanner.next();
                    try {
                        Date returnDate = new Date(returnDateStr);
                        returnBook(bookId, returnDate);
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 5:
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 6:
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
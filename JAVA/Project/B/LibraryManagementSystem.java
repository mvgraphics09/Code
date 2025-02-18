import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

class Book {
    int id;
    String name, author;
    boolean issued;
    String issuedTo;
    LocalDate issueDate;
    LocalDate dueDate;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.issued = false;
        this.issuedTo = "";
        this.issueDate = null;
        this.dueDate = null;
    }
}

class Student {
    int id;
    String name;
    int penalty;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.penalty = 0;
    }
}

public class LibraryManagementSystem extends JFrame {
    private ArrayList<Book> books = new ArrayList<>();
    private HashMap<Integer, Student> students = new HashMap<>();
    private JTextArea displayArea;
    private JTextArea recordArea;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JButton registerStudentBtn = new JButton("Register Student");
        JButton viewStudentsBtn = new JButton("View Students");
        JButton addBookBtn = new JButton("Add Book");
        JButton viewBooksBtn = new JButton("View Books");
        JButton issueBookBtn = new JButton("Issue Book");
        JButton returnBookBtn = new JButton("Return Book");
        JButton deleteStudentBtn = new JButton("Delete Student");
        JButton deleteBookBtn = new JButton("Delete Book");

        panel.add(registerStudentBtn);
        panel.add(viewStudentsBtn);
        panel.add(addBookBtn);
        panel.add(viewBooksBtn);
        panel.add(issueBookBtn);
        panel.add(returnBookBtn);
        panel.add(deleteStudentBtn);
        panel.add(deleteBookBtn);

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        recordArea = new JTextArea(10, 40);
        recordArea.setEditable(false);
        JScrollPane recordScrollPane = new JScrollPane(recordArea);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(scrollPane); 
        mainPanel.add(recordScrollPane);

        add(panel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        registerStudentBtn.addActionListener(e -> registerStudent());
        viewStudentsBtn.addActionListener(e -> viewStudents());
        addBookBtn.addActionListener(e -> addBook());
        viewBooksBtn.addActionListener(e -> viewBooks());
        issueBookBtn.addActionListener(e -> issueBook());
        returnBookBtn.addActionListener(e -> returnBook());
        deleteStudentBtn.addActionListener(e -> deleteStudent());
        deleteBookBtn.addActionListener(e -> deleteBook());

        setVisible(true);
    }

    public void registerStudent() {
        String idStr = JOptionPane.showInputDialog("Enter Student ID:");
        String name = JOptionPane.showInputDialog("Enter Student Name:");

        if (idStr != null && name != null) {
            try {
                int id = Integer.parseInt(idStr);
                if (students.containsKey(id)) {
                    JOptionPane.showMessageDialog(this, "Student ID already exists!");
                } else {
                    students.put(id, new Student(id, name));
                    JOptionPane.showMessageDialog(this, "Student Registered Successfully!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid ID! Please enter a number.");
            }
        }
    }

    public void viewStudents() {
        StringBuilder sb = new StringBuilder("Registered Students:\n");
        for (Student student : students.values()) {
            sb.append("ID: ").append(student.id)
              .append(", Name: ").append(student.name)
              .append(", Penalty: ₹").append(student.penalty)
              .append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public void addBook() {
        String idStr = JOptionPane.showInputDialog("Enter Book ID:");
        String name = JOptionPane.showInputDialog("Enter Book Name:");
        String author = JOptionPane.showInputDialog("Enter Author Name:");

        if (idStr != null && name != null && author != null) {
            try {
                int id = Integer.parseInt(idStr);
                books.add(new Book(id, name, author));
                JOptionPane.showMessageDialog(this, "Book Added Successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid ID! Please enter a number.");
            }
        }
    }

    public void viewBooks() {
        StringBuilder sb = new StringBuilder("Book List:\n");
        for (Book book : books) {
            sb.append("ID: ").append(book.id)
              .append(", Name: ").append(book.name)
              .append(", Author: ").append(book.author)
              .append(", Issued: ").append(book.issued ? "Yes (To: " + book.issuedTo + ")" : "No")
              .append(", Due Date: ").append(book.dueDate != null ? book.dueDate : "N/A")
              .append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public void issueBook() {
        String bookIdStr = JOptionPane.showInputDialog("Enter Book ID to Issue:");
        String studentIdStr = JOptionPane.showInputDialog("Enter Student ID:");
        String durationStr = JOptionPane.showInputDialog("Enter duration (1 to 7 days):");

        if (bookIdStr != null && studentIdStr != null && durationStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                int studentId = Integer.parseInt(studentIdStr);
                int duration = Integer.parseInt(durationStr);

                if (!students.containsKey(studentId)) {
                    JOptionPane.showMessageDialog(this, "Student not registered!");
                    return;
                }

                for (Book book : books) {
                    if (book.id == bookId && !book.issued) {
                        book.issued = true;
                        book.issuedTo = students.get(studentId).name;
                        book.issueDate = LocalDate.now();
                        book.dueDate = book.issueDate.plusDays(duration);
                        JOptionPane.showMessageDialog(this, "Book Issued Successfully!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found or already issued!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers.");
            }
        }
    }

    public void returnBook() {
        String bookIdStr = JOptionPane.showInputDialog("Enter Book ID to Return:");
        String returnDateStr = JOptionPane.showInputDialog("Enter Return Date (YYYY-MM-DD):");

        if (bookIdStr != null && returnDateStr != null) {
            try {
                int bookId = Integer.parseInt(bookIdStr);
                LocalDate returnDate = LocalDate.parse(returnDateStr);

                for (Book book : books) {
                    if (book.id == bookId && book.issued) {
                        if (returnDate.isAfter(book.dueDate)) {
                            Student student = students.values().stream()
                                    .filter(s -> s.name.equals(book.issuedTo))
                                    .findFirst().orElse(null);
                            if (student != null) {
                                student.penalty += 50;
                                JOptionPane.showMessageDialog(this, "Late Return! ₹50 Penalty Applied.");
                            }
                        }
                        book.issued = false;
                        book.issuedTo = "";
                        JOptionPane.showMessageDialog(this, "Book Returned Successfully!");
                        return;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        }
    }

    public void deleteStudent() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to Delete:"));
        students.remove(id);
        JOptionPane.showMessageDialog(this, "Student Deleted Successfully!");
    }

    public void deleteBook() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to Delete:"));
        books.removeIf(book -> book.id == id);
        JOptionPane.showMessageDialog(this, "Book Deleted Successfully!");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();  
    }
}
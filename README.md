# Library Management System (Java OOP Project)

## Project Overview
This is a **mini Library Management System** built using **Java and Object-Oriented Programming (OOP)** concepts.  
It allows managing **Books** and **Users**, with features like issuing and returning books.  

The project is simple and can be run in **VS Code / Terminal**.

---

## Tools Used
- **Language**: Java  
- **Editor**: VS Code  
- **Execution**: Terminal  

---

## Project Structure
The project contains the following classes:

### 1. **Book**
- Fields: `id`, `title`, `author`, `isIssued`
- Methods:
  - `issue()` → Marks book as issued  
  - `returnBook()` → Marks book as available  
  - `toString()` → Shows book details  

### 2. **User**
- Fields: `id`, `name`  
- Methods: `toString()` → Shows user details  

### 3. **Library**
- Stores list of books and users  
- Methods:  
  - `addBook(Book book)` → Add new book  
  - `addUser(User user)` → Add new user  
  - `showBooks()` → Display all books  
  - `issueBook(int bookId, int userId)` → Issue a book  
  - `returnBook(int bookId, int userId)` → Return a book  

### 4. **LibraryManagementSystem (Main Class)**
- Contains the **menu-driven program**  
- User can choose from options:  
  1. Show Books  
  2. Issue Book  
  3. Return Book  
  4. Exit  

---
## Sample Output
--- Library Management System Menu ---
1. Show Books
2. Issue Book
3. Return Book
4. Exit
Enter choice: 1
1 - Java Basics by James Gosling [Available]
2 - OOP Concepts by Bjarne Stroustrup [Available]

Enter choice: 2

Enter Book ID: 1

Enter User ID: 1

Ram issued Java Basics

Enter choice: 3

Enter Book ID: 1

Enter User ID: 1

Ram returned Java Basics

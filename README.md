# Library Management System

## Overview
This is a console-based Library Management System implemented in Java using an object-oriented, modular architecture. The system supports both Administrator and Borrower roles, with authentication and role-based menus.

## Features

### Authentication
- Login for Admin and Borrower using email and password
- Role-based menu and access

### Book Inventory Management (Admin)
- Add, modify, and delete books
- View all books (sorted by name or quantity)
- Search books by name or ISBN
- Manage borrowers and their fine limits

### Borrowing Books (Borrower)
- View available books
- Borrow books (max 3 at a time, not the same book twice)
- Security deposit check
- Add/remove books from checkout cart

### Fine and Regulations
- Initial deposit of Rs. 1500
- Fine for late return, book loss, or card loss
- Tenure extension (max 2 times per book)
- Fine can be paid by cash or deducted from deposit

### Reports
- Admin: Books with low quantity, unborrowed books, heavily borrowed books, students with outstanding books, book status by ISBN
- Borrower: View previous fines and borrowed books

## Project Structure

```
LibManagement/
├── main/
│   └── Main.java
├── auth/
│   ├── AuthService.java
│   └── User.java
├── inventory/
│   ├── Book.java
│   └── InventoryService.java
├── borrow/
│   └── BorrowService.java
├── fines/
│   └── FineServices.java
├── reports/
│   └── ReportServices.java
└── Readme.MD
```

## How to Run
1. Compile all Java files in their respective package folders.
2. Run `main.Main` as the entry point.
3. Follow the console prompts to log in and use the system.

## Requirements
- Java 8 or above
- Console/terminal access

## Notes
- All data is stored in-memory (no database).
- Extend functionality by adding more modules or features as needed.

## Author
Created by GIRIDHARAN

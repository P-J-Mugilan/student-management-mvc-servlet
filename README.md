# student-management-mvc-servlet
A Java web application built using MVC architecture with Servlets and JSP. Supports multi-admin login with isolated student record management (CRUD). Includes a DBService interface layer for clean data access.



# 🎓 Student Management System (Java MVC Project)

A mini Java web application built using **MVC architecture** (Model-View-Controller) with **Servlets**, **JSP**, and **JDBC**. The system allows multiple admins to manage student records securely and privately. Each admin has isolated access to their own student records.

---

## 🧱 Architecture

### 📁 Model (`model`)
- `DBService`: Interface defining all database operations.
- `DBServiceClass`: Implements `DBService`. Handles database interactions like student CRUD and admin validation.

### 📁 Controller (`controller`)
- `AdminLoginController`: Handles admin authentication and session start.
- `StudentRegisterController`: Handles student registration.
- `UpdateStudentRecordController`: Updates existing student data.
- `DeleteStudentRecordController`: Deletes a student record.
- `ReadStudentRecordController`: Displays student records for the logged-in admin.
- `LogoutController`: Ends the admin session and redirects to login.

### 📁 View (`views` - JSP files)
- `index.jsp`: Starting page (login page).
- `registerUser.jsp`: Form for student registration.
- `updateStudentRegistration.jsp`: Student update form.
- `listRegisteredUser.jsp`: Displays students registered by the logged-in admin.
- `menu.jsp`: Shared navigation for logged-in admins.

---

## ✨ Features

- 🔐 Admin login/logout
- ➕ Register new students
- ✏️ Update student records
- ❌ Delete student records
- 👁️ View all students registered by the logged-in admin
- 🚫 Access isolation — each admin sees only their records
- 🧪 Uses an interface-based service layer (`DBService`) for clean architecture

---

## ⚙️ Technologies Used

- Java (Servlets + JSP)
- JDBC (MySQL)
- Apache Tomcat (Server)
- HTML/CSS
- MVC Design Pattern

---

## 🧩 Database Design

create table admin_user(
	admin_id int primary key,
    admin_username varchar(45),
    admin_name varchar(45),
    admin_email varchar(45),
    admin_password varchar(20)
);


create table student_user(
	student_id int auto_increment primary key,
    student_name varchar(45),
    student_course varchar(145),
    student_email varchar(45),
    student_mobile varchar(10),
    admin_id int
);


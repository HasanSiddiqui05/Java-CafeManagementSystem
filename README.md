# ☕ Café Management System

A Java-based desktop application developed as an Object-Oriented Programming project

---


## 📖 Overview

The Café Management System is a comprehensive desktop application designed to streamline café operations and enhance customer experiences. It provides café owners with a user-friendly GUI to efficiently handle day-to-day tasks including order management, inventory control, staff management, billing, and sales analysis.

---

## 🧩 OOP Concepts Used

- **Classes** — Modular design with dedicated classes for each feature
- **Interfaces** — Java interfaces for defining contracts between components
- **Inheritance** — Shared behaviour across related classes
- **Polymorphism** — Dynamic method dispatch for flexible functionality

---

## ✨ Features

- **Login & Registration** — Secure user authentication with credential validation
- **Menu Management** — Add, update, delete, and search food items
- **Order Management** — Place and track customer orders
- **Billing** — Generate bills and manage cash/balance calculations
- **Staff Management** — Manage staff profiles including position, contact, section, and NIC
- **Sales Analysis** — View total sales records with search and aggregation

---

## 🗂️ Project Structure

| Class | Description |
|-------|-------------|
| `login` | Handles user authentication against the database |
| `registerform` | Registers new users into the system |
| `afterlog` | Main dashboard displayed after successful login |
| `food` | Manages the café menu (CRUD operations on food items) |
| `staff` | Manages staff records (CRUD operations) |
| `order` | Handles customer order processing |
| `bill` | Generates and manages customer bills |
| `totalsales` | Displays all sales records with total revenue calculation |
| `dbconnect` | Handles database connection |

---

## 🛠️ Tech Stack

- **Language:** Java
- **GUI Framework:** Java Swing (`javax.swing`)
- **Database:** SQL (via JDBC — `java.sql`)
- **IDE:** NetBeans (inferred from `initComponents()` pattern)
- **Library:** `DbUtils` for converting `ResultSet` to Swing `TableModel`

---

## ⚙️ Setup & Installation

1. **Clone or download** the project repository.
2. **Set up the database** and create the following tables:
   - `regis` — stores user registration data
   - `foods` — stores menu items (name, type, price, ID)
   - `roles` — stores staff records (name, position, phone, section, address, age, NIC)
   - `allsale` — stores all completed sales records
3. **Configure the database connection** in the `dbconnect` class with your DB credentials.
4. **Add the required library** — include the `DbUtils` JAR (RS2XML) in your project's classpath.
5. **Build and run** the project from your IDE (NetBeans recommended).

---

## 🚀 Usage

1. Launch the application — the **Login** screen appears.
2. Register a new account via the **Register** form.
3. Log in to access the **Main Dashboard**.
4. Navigate to any module:
   - **Staff** — manage employee records
   - **Menu (Food)** — manage food items
   - **Orders** — place customer orders
   - **Billing** — generate bills
   - **Total Sales** — view sales history and revenue


# ✈️ Plane Management System

A console-based Java application designed to manage passenger seating in a plane. Built entirely using **Core Java**, this system supports booking, updating, and canceling tickets, while also demonstrating key programming concepts like **OOP**, **arrays**, **file handling**, and **basic sorting algorithms**.

This project is ideal for students and beginners who want to strengthen their Java programming skills through hands-on learning.

---

## 💡 Features

- ✅ View all available and occupied seats
- 🎟️ Book a seat by entering passenger details
- ❌ Cancel a booking and free up the seat
- 🔄 Update passenger information
- 🧾 Delete passenger record
- 🔍 Search for a passenger by name or seat number
- 📋 Display sorted list of booking tickets (using Bubble Sort)
- 💾 Save and load passenger data from a file
- 🖥️ Simple and intuitive command-line interface

---

## 🔧 Tech Stack

- **Language:** Java (Core Java)
- **Environment:** Console-based
- **Tools:** IntelliJ IDEA (or any Java IDE)

---

## 🧾 Sample Console Menu

```text
-----------------------------
 Plane Management System
-----------------------------
(1). View all seats
(2). Book a seat
(3). Cancel a seat
(4). Update passenger details
(5). Delete passenger record
(6). Search by name or seat
(7). Sort tickets by name or price
(8). Save data to file
(9). Load data from file
(10). Exit
-----------------------------
Select an option:


Project Structure
PlaneManagement.java — Main driver class

Passenger.java — Represents a passenger with name, email, etc.

Seat.java — Handles individual seat data (seat number, status, passenger info)

FileHandler.java — Utility class for saving and loading data

How to Run

Clone the repository:

bash
git clone https://github.com/your-username/plane-management-system.git

Compile and run:
cd plane-management-system
javac PlaneManagement.java
java PlaneManagement

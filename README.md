# 🎚️ Slider Application

A secure, multi-platform learning project designed for Algonquin College students to explore RESTful APIs, authorization, and role-based access control (RBAC) using a variety of front-end and back-end technologies.

---

## 📚 Project Overview

The **Slider Application** is an educational full-stack project developed to demonstrate:

- Secure RESTful API creation and integration  
- JSF endpoint protection with role-based authorization  
- Multi-role access control:
  - **Admin**: Full access to RESTful and JSF endpoints + Admin Dashboard  
  - **JSF User**: Access only to JSF endpoints  
  - **RESTful User**: Access only to RESTful endpoints  

The project is modular and includes:

- A Java-based backend developed in NetBeans  
- A React.js front-end with Canvas integration  
- A Java Swing desktop GUI client  
- A Kotlin-based Android mobile application  
- Automated testing using Selenium and JUnit  

---

## 🛡️ Security Features

- REST and JSF endpoints protected using authorization filters  
- Users authenticated and routed based on their roles  
- Secure session handling implemented across web and mobile interfaces  

---

## 🖥️ Technology Stack

| Layer      | Technologies Used                                      |
|------------|--------------------------------------------------------|
| Backend    | Java (NetBeans project), REST API, JSF (JavaServer Faces) |
| Frontend   | React.js, Canvas API                                   |
| Mobile     | Android (Kotlin)                                       |
| Desktop    | Java Swing                                             |
| Testing    | Selenium (UI), JUnit (Unit + Auth Tests)               |

---

## 🚀 How to Run

### Backend (Java + REST + JSF)
1. Open the `Backend` project in NetBeans  
2. Build and deploy the application  
3. Configure users and roles in `web.xml` or security config  
4. Access endpoints via browser or Postman  

###  Desktop Client

- Open DesktopApp in any Java IDE

- Run Main.java

### Android App

- Open Mobile App/Slider in Android Studio

- Sync Gradle and run on emulator or real device

### ✅ Testing

- JUnit: Located in /Tests/JUnit, includes unit tests and role-based authentication tests

- Selenium: Located in /Tests/Selenium, simulates user interactions and login scenarios

### 🎯 Learning Objectives

- Understand how RESTful services are built and secured

- Implement role-based access control in Java web applications

- Integrate frontend and backend using secure APIs

- Develop and test full-stack, multi-platform applications

- Explore cross-platform design with Java, Kotlin, React, and Swing

### 👥 Contributors

- This project was developed by students of Algonquin College as part of a practical learning initiative in secure web and mobile application development.

### 📄 License

- This project is for educational purposes only. Licensing for reuse or commercial adaptation is not granted.
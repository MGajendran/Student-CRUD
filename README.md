# Student-CRUD

This is a simple Java application for managing student records. It allows you to perform basic CRUD operations (Create, Read, Update, Delete) on student information.

* Create Student Records: Add new students to the system by providing their name, age, and enrollment date.

* Read Student Records: View a list of all students and their details.

* Update Student Records: Edit existing student information, including their name, age, and enrollment date.

* Delete Student Records: Remove students from the system.

## Technology Used ##

* Java
* Spring Boot
* Postgres SQL - DB

Follow these instructions to set up and run the Student CRUD application on your local machine.

# Prerequisites

* Java Development Kit (JDK): Ensure you have the JDK installed on your computer.
* Database: Set up the PostgreSQL and create a database for this application, name the database as **student**.

# Installation

* Download or clone the repository.
* Download Postgres SQL and PgAdmin 4 for managing the admin related DB activities.
* Once the PgAdmin is downloaded, create a database with **student** name.
* Navigate to project directory.
* Run the maven
* Compile the Java code and start the application by clicking on the start button.
* Once the application is running. You can use POSTMAN or curl commands to call the API to perform the crud operation.

# usage

1. Create a Student:
    Provide the student firstName, lastName, age, and subjects.
     ```
         {
            "firstName" : "",
            "lastName" : "",
            "age" : ,
            "subjects" : []
        }
     ```
    Save the student's information.
   
3. Read Student Records:

   View a list of all students and their details.
   
   View a student information by passing his id. 
   
5. Update Student Records:
   
    Edit the student information (firstName, lastName, age, and subjects).
   
    Save the changes.


7. Delete Student Records:
   
    Select the student to be removed and pass the id to the API.


  

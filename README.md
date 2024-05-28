# commercial-solutions-web-application 

## Project Summary

### Introduction
A Spring Boot web application utilizing the MVC architecture to manage hospital data.

<img src="https://github.com/FranklinArruda/ca2/assets/102427836/a9cb57de-21cd-4a2d-8acf-f9ea132e6dc6" alt="Screenshot_1" width="600" height="300"/>

### Architecture Overview
- **Thymeleaf Templates:** Render the user interface and bind form validation to Java objects.
- **Spring Controllers:** Handle HTTP requests, form submissions, and page responses.
- **Service Layer:** Contain business logic for data processing.
- **Repository Layer:** Manage data persistence with JPA repositories.
- **Entities:** Represent the database structure.

### Key Components
- **Thymeleaf Template (`addHospitalData.html`):** Renders forms for hospital data input, binding to the `HospitalData` Java object.
- **Spring Controller (`HospitalDataController`):** Manages form display and processing with `@GetMapping("/addData")` and `@PostMapping("/add")`.

### Challenges and Solutions
- **Form Binding:** Preventing binding errors by correctly handling form requests and rendering in the controller.
- **Controller Authorization:** Ensuring all request mappings are authorized for processing.
- **CRUD Operations:** Designing data models and understanding controller-service-repository interactions.
- **Entity Relationships:** Managing entity relationships and resolving naming conflicts with Spring JPA configurations.
- **Validation Errors:** Handling user-friendly validation errors with Jakarta and Lombok dependencies.

### Conclusion
Successfully implemented a web application to manage hospital data with Thymeleaf templates using Vritual Box machine on Ubuntu Operating System, ensuring a robust and interactive user experience. Developed using Visual Studio Code and followed best practices for backend and frontend integration.



## How to use the Application

1. **MySQL Using Virtual-Box Machine**

   - In order for you to connect to your MySQL in your Virtual-Box Machine on Ubuntu linux. You must have the following configuration set in your Spring boot "application.properties". The IP Address correspond to my local IP when connected to my Virtual Machine and the CA2 is my database name in MYSQL. Username is the "hduser" from my virtual box followed with the password as the EXEMPLE Below:

     ```javascript
      # application.properties:
     
      spring.datasource.url=jdbc:mysql://192.168.56.102:3306/CA2
      spring.datasource.username=hduser
      spring.datasource.password=password
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
     ```


2. **MySQL On your Local Machine (WorkBench)**

   - As for the workbench you simply use a similar approach, but without the IP Address as follows: 

     ```javascript
      # application.properties:
     
      spring.datasource.url=jdbc:mysql://localhost:3306/mydb
      spring.datasource.username=root
      spring.datasource.password=0000
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=none
      spring.jpa.hibernate.ddl-auto=update
     ```



## Demo Video 
`RUNNING THE APPLICATION:`

https://github.com/FranklinArruda/ca2/assets/102427836/c682b186-28bf-4228-bc3e-e723a7f01239



     

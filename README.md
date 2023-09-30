# authenticatordemo
Authenticator Backend in Springboot

Java application code for Java17, Spring Boot 3+, Spring Data JPA, Spring Security, Spring Web, and OAuth2Resource server application.

MySQL is used for database.

Application follows a MVC structure, with a controller, service and model. Users are authenticated using a customer UserDetailsService and AuthenticationManager provided by Spring Security Framework.

Database is automatically populated when application is run with 2 users of 2 different roles.

When login is successful, a JWT is generated and sent to the API caller. This JWT can be set as bearer token on the frontend to access authenticated routes that are permitted
according to user's role.

# To start
1. Change username and password to that of your MySQL database in `applications.properties`
2. Change port number to that of your MySQL database in `applications.properties`
3. Create a schema in your local MySQL of the name `demo`

You are now ready to run the SpringBoot application!

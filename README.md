Order Management Microservice – Java Microservices Coding Test

Application Name: OrderManagementApplication

Approach:
I created a simple Spring Boot microservice using controller, service, and model layers.
Orders are stored in memory using a collection, and REST APIs are implemented with basic validation and exception handling.
Order status flow (NEW → PROCESSING → COMPLETED) is handled in the service layer.

Features Implemented:
- Create Order – POST /orders
- Get Order by ID – GET /orders/{id}
- Update Order Status – PUT /orders/{id}/status
- List All Orders – GET /orders
- Validation for required fields
- Exception handling (400, 404)
- Status transition validation
- Lombok used for boilerplate code

Note:
Only the src folder is shared in this submission.
The complete project with pom.xml is available in the GitHub repository.

Required Dependencies:
- spring-boot-starter-web
- spring-boot-starter-validation
- lombok

How to Run:
1. Create a Spring Boot project (Java 8+)
2. Add required dependencies
3. Copy the provided src folder into the project
4. Enable Lombok in IDE
5. Run OrderManagementApplication.java

Postman collection is attached for API testing.

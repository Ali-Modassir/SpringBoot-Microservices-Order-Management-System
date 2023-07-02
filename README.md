# Order Management System

This is a detailed guide on setting up and using the Order Management System. The system is built using Spring Boot microservices and consists of three microservices: Order Service, Product Service, and Inventory Service. The Product Service uses MongoDB as a database, the Inventory Service uses MySQL, and the Order Service uses MySQL as well. The system also includes an API Gateway for authorization and authentication using Keycloak and utilizes Netflix Eureka as a discovery server.

## Build With

<div>
  <img src="https://www.vectorlogo.zone/logos/springio/springio-ar21.svg">
  <img src="https://www.vectorlogo.zone/logos/mysql/mysql-ar21.svg">
  <img src="https://www.vectorlogo.zone/logos/mongodb/mongodb-ar21.svg">
</div>

## Microservices Overview

![Microservices overview](https://github-production-user-asset-6210df.s3.amazonaws.com/56336283/250305353-34677dd3-74b4-4cff-942e-414e0504efa3.png)

### Product Service

The Product Service handles the management of products. It utilizes MongoDB as its database.

#####  API Endpoints:

- `POST /api/products` :  Creates a new product.
- `GET /api/products` : Fetches all products.

Example Request - Create Product:

```sh
curl -X POST -H "Content-Type: application/json" -d '{"name": "Product 1", "price": 10.99}' http://localhost:8081/api/products
```
Example Request - Fetch All Products:

```sh
curl http://localhost:8081/api/products
```
### Order Service

The Order Service is responsible for managing orders. It interacts with the Inventory Service to check the availability of products before placing an order. The Order Service uses MySQL as its database.

#####  API Endpoints:

- `POST /api/orders`: Creates a new order.

Example Request:

```sh
curl -X POST -H "Content-Type: application/json" -d '{"productId": "123", "quantity": 2}' http://localhost:8080/api/orders
```

### Inventory Service

The Inventory Service manages the inventory of products. It communicates with the Product Service to retrieve product information and uses MySQL as its database

#####  API Endpoints:

- `GET /api/inventory/{productId}` : Retrieves the stock size of a particular product.

Example Request:

```sh
curl http://localhost:8082/api/inventory/123
```

## System Architecture

The system is designed using a microservices architecture pattern, where each microservice is responsible for a specific domain. The microservices communicate with each other using synchronous service-to-service calls.

### Database Setup

-   The Product Service uses MongoDB as its database. Make sure to set up and configure MongoDB accordingly.
-   Both the Inventory Service and Order Service use MySQL as their databases. Set up MySQL databases for these services and configure the connection details in their respective configuration files.

### API Gateway Setup

-   An API Gateway is used to handle client requests and provide authentication and authorization. Keycloak is integrated with the API Gateway for this purpose.
-   Set up Keycloak and configure the API Gateway to use Keycloak for authentication and authorization.

### Service Discovery

-   Netflix Eureka is used as the service discovery server. It enables each microservice to register itself with Eureka, which allows other services to discover and communicate with it.
-   Set up and configure Netflix Eureka for service discovery.

## Installation and Setup

1.  Clone the repository to your local machine:
	```sh
	 git clone https://github.com/Ali-Modassir/SpringBoot-Microservices.git
    ```
2.  Set up and configure MongoDB for the Product Service. Refer to the MongoDB documentation for installation instructions.
    
3.  Set up and configure MySQL for the Inventory Service and Order Service. Refer to the MySQL documentation for installation instructions.
    
4.  Configure the database connection details for each microservice:
    
    -   Product Service: Update the `application.properties` file with the MongoDB connection details.
    -   Inventory Service: Update the `application.properties` file with the MySQL connection details.
    -   Order Service: Update the `application.properties` file with the MySQL connection details.
5.  Set up and configure Keycloak for authentication and authorization. Refer to the Keycloak documentation for installation instructions.
    
6.  Configure the API Gateway to use Keycloak for authentication and authorization. Update the configuration files to integrate Keycloak with the API Gateway.
    
7.  Set up and configure Netflix Eureka for service discovery. Update the configuration files of each microservice to register with Eureka.
    
8.  Build and run each microservice:
    
    -   **Product Service**:
	    ```sh
		cd product-service
		./mvnw spring-boot:run
	    ```
	    
	 - **Inventory Service**:
	    ```sh
		cd inventory-service
		./mvnw spring-boot:run
	    ```

	- **Order Service**:
	    ```sh
		cd order-service
		./mvnw spring-boot:run
	    ```



9.  Test the system by accessing the APIs through the API Gateway.



## Contributing

Contributions are welcome! If you have any ideas, suggestions, or bug fixes, please submit a pull request. When contributing, please ensure that your changes are well-documented and adhere to the coding standards of the project. If you're unsure about any aspect of the system or the contribution process, feel free to open an issue for discussion.

## Troubleshooting

If you encounter any issues while setting up or running the Order Management System, here are a few troubleshooting steps you can follow:

1.  **Check the Documentation**: Review the README and documentation files for each microservice to ensure you have followed all the necessary setup steps and configurations.
    
2.  **Search for Existing Issues**: Browse through the project's issue tracker on GitHub to see if someone has reported a similar problem or if there are any known workarounds or solutions.
    
3.  **Open a New Issue**: If you're unable to find a solution, open a new issue on the project's GitHub repository. Provide detailed information about the problem, including any error messages, relevant configurations, and steps to reproduce the issue.
    
4.  **Seek Help**: If you're still unable to resolve the problem, consider seeking help from the project's community. This can be done through forums, discussion boards, or other communication channels associated with the project.
    

Remember to be patient and provide as much information as possible when seeking assistance. This will help others understand and troubleshoot the issue more effectively.   

## Conclusion

The Order Management System is a set of microservices built using Spring Boot. It includes three microservices: Order Service, Product Service, and Inventory Service, each using a different database. The system incorporates an API Gateway for authentication and authorization with Keycloak and utilizes Netflix Eureka for service discovery. By following the provided installation and setup instructions, you can run the system locally.

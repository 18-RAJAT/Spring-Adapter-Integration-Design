# Adapter Design Pattern with Spring Boot  

## Overview

This repository demonstrates the Adapter Design Pattern in a Spring Boot application, using a real-world e-commerce example. It simplifies the integration of multiple payment gateways (Stripe, PayPal, Razorpay, Google Pay) through a central adapter, improving code maintainability and scalability.


---
![D1](https://github.com/user-attachments/assets/8b5195b5-0109-450d-a3fd-1633f8aa2a89)

---
## Key Features  
- **Unified Integration**: One adapter to interact with multiple payment gateways.  
- **Scalability**: Easily add new payment providers without altering the existing code.  
- **Maintainability**: Centralized logic reduces redundant code and improves manageability.  
- **Real-World Use Case**: Demonstrated in the context of an e-commerce platform.  

---

## Technologies Used  
- **Java**  
- **Spring Boot**  
- **Maven**  
- **REST APIs**  

---

## Design Pattern: Adapter  
The Adapter Design Pattern acts as a bridge between incompatible interfaces, enabling the application to communicate seamlessly with different payment gateways.  

### Problem:  
Each payment gateway has its own API, leading to scattered and hard-to-maintain code.  

### Solution:  
Introduce a **Unified Payment Adapter** that encapsulates the complexity of interacting with each gateway.  

---
![D2](https://github.com/user-attachments/assets/d570dc9c-3977-4211-9a4e-d28e1d6cc6d2)


---

# Clone the repository, build the project, and run the application:
```bash
git clone https://github.com/18-RAJAT/Spring-Adapter-Integration-Design.git
```
```bash
cd Spring-Adapter-Integration-Design
```
```bash
mvn clean install
```
```bash
mvn spring-boot:run
```

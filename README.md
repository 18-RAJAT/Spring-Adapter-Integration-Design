# Adapter Design Pattern with Spring Boot

## Overview
This project demonstrates the **Adapter Design Pattern** using a Spring Boot application. The example focuses on integrating multiple payment gateways (e.g., PayPal, Stripe, Razorpay, Google Pay) through a unified adapter, making the application more maintainable, scalable, and adaptable to future changes.

## Key Features
- **Unified Integration**: A single adapter interface to interact with multiple payment gateways
- **Scalability**: Easily add new payment gateways without modifying the core business logic
- **Maintainability**: Centralized logic reduces redundancy and improves code organization
- **Real-World Example**: Suitable for e-commerce platforms handling diverse payment options

---
![D1](https://github.com/user-attachments/assets/8b5195b5-0109-450d-a3fd-1633f8aa2a89)
---

## Technologies Used
- **Java**
- **Spring Boot**
- **Maven**
- **REST APIs**

## Design Pattern: Adapter

### Problem
Each payment gateway provides its own API, resulting in scattered, repetitive, and hard-to-maintain integration code.

### Solution
The **Adapter Design Pattern** bridges these differences by providing a unified interface for all payment gateways, allowing the application to communicate seamlessly with them.

### How It Works
1. **Adapter Interface**: Defines the contract for all payment gateways
2. **Concrete Adapters**: Implement the interface and encapsulate the logic specific to each gateway
3. **Payment Service**: Calls the appropriate adapter based on the gateway specified by the client

---
![D2](https://github.com/user-attachments/assets/d570dc9c-3977-4211-9a4e-d28e1d6cc6d2)
---
## API Documentation

### Endpoints

1. **Process Payment**
   - **URL**: `/api/v1/payment/process`
   - **Method**: `POST`
   - **Headers**:
     ```
     Content-Type: application/json
     ```
   - **Request Body (JSON)**:
     ```json
     {
         "amount": 100.50,
         "gateway": "paypal"
     }
     ```
   - **Response (JSON)**:
     ```json
     {
         "success": true,
         "transactionId": 1234567890
     }
     ```

2. **Supported Gateways**:
   - `paypal`
   - `stripe`
   - `gpay`

## Example Workflow

1. **Client Request**  
   The client specifies the `amount` and `gateway` in the JSON request.

2. **Adapter Selection**  
   The `PaymentService` dynamically selects the appropriate adapter based on the `gateway`.

3. **Payment Processing**  
   The selected adapter processes the payment and returns a success response along with a transaction ID.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/18-RAJAT/Spring-Adapter-Integration-Design.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Spring-Adapter-Integration-Design
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Sample Test Cases

### PayPal Payment
**Request:**
```json
{
    "amount": 150.75,
    "gateway": "paypal"
}
```

**Response:**
```json
{
    "success": true,
    "transactionId": 1234567890
}
```

### Stripe Payment
**Request:**
```json
{
    "amount": 99.99,
    "gateway": "stripe"
}
```

**Response:**
```json
{
    "success": true,
    "transactionId": 987654321
}
```

### Unsupported Gateway
**Request:**
```json
{
    "amount": 200.00,
    "gateway": "unknown"
}
```

**Response:**
```json
{
    "timestamp": "2024-12-13T17:00:00.123+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Unsupported payment gateway: unknown",
    "path": "/api/v1/payment/process"
}
```

## Future Enhancements

### Add More Gateways
- Integrate more payment providers like Razorpay or Square

### Error Handling
- Improve error messages and add logging for failed transactions

### Security Enhancements
- Use secure tokens or API keys for communication with payment gateways

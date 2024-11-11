# Product API

The `Product API` service manages product-related operations such as adding, retrieving, and updating product details. It is part of the organization's microservices architecture.

## Overview

The `Product API` provides functionality for:
- Adding new products.
- Retrieving product details by ID, code, or a list of IDs.
- Updating product information.

## Endpoints

### Add Product

- **URL**: `/product`
- **Method**: `POST`
- **Description**: Adds a new product.
- **Request Body**: 
  ```json
  {
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response**: 
  ```json
  {
    "id": "long",
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response Code**: `201 Created`

---

### Get Product by ID

- **URL**: `/product/{id}`
- **Method**: `GET`
- **Description**: Retrieves a product by its ID.
- **Path Variable**: `id` (Long)
- **Response**: 
  ```json
  {
    "id": "long",
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response Code**: `200 OK`

---

### Get Product by Code

- **URL**: `/product?code={code}`
- **Method**: `GET`
- **Description**: Retrieves a product by its unique code.
- **Request Param**: `code` (String)
- **Response**: 
  ```json
  {
    "id": "long",
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response Code**: `200 OK`

---

### Get Products by List of IDs

- **URL**: `/product?ids={ids}`
- **Method**: `GET`
- **Description**: Retrieves a list of products by their IDs.
- **Request Param**: `ids` (Set of Longs)
- **Response**: 
  ```json
  [
    {
      "id": "long",
      "code": "string",
      "name": "string",
      "description": "string",
      "price": "number",
      "image": "string"
    }
  ]
  ```
- **Response Code**: `200 OK`

---

### Get All Products

- **URL**: `/product`
- **Method**: `GET`
- **Description**: Retrieves a list of all products.
- **Response**: 
  ```json
  [
    {
      "id": "long",
      "code": "string",
      "name": "string",
      "description": "string",
      "price": "number",
      "image": "string"
    }
  ]
  ```
- **Response Code**: `200 OK`

---

### Update Product

- **URL**: `/product/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing product by ID.
- **Path Variable**: `id` (Long)
- **Request Body**: 
  ```json
  {
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response**: 
  ```json
  {
    "id": "long",
    "code": "string",
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "string"
  }
  ```
- **Response Code**: `200 OK`

---

## Configuration

- Configure the database connection in the `application.properties` file:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
  spring.datasource.username=your_db_username
  spring.datasource.password=your_db_password
  ```

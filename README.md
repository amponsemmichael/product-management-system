# Product Management System

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Product Management System is a web application designed to manage products within an inventory. It supports CRUD operations (Create, Read, Update, Delete) and includes features like pagination and search functionality by product name or category.

## Requirements

### Functional Requirements

1. **Product Management**
   - Users can add new products.
   - Users can view a list of products.
   - Users can update existing products.
   - Users can delete products.
   - Users can view details of a product.

2. **Search and Filter**
   - Users can search for products by name.
   - Users can search for products by category.

3. **Pagination**
   - Products should be displayed with pagination, showing 10 products per page.
   - Users can navigate between pages using "Next" and "Previous" buttons.

4. **Product Details**
   - Users can view detailed information about a specific product.

### Non-Functional Requirements

1. **Performance**
   - The system should handle requests efficiently and respond within a reasonable time frame.

2. **Usability**
   - The user interface should be intuitive and easy to use.

3. **Reliability**
   - The system should be robust and handle errors gracefully.

4. **Maintainability**
   - The codebase should be well-documented and follow best practices to facilitate maintenance and future enhancements.

## Features

- **Add Product:** Add new products to the inventory.
- **View Products:** Display a list of products with pagination.
- **Update Product:** Edit product details.
- **Delete Product:** Remove products from the inventory.
- **Search Products:** Search for products by name or category.
- **View Product Details:** Display detailed information for a specific product.

## Technologies

- **Frontend:**
  - React
  - Axios
  - React Router
  - Tailwind CSS
  - React Icons

- **Backend:**
  - Spring Boot
  - MongoDB
  - Spring Data MongoDB

## Installation

### Prerequisites

- Node.js and npm
- Java JDK 11+
- MongoDB

### Backend Setup

1. Clone the repository:

    ```sh
    git clone https://github.com/your-username/product-management-system.git
    cd product-management-system
    ```

2. Navigate to the backend directory:

    ```sh
    cd backend
    ```

3. Install dependencies and run the backend server:

    ```sh
    ./mvnw spring-boot:run
    ```

### Frontend Setup

1. Navigate to the frontend directory:

    ```sh
    cd frontend
    ```

2. Install dependencies and start the frontend server:

    ```sh
    npm install
    npm start
    ```

## API Endpoints

### Product Endpoints

- **GET /products:** Retrieve a paginated list of products
- **GET /products/{id}:** Retrieve a specific product by ID
- **POST /products:** Add a new product
- **PUT /products/{id}:** Update an existing product by ID
- **DELETE /products/{id}:** Delete a product by ID
- **GET /products/search:** Search for products by name or category (query parameter: `search`)

## Usage

### Adding a Product

1. Navigate to the "Add Product" page.
2. Fill in the product details.
3. Click "Save" to add the product to the inventory.

### Viewing Products

1. Products are displayed on the home page with pagination.
2. Use the "Next" and "Previous" buttons to navigate through pages.

### Searching for Products

1. Use the search box to enter a product name or category.
2. The list of products will be updated based on the search criteria.

### Viewing Product Details

1. Click on the info icon next to a product to view detailed information.

### Updating a Product

1. Click on the edit icon next to a product to navigate to the "Edit Product" page.
2. Update the product details and click "Save" to apply the changes.

### Deleting a Product

1. Click on the delete icon next to a product to remove it from the inventory.

## Contributing

Contributions are welcome! Please read the [contributing guidelines](CONTRIBUTING.md) before submitting a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

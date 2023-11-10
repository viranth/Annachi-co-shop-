# Grocery Store Management System

## Introduction

This Java program simulates a grocery store management system with stock items and a shopping cart. It provides functionality for adding, updating, and viewing stock items, as well as managing a shopping cart with items, quantities, and bills.

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)
4. [Usage](#usage)
5. [Classes](#classes)

## Prerequisites
- Java Development Kit (JDK) 1.8 or higher
- An Integrated Development Environment (IDE) or a command-line Java compiler

## Getting Started

Follow these steps to get started with the Grocery Store Management System:

### Installation

1. Clone or download this repository to your local machine using your preferred method (e.g., `git clone` or the "Download ZIP" option).

2. Open the project in your chosen Java development environment (IDE).

### Running the Program

3. Compile and run the `Main` class within your IDE to start the grocery store management program. Alternatively, you can compile and run the program from the command line using standard Java commands.

4. Follow the menu-driven interface to manage stock items, shopping cart operations, and generate bills for customer purchases.

You are now ready to use the Grocery Store Management System to effectively manage your grocery store's inventory and customer shopping experience.

## Usage
The program provides a menu-driven interface for managing stock items and shopping cart operations. It includes the following features:

### Stock Item Management
- Add new stock items.
- Update existing stock item prices and quantities.
- View the list of available stock items.
- Search for stock items by name or ID.

### Shopping Cart Management
- Add items to the shopping cart by specifying the item ID and quantity.
- Increment or decrement the quantity of items in the cart.
- View the contents of the shopping cart.
- Calculate the total cost of items in the cart.
- Generate and print a bill for the items in the cart.

### Main Class
The `Main` class serves as the entry point for the program and provides a menu for navigating between stock item and shopping cart management.

## Classes
1. `Item` - Represents a stock item with attributes such as name, price, and quantity.
2. `ItemManager` - Manages the stock of items, allowing you to add, update, search for, and view items.
3. `Cart` - Represents an item in the shopping cart, including name, quantity, unit price, and total price.
4. `CartManager` - Manages the shopping cart, enabling users to add, remove, view, manipulate items, and print bills.
5. `Main` - The main program class that initializes the system, creates instances of `ItemManager` and `CartManager`, and provides a menu-driven interface.


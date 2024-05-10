## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


//Main.java

Class Declaration:

Declares a class named "Main" in the package net.javaguides.pfm.
Static Scanner Object:

Creates a static Scanner object to read input from the console.
Main Method:

Acts as the entry point of the application.
Creates an instance of FinanceManager to manage financial transactions.
Displays a menu and processes user input in a loop until the user chooses to exit.
Menu Handling:

Displays options for adding, editing, deleting transactions, listing transactions, summarizing transactions, and exiting the application.
Reads the user's choice and executes the corresponding action using a switch-case statement.
Option Handling Methods:

addTransactionUI(FinanceManager manager):

Prompts the user to enter transaction details (type, amount, description).
Creates a new Transaction object with the input data and adds it using the FinanceManager instance.



editTransactionUI(FinanceManager manager):

Prompts the user to enter the ID of the transaction to edit and new details (type, amount, description).
Updates the specified transaction using the FinanceManager instance.


deleteTransactionUI(FinanceManager manager):

Prompts the user to enter the ID of the transaction to delete.
Removes the specified transaction using the FinanceManager instance.


Input Handling:

Catches InputMismatchException to handle invalid input gracefully.
Consumes any remaining newline characters to prevent input issues.


Exiting the Application:

Provides an option to exit the application, displaying a message before terminating the program.


//Transaction.java

Purpose:
The Transaction class is designed to encapsulate information about individual financial transactions, such as their type (Income/Expense), amount, and description.


Attributes:
id: An integer representing the unique identifier of the transaction.
type: A string indicating the type of transaction (e.g., "Income" or "Expense").
amount: A double value representing the amount of the transaction.


description: A string providing additional information or a description of the transaction.
Constructors:
The class typically provides one or more constructors to initialize its attributes. These constructors allow instances of Transaction to be created with specific values for each attribute.


Accessor and Mutator Methods:
Accessor methods (getters) allow other classes to retrieve the values of the transaction's attributes.
Mutator methods (setters) enable other classes to modify the values of the transaction's attributes.

Serializable Interface:
The Transaction class might implement the Serializable interface to allow instances of the class to be serialized and deserialized. This enables instances to be easily saved to files or transmitted over networks.

toString Method:
The class typically overrides the toString() method inherited from the Object class. This method returns a string representation of the transaction, often including its ID, type, amount, and description.

///Financemanager.java

Constructor (FinanceManager()):

Initializes a new instance of the FinanceManager class by calling the loadTransactions() method to load any existing transactions from a file.
Method: addTransaction(Transaction transaction):

Adds a new transaction to the list of transactions and saves the updated list to the file.
Method: editTransaction(int id, String type, double amount, String description):

Modifies an existing transaction by searching for the transaction with the specified ID and updating its type, amount, and description. It then saves the changes to the file.
Method: deleteTransaction(int id):

Removes a transaction from the list based on the provided ID and saves the updated list to the file.
Method: listTransactions():

Prints out each transaction in the list to the console.
Method: saveTransactions():

Writes the list of transactions to a file using ObjectOutputStream to serialize the data.
Method: loadTransactions():

Reads the list of transactions from a file using ObjectInputStream to deserialize the data. Handles cases where the file is not found or errors occur during loading.
Method: summarizeTransactions():

Calculates the total income, total expenses, and net flow by filtering transactions based on their type (Income or Expense) and summing up the amounts. It then prints out these values to the console.
Method: getNextId():

Returns the next available ID for a new transaction. If the list is empty, it returns 1; otherwise, it increments the ID of the last transaction in the list.
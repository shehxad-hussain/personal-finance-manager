package net.javaguides.pfm;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();

        while (true) {
            try {
                System.out.println("\nPersonal Finance Manager");
                System.out.println("1. Add Transaction");
                System.out.println("2. Edit Transaction");
                System.out.println("3. Delete Transaction");
                System.out.println("4. List Transactions");
                System.out.println("5. Summarize Transactions");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addTransactionUI(manager);
                        break;
                    case 2:
                        editTransactionUI(manager);
                        break;
                    case 3:
                        deleteTransactionUI(manager);
                        break;
                    case 4:
                        manager.listTransactions();
                        break;
                    case 5:
                        manager.summarizeTransactions();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void addTransactionUI(FinanceManager manager) {
        System.out.print("Enter type (Income/Expense): ");
        String type = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        manager.addTransaction(new Transaction(manager.getNextId(), type, amount, description));
    }

    private static void editTransactionUI(FinanceManager manager) {
        System.out.print("Enter transaction ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new type (Income/Expense): ");
        String type = scanner.nextLine();
        System.out.print("Enter new amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        manager.editTransaction(id, type, amount, description);
    }

    private static void deleteTransactionUI(FinanceManager manager) {
        System.out.print("Enter transaction ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        manager.deleteTransaction(id);
    }
}
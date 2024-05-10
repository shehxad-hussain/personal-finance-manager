package net.javaguides.pfm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();
    private final String filePath = "transactions.dat";

    public FinanceManager() {
        loadTransactions();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        saveTransactions();
    }

    public void editTransaction(int id, String type, double amount, String description) {
        transactions.stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .ifPresent(transaction -> {
                    transaction.setType(type);
                    transaction.setAmount(amount);
                    transaction.setDescription(description);
                    saveTransactions();
                });
    }

    public void deleteTransaction(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
        saveTransactions();
    }

    public void listTransactions() {
        transactions.forEach(System.out::println);
    }

    private void saveTransactions() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(transactions);
        } catch (IOException e) {
            System.out.println("Error saving transactions.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadTransactions() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            transactions = (List<Transaction>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous transactions found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading transactions.");
        }
    }

    public void summarizeTransactions() {
        double incomeTotal = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double expenseTotal = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total Income: INR " + incomeTotal);
        System.out.println("Total Expenses: INR " + expenseTotal);
        System.out.println("Net Flow: INR " + (incomeTotal - expenseTotal));
    }

    public int getNextId() {
        return transactions.isEmpty() ? 1 : transactions.get(transactions.size() - 1).getId() + 1;
    }

}
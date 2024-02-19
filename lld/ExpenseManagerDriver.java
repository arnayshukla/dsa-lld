package com.practice.java.lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

/*
 * https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2
 */
public class ExpenseManagerDriver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.addUser("u1", "User1", "user1@gmail.com", "9876543211");
        userService.addUser("u2", "User2", "user2@gmail.com", "9876543212");
        userService.addUser("u3", "User3", "user3@gmail.com", "9876543213");
        userService.addUser("u4", "User4", "user4@gmail.com", "9876543214");

        ExpenseManagerService expenseManager = new ExpenseManagerService();
        System.out.println("Welcome to Splitwise. Please enter the first command");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            String commandType = command[0];
            switch (commandType) {
            case "SHOW":
                expenseManager.showBalance(command);
                break;
            case "EXPENSE":
                try {
                    expenseManager.addExpense(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please try again");
                }
                break;
            case "EXIT":
                scanner.close();
                System.exit(0);
                break;
            }
        }
    }

    

}


class User {
    private String id;
    private String name;
    private String phone;
    private String email;

    public User() {}

    public User(String id, String name, String phone, String email) {
      this.id = id;
      this.name = name;
      this.phone = phone;
      this.email = email;
    }

    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getPhone() {
      return phone;
    }
    public void setPhone(String phone) {
      this.phone = phone;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    
}

enum SplitType {
    EQUAL, EXACT, PERCENT;
}

class Split {
    private User paidTo;
    private double amount;

    public Split() {}

    public Split(User paidTo, double amount) {
      this.paidTo = paidTo;
      this.amount = amount;
    }

    public User getPaidTo() {
      return paidTo;
    }

    public void setPaidTo(User paidTo) {
      this.paidTo = paidTo;
    }

    public double getAmount() {
      return amount;
    }

    public void setAmount(double amount) {
      this.amount = amount;
    }

}

class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    public Expense() {}

    public Expense(String id, double amount, User paidBy, List<Split> splits) {
      this.id = id;
      this.amount = amount;
      this.paidBy = paidBy;
      this.splits = splits;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public double getAmount() {
      return amount;
    }

    public void setAmount(double amount) {
      this.amount = amount;
    }

    public User getPaidBy() {
      return paidBy;
    }

    public void setPaidBy(User paidBy) {
      this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
      return splits;
    }

    public void setSplits(List<Split> splits) {
      this.splits = splits;
    }

    
}

class UserService {
    private static Map<String, User> userMap = new HashMap<>();

    void addUser(String id, String name, String phone, String email) {
        userMap.put(id, new User(id, name, phone, email));
    }

    User getUserById(String id) {
        return userMap.get(id);
    }

    List<User> getUserList() {
        return new ArrayList<>(userMap.values());
    }
}

class SplitService {

    UserService userService = new UserService();

    List<Split> getSplitsBySplitType(SplitType splitType, double amount, List<String> splitWith, List<Double> splitAmount) throws Exception {
        List<Split> splits = new ArrayList<>();
        switch (splitType) {
        case EQUAL:
            splits = getEqualSplits(amount, splitWith);
            break;
        case EXACT:
            validateExactSplit(splitAmount, amount);
            splits = getExactSplits(amount, splitWith, splitAmount);
            break;
        case PERCENT:
            validatePercentSplit(splitAmount);
            splits = getPercentSplits(amount, splitWith, splitAmount);
            break;
        }
        return splits;
    }

    private List<Split> getPercentSplits(double amount, List<String> splitWith, List<Double> splitAmount) {
        List<Split> splits = new ArrayList<>();
        double totalAmount = 0;
        for (int i = 0; i < splitWith.size(); i++) {
            double share = (amount * (splitAmount.get(i)/100));
            totalAmount += share;
            Split split = new Split(userService.getUserById(splitWith.get(i)), share);
            splits.add(split);
        }
        if (totalAmount < amount) {
            splits.get(0).setAmount(splits.get(0).getAmount() + (amount - totalAmount));
        }
        return splits;
    }

    private void validatePercentSplit(List<Double> splitAmount) throws Exception {
        Double totalPercent = splitAmount.stream().mapToDouble(Double::doubleValue).sum();
        if (totalPercent.intValue() != 100) {
            throw new Exception ("Invalid Transaction. Split percents do not add up to 100 percent");
        }
        
    }

    private List<Split> getExactSplits(double amount, List<String> splitWith, List<Double> splitAmount) {
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < splitWith.size(); i++) {
            Split split = new Split(userService.getUserById(splitWith.get(i)), splitAmount.get(i).doubleValue());
            splits.add(split);
        }
        return splits;
    }

    private void validateExactSplit(List<Double> splitAmount, double amount) throws Exception {
        double totalAmount = splitAmount.stream().mapToDouble(Double::doubleValue).sum();
        if (totalAmount != amount) {
            throw new Exception ("Invalid Transaction. Split amounts do not add up to match expense amount");
        }
    }

    private List<Split> getEqualSplits(double amount, List<String> splitWith) {
        List<Split> splits = new ArrayList<>();
        double totalAmount = 0;
        for (String user : splitWith) {
            double share = amount/splitWith.size();
            Split split = new Split(userService.getUserById(user), share);
            splits.add(split);
        }
        if (totalAmount < amount) {
            splits.get(0).setAmount(splits.get(0).getAmount() + (amount - totalAmount));
        }
        return splits;
    }
}

class ExpenseService {
    
    SplitService splitService = new SplitService();
    UserService userService = new UserService();
    
    public Expense addExpense(String paidBy, double amount, SplitType splitType, List<String> splitWith, List<Double> splitAmount) throws Exception {
        Expense expense = new Expense();
        expense.setId(UUID.randomUUID().toString());
        expense.setPaidBy(userService.getUserById(paidBy));
        expense.setAmount(amount);
        expense.setSplits(splitService.getSplitsBySplitType(splitType, amount, splitWith, splitAmount));
        return expense;
    }

}

class ExpenseManagerService {

    List<Expense> expenses = new ArrayList<>();
    Map<String, Map<String, Double>> balanceSheet = new HashMap<>();
    ExpenseService expenseService = new ExpenseService();
    UserService userService = new UserService();

    public void addExpense(String[] command) throws Exception {
        initializeBalanceSheet();
        String paidBy = command[1];
        double amount = Double.valueOf(command[2]).doubleValue();
        int splitSize = Integer.valueOf(command[3]).intValue();
        List<String> splitWith = new ArrayList<>();
        for (int i = 1; i <= splitSize; i++) {
            splitWith.add(command[i+3]);
        }
        int splitTypeIndex = splitWith.size() + 3 + 1;
        SplitType splitType = SplitType.valueOf(command[splitTypeIndex]);
        List<Double> splitAmount = new ArrayList<>();
        if (!SplitType.EQUAL.equals(splitType)) {
            for (int i = 1; i <= splitSize; i++) {
                splitAmount.add(Double.valueOf(command[splitTypeIndex + i]));
            }
        }
        addExpense(paidBy, amount, splitType, splitWith, splitAmount);
    }

    private void initializeBalanceSheet() {
        if (!balanceSheet.isEmpty()) {
            return;
        }
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            Map<String, Double> userBalance = new HashMap<>();
            balanceSheet.put(user.getId(), userBalance);
        }
    }

    private void addExpense(String paidBy, double amount, SplitType splitType, List<String> splitWith, List<Double> splitAmount) throws Exception {
        Expense expense = expenseService.addExpense(paidBy, amount, splitType, splitWith, splitAmount);
        expenses.add(expense);
        updateBalanceSheet(expense);
    }

    private void updateBalanceSheet(Expense expense) {
        for (Split split : expense.getSplits()) {
            String paidTo = split.getPaidTo().getId();
            Map<String, Double> balances = balanceSheet.get(expense.getPaidBy().getId());
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(expense.getPaidBy().getId())) {
                balances.put(expense.getPaidBy().getId(), 0.0);
            }
            balances.put(expense.getPaidBy().getId(), balances.get(expense.getPaidBy().getId()) - split.getAmount());
        }
    }

    public void showBalance(String[] command) {
        if (command.length == 1) {
            showAllBalances();
        } else if (command.length == 2) {
            showUserBalance(command[1]);
        }
        
    }

    private void showUserBalance(String userId) {
        if (balanceSheet.isEmpty()) {
            System.out.println("No Balances");
            return;
        }
        for (Entry<String, Double> balanceEntry : balanceSheet.get(userId).entrySet()) {
                printBalance(userId, balanceEntry.getKey(), balanceEntry.getValue());
        }
        
    }

    private void showAllBalances() {
        if (balanceSheet.isEmpty()) {
            System.out.println("No Balances");
            return;
        }
        for (Entry<String, Map<String, Double>> userEntry : balanceSheet.entrySet()) {
            for (Entry<String, Double> balanceEntry : userEntry.getValue().entrySet()) {
                if (balanceEntry.getValue() > 0) {
                    printBalance(userEntry.getKey(), balanceEntry.getKey(), balanceEntry.getValue());
                }
            }
        }
        
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userService.getUserById(user1).getName();
        String user2Name = userService.getUserById(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }

}

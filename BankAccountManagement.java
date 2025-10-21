import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double amount = sc.nextDouble();

        BankAccount account = new BankAccount(name, amount);

        int choice;
        do {
            System.out.println("\n=== Bank Account Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                }
                case 3 -> account.checkBalance();
                case 4 -> account.displayAccountInfo();
                case 5 -> System.out.println("👋 Thank you for banking with us!");
                default -> System.out.println("❌ Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

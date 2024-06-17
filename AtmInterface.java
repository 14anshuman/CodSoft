import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void  setBalance(double balance) {
        this.balance = balance;
    }
}
 class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid amount. Please enter a positive number.";
        }
        if (amount > bankAccount.getBalance()) {
            return "Insufficient funds.";
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        return "Withdrawal successful. New balance: $" + String.format("%.2f", bankAccount.getBalance());
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Invalid amount. Please enter a positive number.";
        }
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        return "Deposit successful. New balance: $" + String.format("%.2f", bankAccount.getBalance());
    }

    public String checkBalance() {
        return "Your current balance is: $" + String.format("%.2f", bankAccount.getBalance());
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(bankAccount);

        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(atm.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(atm.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
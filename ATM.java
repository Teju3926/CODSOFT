import java.util.Scanner;
class Account {
    int balance;
    int minbal = 1000;

    Account(int initialBalance) {
        if (initialBalance >= minbal) {
            balance = initialBalance;
        } else {
            balance = minbal; 
        }
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    int getMinBalance() {
        return minbal;
    }
}

class ATM {
    Scanner sc = new Scanner(System.in);
    Account account;

    ATM(Account account) {
        this.account = account;
    }

    void deposit(int amt) {
        int newBalance = account.getBalance() + amt;
        account.setBalance(newBalance);
        System.out.println("Amount deposited successfully. New balance: " + newBalance);
    }

    void withdraw(int amt) {
        int currentBalance = account.getBalance();
        if (amt > currentBalance) {
            System.out.println("Insufficient balance");
        } else if (currentBalance - amt < account.getMinBalance()) {
            System.out.println("Minimum balance should be maintained");
        } else {
            int newBalance = currentBalance - amt;
            account.setBalance(newBalance);
            System.out.println("Amount withdrawn successfully. New balance: " + newBalance);
        }
    }

    void displayBalance() {
        System.out.println("Balance is: " + account.getBalance());
    }

    void start() {
        while (true) {
            System.out.println("1 to deposit");
            System.out.println("2 to withdraw");
            System.out.println("3 to display balance");
            System.out.println("0 to exit");
            System.out.print("Enter your choice from 0-4: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to be deposited: ");
                    int depositAmt = sc.nextInt();
                    deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to be withdrawn: ");
                    int withdrawAmt = sc.nextInt();
                    withdraw(withdrawAmt);
                    break;
                case 3:
                    displayBalance();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}


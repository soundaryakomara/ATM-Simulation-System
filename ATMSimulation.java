import java.util.*;

class ATM {

    private int pin = 1234;
    private double balance = 10000;

    ArrayList<String> miniStatement = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // login method
    public void login() {

        System.out.println("===== ATM MACHINE =====");

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {

            System.out.println("Login Successful\n");

            menu();

        } else {

            System.out.println("Wrong PIN");
        }
    }

    // menu method
    public void menu() {

        while (true) {

            System.out.println("\n===== ATM MENU =====");

            System.out.println("1. Balance Check");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    showMiniStatement();
                    break;

                case 5:
                    System.out.println("Thank You for Using ATM");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // balance checking method
    public void checkBalance() {

        System.out.println("Current Balance: " + balance);
    }

    // DEPOSIT METHOD
    public void deposit() {

        System.out.print("Enter Deposit Amount: ");

        double amount = sc.nextDouble();

        balance = balance + amount;

        miniStatement.add("Deposited: " + amount);

        System.out.println("Amount Deposited Successfully");
    }

    // money withdraw method
    public void withdraw() {

        System.out.print("Enter Withdraw Amount: ");

        double amount = sc.nextDouble();

        if (amount > balance) {

            System.out.println("Insufficient Balance");

        } else {

            balance = balance - amount;

            miniStatement.add("Withdrawn: " + amount);

            System.out.println("Please Collect Cash");
        }
    }

    // mini statement method
    public void showMiniStatement() {

        System.out.println("\n===== MINI STATEMENT =====");

        if (miniStatement.isEmpty()) {

            System.out.println("No Transactions");

        } else {

            for (String transaction : miniStatement) {

                System.out.println(transaction);
            }
        }

        System.out.println("Available Balance: " + balance);
    }
}

// main class
public class ATMSimulation {

    public static void main(String[] args) {

        ATM atm = new ATM();

        atm.login();
    }
}
package testBank;

public class Account
{


    // initialize variables
    private static int numberOfAccounts = 1000;
    private double balance;
    private double interest;
    private int accountNumber;


    // constructor
    public Account()
    {
        this.accountNumber = incrementNumberOfAccounts();
        // assigns the account number starting at 1000. Goes up by one for each new account.
    }

    public static int getNumberOfAccounts()
    {
        // returns the number of accounts
        return numberOfAccounts;
    }

    public static int incrementNumberOfAccounts()
    {
        // helper method part of the class. Increments the number of accounts by +1
        return Account.numberOfAccounts++;
    }

    public double getBalance()
    {
        // returns balance of account
        return balance;
    }

    public void setBalance(double balance)
    {
        // sets the balance of the account
        this.balance = balance;
    }

    public double getInterest()
    {
        // returns the interest in the account
        return interest;
    }

    public void setInterest(double interest)
    {
        // sets the interest of the account
        this.interest = interest;
    }

    public int getAccountNumber()
    {
        // returns account number
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        // sets account number
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount)
    {
        // deposit system. If deposited amount is <=0, it asks to enter a positive amount
        // else, it adds the amount to the accound balance according to the interest rate
        if (amount <= 0)
        {
            System.out.println("Please enter positive amount.");
            return;
        }
        checkInterest(amount);
        balance += amount + amount * interest;
        // displays total amount deposited, and total account balance
        System.out.printf("You have deposited $%.2f with an interest rate of %.0f%%.%n",
                amount, this.getInterest() * 100);
        System.out.printf("You now have a balance of %.2f.%n", balance);
    }

    public void withdraw(double amount)
    {
        // withdraw system. If user requests more funds than the account has, it says you have insurfficient funds and exits
        // else, it removes the amount from the account and prints it
        if (amount > this.balance)
        {
            System.out.println("You have insufficient funds.");
            return;
        }
        this.balance -= amount;
        checkInterest(0);
        System.out.printf("You have withdrawn %.2f.%n"
                + "You now have a balance of %.2f%n", amount, this.balance);
    }

    public void checkInterest(double amount)
    {
        // checks interest of a given amount
        // If the balance + amount value is greater than 10,000, the interest rate is 5%.
        // else, the interest rate is 2%
        // returns the interest rate
        if (balance + amount > 10000)
        {
            this.setInterest(0.05);
        }
        else
        {
            this.setInterest(0.02);
        }
    }
}

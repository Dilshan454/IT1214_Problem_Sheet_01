class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;
    

    //constructor
    BankAccount(int accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    //getter
    int getAccountNumber(){
        return accountNumber;
    }
    String getAccountHolder(){
        return accountHolder;
    }
    double getBalance(){
        return balance;
    }

    //setter
    void setAccountNumber(int accoutNumber){
        this.accountNumber=accountNumber;
    }
    void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }
    void setBalance(double balance){
        this.balance=balance;
    }

    //withdraw money
    void withdraw(double amount){
        if(amount>balance){
            throw new IllegalArgumentException( "Insufficient balance");
        }
        balance -=amount; 
    }
}


public class BankManager{
    public static void main(String[] args){
        //create account
        BankAccount acc=new BankAccount(1001, "Alice", 5000.0);

        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Holder: " + acc.getAccountHolder());
        System.out.println("Balance: " + acc.getBalance());


        //withdraw
        acc.withdraw(1000);
        System.out.println("after withdraw Balance: " + acc.getBalance());
    }
}
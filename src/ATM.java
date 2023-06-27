import java.util.*;
 class bankaccount{
    static  void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("WELCOME TO OUR BANK ATM PORTAL !");
        System.out.println("Enter your USER ID :");
        int user_id=sc.nextInt();
        System.out.println("Enter your USER PIN :");
        int user_pin=sc.nextInt();
        if((user_id == 12345) && (user_pin == 8981)){
        System.out.println("LOGIN SUCCESFUL , PLEASE PROCEED !");
        System.out.println("---------------------------");
        ATM.prompt();
        sc.close();
    }
 }
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
        sc.close();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATM.prompt();
        sc.close();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Name of the receiver :");
        String s=sc.nextLine();
        //System.out.println("Enter the account number of the receiving body");
        //int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully"+" to "+s);
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
        sc.close();
    }
}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("---------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=10000;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO THE ATM SYSTEM !");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int ch=sc.nextInt();
        switch (ch) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.out.println("LOGGING YOU OUT.........");
                System.exit(0);
        }
        sc.close();
    }

    public static void main(String[] args) {
        bankaccount.login();
    }
}

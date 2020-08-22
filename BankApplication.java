import java.util.Scanner;

public class BankApplication {
    static class BankAccount{
        int customerId;
        String customerName;
        int balance;
        int prevTransaction;

        void openAccount(){
        }

        void setDeposit(int amount){
            if (amount!=0){
                balance+=amount;
                prevTransaction = amount;
            }
        }

        void withdraw(int amount){
            if (amount!=0){
                balance-=amount;
                prevTransaction = -amount;
            }
        }

        void getPreTransaction(){
            if (prevTransaction>0){
                System.out.println("Deposited : "+prevTransaction);
            }else if (prevTransaction<0){
                System.out.println("Withdrawn : "+Math.abs(prevTransaction));
            }else {
                System.out.println("No previous transactions done");
            }
        }

        void showMenu(){
            char option;
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome "+customerName);
            System.out.println("Your CID is "+customerId);
            System.out.println();
            System.out.println("A : Create Account");
            System.out.println("B : Check Balance");
            System.out.println("C : Deposit Amount");
            System.out.println("D : Withdraw Amount");
            System.out.println("E : Previous Transactions");
            System.out.println("F : Exit");

            do {
                System.out.println("===================================================================================================================");
                System.out.println("Enter your option");
                System.out.println("===================================================================================================================");
                option = sc.next().charAt(0);
                System.out.println();

                switch (option){
                    case 'A':
                        System.out.println("-------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter your name ");
                        String name = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter your account number");
                        int acc_no = sc.nextInt();
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("Account created successfully");
                        break;

                    case 'B' :
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println("Your balance is : "+balance);
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        break;
                        
                    case 'C':
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter amount to be deposited: ");
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        setDeposit(sc.nextInt());
                        System.out.println();
                        break;
                        
                    case 'D':
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter amount to be withdrawn: ");
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        withdraw(sc.nextInt());
                        System.out.println();
                        break;
                        
                    case 'E':
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        getPreTransaction();
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        break;
                        
                    case 'F':
                        System.out.println("************************************************************************************************************");
                        break;
                        
                    default:
                        System.out.println("Invalid option! Please enter again");
                        break;
                }

            }while (option!='E');
                System.out.println("Thank you for using our services");
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.showMenu();
    }
}

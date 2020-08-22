import java.util.Scanner;

public class Main {
    static class BankAccount{
        int customerId;
        String customerName;
        int balance;
        int prevTransaction;

        BankAccount(String cName, int cID){
            this.customerId = cID;
            this.customerName = cName;
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
            System.out.println("A : Check Balance");
            System.out.println("B : Deposit Amount");
            System.out.println("C : Withdraw Amount");
            System.out.println("D : Previous Transactions");
            System.out.println("E : Exit");

            do {
                System.out.println("===================================================================================================================");
                System.out.println("Enter your option");
                System.out.println("===================================================================================================================");
                option = sc.next().charAt(0);
                System.out.println();

                switch (option){
                    case 'A' :
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println("Your balance is : "+balance);
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        break;
                    case 'B':
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter amount to be deposited: ");
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        setDeposit(sc.nextInt());
                        System.out.println();
                        break;
                    case 'C':
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter amount to be withdrawn: ");
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        withdraw(sc.nextInt());
                        System.out.println();
                        break;
                    case 'D':
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        getPreTransaction();
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println();
                        break;
                    case 'E':
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
        BankAccount b1 = new BankAccount("Aditya VSM",123);
        b1.showMenu();
    }


}

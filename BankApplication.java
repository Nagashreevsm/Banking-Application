import java.util.Scanner;

public class BankApplication {
    static Scanner sc = new Scanner(System.in);
    static class BankAccount{
        int customerId;
        String customerName;
        int balance;
        int prevTransaction;


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
            System.out.println("Enter your name ");
            customerName = sc.nextLine();
            System.out.println("Enter your account number");
            customerId = sc.nextInt();
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("Account created successfully");
            System.out.println("Welcome "+customerName);
            System.out.println("Your CID is "+customerId);

            System.out.printf("\n\n");
            System.out.println("A : Check Balance");
            System.out.println("B : Deposit Amount");
            System.out.println("C : Withdraw Amount");
            System.out.println("D : Previous Transactions");
            System.out.println("E : Neft");
            System.out.println("F : Exit");

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
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter amount to NEFT");
                        int amount1 = sc.nextInt();
                        if (amount1<=balance && amount1!=0) {
                            System.out.println("Enter account number of receiver ");
                            int toAcc = sc.nextInt();
                            System.out.println("Enter balance of receiver account");
                            int balance2 = sc.nextInt();
                            balance2 += amount1;
                            balance -= amount1;
                            System.out.printf("After NEFT transfer:\n from acc balance \t to acc balance \n " + balance + " \t\t\t\t\t " + balance2 + "\n");
                        }else
                            System.out.println("Your balance is too low for Neft request ");
                        break;

                    case 'F':
                        System.out.println("**************************************************************************************************************");
                        break;

                    default:
                        System.out.println("Invalid option! Please enter again");
                        break;
                }

            }while (option!='F');
            System.out.println("Thank you for using our services");
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.showMenu();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServerConnection controller = new ServerConnection();

        System.out.println("Welcome to the CRUD Apllication!!\n1. Show Data\n2. Add Data\n3. Update Data\n4. Delete Data");

        while (true) {
            System.out.println("Choose the operations you have to perform(1-4)");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    controller.readTable();
                    break;
                case 2:
                    System.out.print("Enter first name: ");
                    String fname = sc.nextLine();

                    System.out.print("\nEnter last name: ");
                    String lname = sc.nextLine();

                    System.out.print("\nEnter Age: ");
                    int age = sc.nextInt();

                    controller.createRecord(fname, lname, age);
                    break;
                case 3:
                    System.out.println("Enter new First Name: ");
                    String newName = sc.nextLine();
                    System.out.println("Enter the Class Id: ");
                    int Clid = sc.nextInt();
                    controller.updateRecord(newName,Clid);
                    break;
                case 4:
                    System.out.println("Enter First Name: ");
                    String fName = sc.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lName = sc.nextLine();
                    System.out.println("Enter Age Name: ");
                    int age_DB = sc.nextInt();

                    controller.deleteRecord(fName, lName, age_DB);
                    break;
                default:
                    break;
            }
        }



    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver {

    public static void main(String args[]) {
        // linkedlist initialize.
        LinkedList<Address> list = new LinkedList<>();

        // creating new file from the source address file.
        File file = new File("addresses.txt");
        // catching if file is found.
        try {
            Scanner in = new Scanner(file);
            for (int i = 0; i < 6; i++) {
                list.add(readAddress(in));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println("The Unsorted List");
        printList(list);

//        list.remove((Address) list.get(1));
//        System.out.println("removing node 1");
//        printList(list);
        
        list.head = list.mergeResult(list.head);
        System.out.println("The Sorted List");
        printList(list);
    }

    /**
     * A method that reads in an address one at a time.
     * 
     * @param in the scanner that is reading the file in.
     * @return returning a complete address.
     */
    public static Address readAddress(Scanner in) {
        Address newAddress = new Address();
        newAddress.setLastName(in.nextLine());
        newAddress.setFirstName(in.nextLine());
        newAddress.setStreetAddress(in.nextLine());
        newAddress.setZipcode(Integer.parseInt(in.nextLine()));
        newAddress.setPhoneNumber(in.nextLine());
        return newAddress;
    }

    /**
     * A method that prints the entire address linked list.
     * @param list the list to be printed
     */
    public static void printList(LinkedList<Address> list) {
        int i = 1;
        while (i < list.getSize() + 1) {
            printAddress((Address) list.get(i));
            i++;
        }

    }
    
    /**
     * A helper method for the printlist method that prints a single address.
     * 
     * @param address the address to be printed.
     */
    public static void printAddress(Address address) {
        System.out
                .println(address.getFirstName() + " " + address.getLastName());
        System.out.println(address.getStreetAddress());
        System.out.println(address.getPhoneNumber() + "\n");

    }
}
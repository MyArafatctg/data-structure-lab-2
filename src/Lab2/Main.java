package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("##########################################");
        System.out.println("WELCOME TO DHAKA INTERNATION UNIVERSITY");
        System.out.println("#########################################");

        while (true){
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            System.out.println("================================================");
            switch (choice){
                case 1:
                    System.out.println("You Choose option 1, so linear Searching is applied");
                    System.out.println("================================================");
                    performLinearSearch(scanner);
                    break;
                case 2:
                    System.out.println("You Choose option 2, so Binary Searching is applied ");
                    System.out.println("================================================");
                    performBinarySearch(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
    private static void performLinearSearch(Scanner scanner) {
        int[] array = getArrayFromUser(scanner);
        System.out.println(Arrays.toString(array));
        System.out.println("================================================");
        System.out.print("Enter the key to search:");
        int key = scanner.nextInt();
        System.out.println("================================================");
        int result = linearSearch(array,key);
        if (result != -1) {
            System.out.println("Key "+ array[result] +" found at index: " + result);
            System.out.println("================================================");
        } else {
            System.out.println("Key not found in the array.");
            System.out.println("================================================");
        }
    }
    public static void performBinarySearch(Scanner scanner){
        int[] array = getArrayFromUser(scanner);
        System.out.println(Arrays.toString(array));
        System.out.println("================================================");
        System.out.print("Enter the key to search:");
        int key = scanner.nextInt();
        System.out.println("================================================");
        int result = binarySearch(array,key);
        if (result != -1) {
            System.out.println("Key "+ array[result] +" found at index: " + result);
            System.out.println("================================================");
        } else {
            System.out.println("Key not found in the array.");
            System.out.println("================================================");
        }
    }

    public static int[] getArrayFromUser(Scanner scanner){
        System.out.print("Enter the size of the Array: ");
        int size = scanner.nextInt();
        System.out.println("================================================");
        int[] array = new int[size];
        for (int i=0;i<size;i++){
            System.out.print("Enter " + (i + 1) + " elements of the array:");
            array[i] = scanner.nextInt();
        }
        System.out.println("================================ ");
        System.out.println("Press 1 to sort Ascending order ");
        System.out.println("Press 2 to sort Descending order ");
        System.out.print("Choose an option : ");
        int sortOrder = scanner.nextInt();
        System.out.println("================================================");
        selectionSort(array, sortOrder);
        return array;
    }
    public static void selectionSort(int array[], int sortOrder) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            if (sortOrder == 1) {
                for (int i = step + 1; i < size; i++) {

                    // For Ascending order

                    if (array[i] < array[min_idx]) {
                        min_idx = i;
                    }
                }
            }else {
                for (int i = step + 1; i < size; i++) {

                    // For Descending order

                    if (array[i] > array[min_idx]) {
                        min_idx = i;
                    }
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
    public static int binarySearch(int array[], int key){
        int n = array.length;
        int low = 0;
        int high = n-1;
        while (low <=high){
            int mid = low + (high-low)/2;
            if (array[mid]==key)
                return mid;
            if (array[mid]<key)
                low= mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    private static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
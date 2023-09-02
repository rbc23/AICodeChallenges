Sure, here's the Java code for implementing the Binary Search algorithm:

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int key = 23;

        int index = binarySearch(arr, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

In this code, the `binarySearch` method implements the binary search algorithm. It takes an array `arr` and a key value to search for, and returns the index of the key in the array if found, or -1 if not found.

The `main` method in the program demonstrates an example usage of the binary search algorithm by creating an array `arr`, defining a key value to search for, and then calling the `binarySearch` method to search for the key in the array.

The program will output "Element found at index X" if the key is found in the array, or "Element not found" if the key is not present.
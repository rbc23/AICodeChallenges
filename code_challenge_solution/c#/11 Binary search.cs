using System;

class BinarySearch
{
    static int BinarySearchAlgorithm(int[] arr, int target)
    {
        int left = 0;
        int right = arr.Length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return -1;
    }

    static void Main()
    {
        int[] arr = { 2, 5, 7, 10, 15, 22, 30 };
        int target = 7;

        int result = BinarySearchAlgorithm(arr, target);

        if (result == -1)
            Console.WriteLine("Element not found");
        else
            Console.WriteLine("Element found at index " + result);
    }
}

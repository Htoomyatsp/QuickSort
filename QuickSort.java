public class QuickSort {

    public static void main(String[] args) {
        int[] myArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quicksort(myArray, 0, myArray.length - 1); // Call quicksort to sort the array in-place

        System.out.print("Sorted array: ");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = segmentation(arr, low, high); // Get the pivot index

            // Recursively apply quicksort to the subarrays to the left and right of the pivot
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int segmentation(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot as the last element
        int i = low - 1; // Initialize i to low - 1

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // Swap elements if they are less than or equal to the pivot
            }
        }

        swap(arr, i + 1, high); // Swap the pivot to its correct position
        return i + 1; // Return the index of the pivot
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

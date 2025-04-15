public class PartitionAlgorithm {

    // Lomuto partition scheme (choosing the last element as pivot)
    public static int partitionLomuto(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /**
     * TRY THIS
     */
    // Hoare partition scheme (choosing the first element as pivot for simplicity here)
    public static int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot && i < high);

            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot && j > low);

            // If pointers cross, return the right pointer's index
            if (i >= j) {
                return j;
            }

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 2, 1, 6, 8, 5, 3, 4};
        int pivotIndexLomuto = partitionLomuto(arr1, 0, (arr1.length  - 1));
        System.out.println("Array after Lomuto partition (pivot index: " + pivotIndexLomuto + "):");
        for (int val : arr1) {
            System.out.print(val + " ");
        }
        System.out.println();


        int[] arr2 = {7, 2, 1, 6, 8, 5, 3, 4};
        int pivotIndexHoare = partitionHoare(arr2, 0, (arr2.length - 1));
        System.out.println("Array after Hoare partition (pivot index: " + pivotIndexHoare + "):");
        for (int val : arr2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}


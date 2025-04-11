public class ShellSortWithInterval {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        for (int interval = n / 2; interval > 0; interval /= 2) {
            System.out.println("interval = "+interval);

            for (int i = interval; i < n; i++) {
                System.out.print("i="+ i + " & ");
                int temp = arr[i];
                System.out.println("temp=" + temp);
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    System.out.print("j=" + j + " & Swapping with " + j + "-&-" + (j - interval) + " ++ ");
                    arr[j] = arr[j - interval];
                }

                arr[j] = temp;
                System.out.println("");
            }

            System.out.println("");
            printArray(arr);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // int[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        // int[] data = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        int[] data = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 0};
        // int[] data = {50, 20, 80, 40, 100, 30, 70, 10, 90, 60};
        System.out.println("Size = "+data.length);
        System.out.println("Array before sorting:");
        printArray(data);
        System.out.println("---------------------------------------------");

        shellSort(data);

        System.out.println("---------------------------------------------");
        System.out.println("\nArray after sorting:");
        printArray(data);
    }

    public static void printArray(int[] arr) {
        int counter = 0;
        for (int value : arr) {
            System.out.print("(" + counter + "->)" + value + " ");
            ++ counter;
        }
        System.out.println();
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BucketSort {

    public static void sort(float[] arr) {
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float val : buckets[i]) {
                arr[index++] = val;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        float[] arr = new float[n];

        System.out.println("Enter " + n + " elements (values between 0 and 1):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextFloat();
        }

        sort(arr);

        System.out.println("Sorted array using Bucket Sort:");
        for (float f : arr) {
            System.out.print(f + " ");
        }
        System.out.println();
    }
}

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int arr[][] = {
                {3,2,5,4,10},
                {3,2,5,4,10,6}
        };

        for(int i=0;i<arr.length;i++){
            System.out.print(Arrays.toString(arr[i]) + " --> ");
            mergeSort(arr[i], 0, arr[i].length-1);
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }

        int mid = l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr,l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {23,45,56,67,78,89,101,104,108};
        int n = 68;

        int low = 0, high = arr.length-1;

        while(low<high){
            int mid = low + (high-low) / 2;

            if(arr[mid] >= n ){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        System.out.println(low);
        System.out.println(high);



    }



}

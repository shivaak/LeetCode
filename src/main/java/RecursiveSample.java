import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveSample {

    static List<List<Integer>> result= new ArrayList<>();

    public static void main(String[] args) {
        permute(new int[]{1,2,3},0);
        System.out.println(result);
        System.out.println(reverse("MURUGA"));
    }

    private static List<List<Integer>> permute(int[] arr, int p) {
        if(p==arr.length){
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            result.add(list);
        }else{
            for(int i=p;i<=arr.length-1;i++){
                swap(arr,p, i);
                permute(arr, p+1);
                swap(arr,i, p);
            }
        }
        return result;

    }

    private static void swap(int[] arr, int p, int i) {
        int t=arr[p];
        arr[p]=arr[i];
        arr[i]=t;
    }

    private static void printArray(int[] arr) {
        for(int i: arr){
            System.out.print(i);
        }
        System.out.println();
    }

    private static String reverse(String s){
        if(s.isEmpty()){
            return s;
        }else{
            return reverse(s.substring(1))+s.charAt(0);
        }
    }

}

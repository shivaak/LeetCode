import java.util.*;

public class RecoverArray2122 {

    public static void main(String[] args) {
        System.out.println(recoverArray(new int[]{2,10,6,4,8,12}));
    }

    public static int[] recoverArray(int[] nums) {

        Arrays.sort(nums);
        int[] newArr = new int[nums.length/2];

        Set<Integer> set = new LinkedHashSet<Integer>();
        Map<Integer,Integer> duplicates = new HashMap<>();
        for(int i=0;i<=nums.length-1;i++){
            set.add(nums[i]);
            duplicates.merge(nums[i], 1, Integer::sum);
        }

        int c=0;
        Integer[] array = set.toArray(new Integer[set.size()]);
        for(int i=0;i<=array.length-1;i+=2){
            int avg = (array[i]+array[i+1])/2;

            for(int j=1;j<=duplicates.get(array[i]);j++){
                newArr[c] = avg;
                c++;
            }
        }

        return newArr;
    }
}

//Just that given array is sorted now

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {

        int l=0;
        int r=numbers.length-1;

        while(numbers[l] + numbers[r]!=target){
            if(numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }

    public static void main(String[] args) {
        int ans[] = twoSum(new int[]{3,24,50,79,88,150,345}, 200);
        System.out.println(ans[0] + ", " + ans[1]);

    }
}

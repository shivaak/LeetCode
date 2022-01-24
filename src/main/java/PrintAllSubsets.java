
public class PrintAllSubsets {

    public static void main(String[] args) {
        printAllSubsets(new Integer[]{1,2});
    }

    private static void printAllSubsets(Integer[] arr) {
        Integer[] subs = new Integer[arr.length];
        helper(arr, subs, 0);
    }

    private static void helper(Integer[] arr, Integer[] subs, int i) {
        if(i==arr.length){
            print(subs);
        }else{
            subs[i]=null;
            helper(arr,subs,i+1);
            subs[i]=arr[i];
            helper(arr,subs,i+1);
        }
    }

    private static void print(Integer[] subs) {
        for(Integer i : subs){
            if(i!=null){
                System.out.print(i+",");
            }
        }
        System.out.println();
    }


}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sublist {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        //printAllSuBLists(Arrays.asList("Jane", "Bob", "Matt", "Sara"));
        printAllSubLists(Arrays.asList("Jane", "Bob"));

    }

    private static void printAllSubLists(List<String> list) {
        List<String> subList = new ArrayList<>();
        getAllSubLists(list, subList, 0);

        for(List<String> r : result){
            System.out.println(r);
        }
    }

    private static void getAllSubLists(List<String> list, List<String> subList, int start) {
        result.add(new ArrayList<>(subList));
        for(int i=start;i<=list.size()-1;i++){
            subList.add(list.get(i));
            getAllSubLists(list, subList, i+1);
            subList.remove(subList.size()-1);
        }
    }
}

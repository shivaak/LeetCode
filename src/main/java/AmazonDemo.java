import java.util.List;

public class AmazonDemo {

    public static int countGroups(List<String> related) {
        // Write your code here

        int size = related.size();
        boolean[] visited = new boolean[size];
        int noOfGroups = 0;

        for(int i=0;i<size;i++){
            if(!visited[i]){
                visited[i]=true;
                helper(related, i, visited);
                noOfGroups++;
            }
        }

        return noOfGroups;

    }

    public static void helper(List<String> related, int rowNumber, boolean[] visited) {

        String row = related.get(rowNumber);


        for(int c=0;c<row.length();c++){
            if(c==rowNumber) continue;

            int n = row.charAt(c) - '0';
            if(n==1 && !visited[c]){
                visited[c]=true;
                helper(related, n, visited);
            }
        }


    }
}

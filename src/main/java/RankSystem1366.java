import java.util.*;

public class RankSystem1366 {

    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));
    }

    private static String rankTeams(String[] votes) {

        Map<Character, int[]> voteMap = new HashMap<>();
        int noOfTeams = votes[0].length();

        for(String vote : votes){
            for(int i=0;i<=noOfTeams-1;i++){
                final char c = vote.charAt(i);
                voteMap.putIfAbsent(c, new int[noOfTeams]);
                voteMap.get(c)[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(voteMap.keySet());
        teams.sort((a,b)->{
           for(int i=0;i<noOfTeams-1;i++){
               if(voteMap.get(a)[i]!=voteMap.get(b)[i]){
                   return voteMap.get(b)[i] - voteMap.get(a)[i];
               }
           }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();
        for(Character c : teams){
            sb.append(c);
        }

    return sb.toString();


    }
}

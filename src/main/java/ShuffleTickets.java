import javax.xml.transform.Source;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ShuffleTickets {

    public static void main(String[] args) {

        String[] tickets={ "Mumbai-Chennai", "Kolkatta-Mumbai","Bangalore-Pune", "Delhi-Bangalore","Pune-Kolkatta" };
        printSourceAndDestinations(tickets);
    }

    private static void printSourceAndDestinations(String[] tickets) {
        Set<String> source = new HashSet<>();
        Set<String> dest = new HashSet<>();

        for(String ticket : tickets){
            String[] tkt = ticket.split("-");
            source.add(tkt[0]);
            dest.add(tkt[1]);
        }

        Set<String> tempSrc = new HashSet<>(source);
        source.removeAll(dest);
        dest.removeAll(tempSrc);

       /* Iterator<String> it = source.iterator();
        while(it.hasNext()){
            String src = it.next();
            if(dest.contains(src)){
                dest.remove(src);
                it.remove();
            }
        }*/

        //System.out.println(source.iterator().next());
        //System.out.println(dest.iterator().next());
        System.out.print(source + "->" + dest);

    }
}

public class Leetcode6028 {

    public static void main(String[] args) {
        System.out.println(countCollisions("LLRLRLLSLRLLSLSSSS"));
    }

    public static int countCollisions(String directions) {

        char[] moves = directions.toCharArray();

        //"S S R S S R L L R S L L R S R S S R L R R R R L L R R L S S R R"

        int count=0, tempcount=0;
        for(int i=0;i<moves.length;i++){
            char d = moves[i];

            if(d=='L'){
                if(i==0) continue;

                count=count+tempcount;
                tempcount=0;

                if(moves[i-1]=='R'){
                    count+=2;
                    moves[i]='S';
                    moves[i+1]='S';
                }else if(moves[i-1]=='S'){
                    count+=1;
                    moves[i]='S';
                }
            }else if(d=='R'){
                if(i==moves.length-1) continue;

                if(moves[i+1]=='L'){
                    count+=2;
                    moves[i]='S';
                    moves[i+1]='S';
                }else if(moves[i+1]=='S'){
                    count+=1; moves[i]='S';
                }else if(moves[i+1]=='R'){
                    tempcount++;
                }
            }else if(d=='S'){
                count=count+tempcount;
                tempcount=0;
            }
        }

        return count;

    }

}

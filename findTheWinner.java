import java.util.ArrayList;
public class findTheWinner {
    
        public int findThe_Winner(int n, int k) {
            //we use the list for storing the every list value after after removal storage
            ArrayList<Integer> list = new ArrayList<>(); //O(n)
        
            //traverse till length
            for(int i=1; i<= n ; i++){
                //add all the ele from 1 to n
                list.add(i);  //O(n)
            }
            int index =0;
            while(list.size()>1){   
                //deletion and shifting takes o(n) bcoz every time list is traversing till length 
                //and then shift the value by bacword kth position -1 (to count self as well)
                index =(index +(k-1))%list.size();
                list.remove(index);
            }
          return list.get(0 );
        }
    
        //main method for input n o/p
        public static void main(String[]arg){
            findTheWinner obj = new findTheWinner();
            //eg:-
            int n =5; //no of players
            int k=2; //step size every time inclduing self 
            
            //get the winner
            int winner = obj.findThe_Winner(n, k);
            System.out.println("The winner is- " + winner);
        }
    }
    
    // *T.C = n+n^2   and S.C= SIZE OF THE LIST o(n)
    


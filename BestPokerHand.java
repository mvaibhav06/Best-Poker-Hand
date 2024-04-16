import java.util.HashMap;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        char ch = suits[0];
        int i = 1;
        for(i=1; i<suits.length; i++){
            if(suits[i] != ch){
                break;
            }
        }
        if(i==suits.length){
            return "Flush";
        }
        HashMap<Integer,Integer> temp = new HashMap<>();

        for(int j=0; j<ranks.length; j++){
            if(temp.containsKey(ranks[j])){
                temp.put(ranks[j], temp.get(ranks[j])+1);
            }else{
                temp.put(ranks[j],1);
            }
        }
        int max = 0;

        for(int a : temp.values()){
            max = Math.max(a, max);
        }
        if(max>=3){
            return "Three of a Kind";
        }else if(max == 2){
            return "Pair";
        }else{
            return "High Card";
        }
    }
}

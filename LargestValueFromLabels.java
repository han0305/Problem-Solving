/* We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S. */

class Pair {
    
    int label;
    int value;
    
    Pair(int label,int value) {
        this.label = label;
        this.value = value;
    }
}

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        
        HashMap<Integer,Integer> limit = new HashMap<Integer,Integer>();
        ArrayList<Pair> pairList = new ArrayList<>();
        for(int i=0;i<labels.length;i++){
            if(!limit.containsKey(labels[i]))
                limit.put(labels[i],0);
            Pair p = new Pair(labels[i],values[i]);
            pairList.add(p);
        }
        
        Collections.sort(pairList,(Pair p1, Pair p2) -> p2.value - p1.value);
        int len = 0;
        int sum = 0;
        for(int i = 0;i<pairList.size() && len<num_wanted;i++) {
            int currLimit = limit.get(pairList.get(i).label);
            if(currLimit<use_limit) {
                sum+=pairList.get(i).value;
                len++;
                currLimit++;
                limit.put(pairList.get(i).label,currLimit);   
            }
            
        }
        return sum;
        
    }
}
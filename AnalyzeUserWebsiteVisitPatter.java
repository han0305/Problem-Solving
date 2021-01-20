/* We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence. */

class Pair {
    int a,b;
    Pair(int a,int b) {
        this.a = a;
        this.b = b;
    }
}

class CustomSort implements Comparator<Pair> {
    
    public int compare(Pair p1, Pair p2) {
        return p1.a - p2.a;
    }
    
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        int n = timestamp.length;
        Pair[] indTime = new Pair[n];
        for(int i=0;i<n;i++) {
            Pair p = new Pair(timestamp[i],i);
            indTime[i] = p;
            
        }
        Arrays.sort(indTime,new CustomSort());
        HashMap<String,ArrayList<String>> userData = new  HashMap<String,ArrayList<String>>();
        
        for(int i=0;i<n;i++) {
            int ind = indTime[i].b;
            if(userData.containsKey(username[ind])) {
                userData.get(username[ind]).add(website[ind]);
            }
            else {
                ArrayList<String> webList = new ArrayList<String>();
                webList.add(website[ind]);
                userData.put(username[ind],webList);
            }
        }
        HashMap<String,Integer> freq = new HashMap<String,Integer>();
        String mostFreq = " ";
        int maxmFreq = 0;
        for(Map.Entry m:userData.entrySet()) {
            String user = (String)m.getKey();
             ArrayList<String> webList = (ArrayList<String>)m.getValue();
            HashSet<String> localMap = new HashSet<String>();
             for(int i=0;i<webList.size();i++) {
                 for(int j=i+1;j<webList.size();j++) {
                     for(int k =j+1;k<webList.size();k++) {
                         StringBuilder seq = new StringBuilder();
                         seq.append(webList.get(i));
                         seq.append(" ");
                         seq.append(webList.get(j));
                         seq.append(" ");
                         seq.append(webList.get(k));
                         if(localMap.contains(seq.toString())){
                             continue;
                         }
                         int currFreq = freq.getOrDefault(seq.toString(),0);
                         currFreq++;
                         if(mostFreq.equals(" ")) {
                             mostFreq = seq.toString();
                             maxmFreq = currFreq;
                         }
                        else if(currFreq>maxmFreq) {
                             mostFreq = seq.toString();
                             maxmFreq = currFreq;
                         }
                         else if(currFreq == maxmFreq && seq.toString().compareTo(mostFreq)<0) {
                             mostFreq = seq.toString();
                         }
                         freq.put(seq.toString(),currFreq);
                         localMap.add(seq.toString());
                     }
                 }
             }
            
        }
        String[] webList = mostFreq.split(" ");
        List<String> res = new ArrayList<String>();
        for(int i=0;i<webList.length;i++) {
            res.add(webList[i]);
        }
        
        return res;
    }
}
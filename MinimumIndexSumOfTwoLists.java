/* Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer. */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hm = new HashMap<>();
        int i=0,j=0;
        int n1 = list1.length;
        int n2 = list2.length;
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        while(i<n1 || j<n2) {
            if(i<n1) {
                if(hm.containsKey(list1[i])) {
                    int sum = i+hm.get(list1[i]);
                    if(sum<min) {
                        min = sum;
                        res = new ArrayList<>();
                        res.add(list1[i]);
                    } else if(sum == min) {
                        res.add(list1[i]);
                    }
                } else {
                    hm.put(list1[i],i);
                }
                i++;
            }
            if(j<n2) {
                if(hm.containsKey(list2[j])) {
                    int sum = j+hm.get(list2[j]);
                    if(sum<min) {
                        min = sum;
                        res = new ArrayList<>();
                        res.add(list2[j]);
                    } else if(sum == min) {
                        res.add(list2[j]);
                    }
                } else {
                    hm.put(list2[j],j);
                }
                j++;
            }
        }
        
        String[] ans = new String[res.size()];
        for(i=0;i<res.size();i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
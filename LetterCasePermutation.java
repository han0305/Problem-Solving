/* Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order. */

class Solution {
    private void getCasePermutations(int idx, StringBuilder curr, String s, ArrayList<String> res) {
        if(idx==s.length()) {
            res.add(curr.toString());
            return;
        }
        char toAppend = s.charAt(idx);
        for(int i=1;i<=2;i++) {
            curr.append(toAppend);
            getCasePermutations(idx+1, curr, s, res);
            curr.deleteCharAt(idx);
            if(toAppend>='A' && toAppend<='Z') {
                toAppend = Character.toLowerCase(toAppend);
            }
            else if(toAppend>='a' && toAppend<='z') {
                toAppend = Character.toUpperCase(toAppend);
            }
            else {
                break;
            }
        }
        
    }
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<String>();
        getCasePermutations(0, new StringBuilder(), s, res);
        return res;
    }
}
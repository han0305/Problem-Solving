/* Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.  */

class Node {
    
    char value;
    Node[] nodes;
    boolean isEnd;
    
    Node(char value) {
        this.value = value;
        nodes = new Node[26];
        isEnd = false;
    }
    
}

class Solution {
    void addToTrie(String s , Node[] trie) {
        
        for(int i=0;i<s.length();i++) {
            int currInd = s.charAt(i) - 'a';
            if(trie[currInd] == null) {
                Node currNode = new Node(s.charAt(i));
                trie[currInd] = currNode;
            }
            if(i == s.length()-1) {
                trie[currInd].isEnd = true;
            }
            trie = trie[currInd].nodes;
        }
    }
    void getSuggestionsUtil(Node trie,StringBuilder prod, ArrayList<String> currSug) {
        
        if(currSug.size() == 3)
            return;
        if(trie == null)
            return;
        Node[] currNodes = trie.nodes;
        for(int i=0;i<currNodes.length;i++) {
            if(currSug.size() == 3)
                break;
            StringBuilder temp = new StringBuilder(prod);
            if(currNodes[i]!=null) {
                temp.append(currNodes[i].value);
                if(currNodes[i].isEnd == true) {
                    currSug.add(temp.toString());
                }
                getSuggestionsUtil(currNodes[i],temp,currSug);
                
            }
        }
        
    }
    void getSuggestions(Node[] trie,StringBuilder prod, ArrayList<String> currSug) {
        int i = 0;
        for(i=0;i<prod.length();i++) {
            char val = prod.charAt(i);
            int ind = val-'a';
            if(trie[ind]==null) 
                break;
            if(i==prod.length()-1 && trie[ind].isEnd==true){
                currSug.add(prod.toString());
            }
            trie = trie[ind].nodes;
            
        }
        if(i!=prod.length())
            return;
        for( i=0;i<trie.length;i++) {
            if(currSug.size() == 3)
                break;
            StringBuilder temp = new StringBuilder(prod);
            if(trie[i]!=null) {
                temp.append(trie[i].value);
                if(trie[i].isEnd == true) {
                    currSug.add(temp.toString());
                }
                getSuggestionsUtil(trie[i],temp,currSug);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Node[] trie = new Node[26];
        for(int i=0;i<products.length;i++) {
            addToTrie(products[i],trie);
        }
        // for(int i=0;i<26;i++) {
        //     if(trie[i]!=null) {
        //         System.out.println(i);
        //     }
        // }
        List<List<String>> suggestions = new ArrayList<>();
        StringBuilder prod = new StringBuilder();
        for(int i=0;i<searchWord.length();i++) {
            ArrayList<String> currSug = new ArrayList<String>();
            prod.append(searchWord.charAt(i));
            getSuggestions(trie,prod,currSug);
            suggestions.add(currSug);
        }
        
        return suggestions;
    }
}
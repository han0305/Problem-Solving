/* Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination. */

class CombinationIterator {

    ArrayList<String> comb;
    int combLength;
    String characters;
    int currIdx = 0;
    private void generateCombinations(StringBuilder curr, int idx) {
        if(curr.length() == combLength) {
            comb.add(curr.toString());
        }
        for(int i = idx;i<characters.length();i++) {
            curr.append(characters.charAt(i));
            generateCombinations(curr,i+1);
            curr.deleteCharAt(curr.length()-1);
        }
        
    }
    public CombinationIterator(String characters, int combinationLength) {
        comb = new ArrayList<String>();
        combLength = combinationLength;
        this.characters = characters;
        generateCombinations(new StringBuilder(), 0);
    }
    
    
    public String next() {
        return comb.get(currIdx++);
    }
    
    public boolean hasNext() {
        return currIdx<comb.size();
    }
}
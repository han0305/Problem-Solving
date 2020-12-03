/* You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles. */

class Solution {
public:
    void swap(char* a,char* b) {
        char temp = *a;
        *a = *b;
        *b = temp;
    }
    void backtrack(string tiles,string res,int curr,unordered_set<string>& comb)  {
        if(curr == tiles.length())
            return;
        for(int i = curr;i<tiles.length();i++) {
            swap(&tiles[i],&tiles[curr]);
            string temp = res+string(1,tiles[curr]);
          //  cout<<temp<<endl;
            comb.insert(temp);
            backtrack(tiles,temp,curr+1,comb);
            swap(&tiles[i],&tiles[curr]);
        }
    }
    int numTilePossibilities(string tiles) {
        unordered_set<string> comb;
        backtrack(tiles,"",0,comb);
        return comb.size();
    }
};
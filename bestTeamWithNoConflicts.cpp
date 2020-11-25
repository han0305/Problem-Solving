/* You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams. */

bool customSort(pair<int,int> p1,pair<int,int> p2) {
    if(p1.first == p2.first) 
        return p1.second<p2.second;
    return p1.first<p2.first;
}
class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        
        int l = ages.size();
        vector<pair<int,int>> agesInd(l);
        vector<int> dp(l);
        for(int i=0;i<l;i++) {
            agesInd[i] = {ages[i],scores[i]};
        }
        sort(agesInd.begin(),agesInd.end(),customSort);
        int maxm = INT_MIN;
        for(int i = 0;i<l;i++) {
            int ageSum = 0;
            dp[i] = agesInd[i].second;
            for(int j=0;j<i;j++) {
                
                int ageSum = 0;
                if(agesInd[j].second<=agesInd[i].second) {
                    dp[i] = max(dp[i],dp[j]+agesInd[i].second);
                }
                else if(agesInd[i].first == agesInd[j].first) {
                    ageSum+=agesInd[j].second;
                }
            }
           maxm = max(maxm,dp[i]+ageSum);
        }
        return maxm;
    }
};
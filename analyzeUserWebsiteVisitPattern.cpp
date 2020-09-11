/* We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence. */

bool compareFunc(const pair<int,int> &p1,const pair<int,int> &p2) {
        
        return (p2.first>p1.first);
    }
class Solution {
public:
    
    
    void updateFreq(vector<string> sites,unordered_map<string,int>& freq) {
        
        int n = sites.size();
        unordered_map<string,int> localMap;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                
                for(int k=j+1;k<n;k++) {
                    
                    string key = sites[i]+" "+sites[j]+" "+sites[k];
                   
                    if(freq.find(key) == freq.end()) {
                        freq[key] = 1;
                        localMap[key] = 1;
                    }
                    else if(localMap.find(key) == localMap.end()) {
                        //cout<<key<<endl;
                        freq[key]++;
                        localMap[key] = 1;
                    }
                    
                }
            }
        }
    }
    vector<string> mostVisitedPattern(vector<string>& username, vector<int>& timestamp, vector<string>& website) {
        unordered_map<string,int> freq;
        int ts = timestamp.size();
        vector<pair<int,int>> sortTime;
        
        for(int i=0;i<ts;i++) {
            sortTime.push_back(make_pair(timestamp[i],i));
        }
        
        sort(sortTime.begin(),sortTime.end(),compareFunc);
        unordered_map<string,vector<string>> visits;
        
        for(int i=0;i<ts;i++) {
            
            visits[username[sortTime[i].second]].push_back(website[sortTime[i].second]);
        }
        
        for(auto v:visits) {
            if(v.second.size()>=3) {
                cout<<v.first<<endl;
                updateFreq(v.second,freq);
            }
        }
        
        
        int maxm = INT_MIN;
        string res ="";
        for(auto f:freq) {
            //cout<<f.first<<" "<<f.second<<endl;
            if(f.second>maxm){
                maxm = f.second;
                res = f.first;
            }
            else if(f.second == maxm) {
                if(f.first < res) {
                    res = f.first;
                }
            }
        }
        int len = res.length();
        vector<string> ans;
        string temp = "";
        for(int i=0;i<len;i++) {
            if(i == len-1) {
               temp = temp+string(1,res[i]);
               ans.push_back(temp);
                break;
            }
            if(res[i] == ' '){
                ans.push_back(temp);
                temp = "";
            }
            else {
                temp = temp+string(1,res[i]);
            }
        }
        return ans;
    }
};
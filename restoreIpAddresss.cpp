/*Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. */

class Solution {
public:
   
    void getValidIps(string s,int start,int l,vector<string>& res,string temp,int count){
        
        if(start == l && count ==4){
            res.push_back(temp);
            return;
        }
        if(count == 4) {
            return;
        }
        int len = 1;
        if(s[start] == '0') {
            string newTemp = "";
            if(temp == ""){
                newTemp = "0";
            }
            else newTemp = temp + "." + "0";
            
            getValidIps(s,start+1,l,res,newTemp,count+1);
        }
        else {
            while(start+len-1<l && len<=3) {
                string newTemp = s.substr(start,len);
                if(len==3 && stoi(newTemp) > 255 )  {
                   
                    return;
                }
                else {
                    
                    if(temp!="") {
                        newTemp = temp+"."+newTemp;
                    }
                    getValidIps(s,start+len,l,res,newTemp,count+1);
                }
                len++;
            }
        }
        
        
        
    }
    
    vector<string> restoreIpAddresses(string s) {
        int l = s.length();
        vector<string> res;
        string temp = "";
        getValidIps(s,0,l,res,temp,0);
        return res;
    }
};
/* Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path. */


class Solution {
public:
    string simplifyPath(string path) {
        int l = path.length();
        stack<string> st;
        string curr = "";
        
        for(int i=0;i<l;i++) {
            if(path[i] == '/') {
                if(curr.length()>0) {
                st.push(curr);
                curr = "";
                }
            }
            else {
                curr = curr+string(1,path[i]);
                if(i==l-1) {
                    st.push(curr);
                }
            }
        }
        
        string newPath = "";
        int count = 0;
        while(!st.empty()) {
            curr = st.top();
            st.pop();
            if(curr == ".") {
                continue;
            }
            else if(curr == "..") {
                count++;
            }
            else {
                if(count>0) {
                    count--;
                }
                else {
                    if(newPath == "") {
                        newPath = curr;
                    }
                    else{
                        newPath = curr + "/" + newPath;
                    }
                }
            }
        }
        return "/"+newPath;
    }
};
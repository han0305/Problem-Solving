/* Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique. */

class Solution {
public:
    string removeDuplicates(string s, int k) {
    stack<pair<int, char>> st;
    int l = s.length();
    for (int i = 0; i < l; i++) {
        if (st.empty() || s[i] != st.top().second) {
            st.push(make_pair( 1, s[i] ));
        } else if (++st.top().first == k) {
            st.pop();
        }
    }
    s = "";
    while(!st.empty()) {
        pair<int,char> p =st.top();
        st.pop();
        s = string(p.first, p.second) + s;
    }
    return s;
}
};
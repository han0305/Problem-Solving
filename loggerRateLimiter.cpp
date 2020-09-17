/* Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time. */

class Logger {
public:
    
    unordered_map<string,int> umap;
    Logger() {
        
    }
    
    
    bool shouldPrintMessage(int timestamp, string message) {
        bool show = false;
        if(umap.find(message) == umap.end()) {
            
            show = true;
        }
        else {
            int pt = umap[message];
            show = timestamp-pt>=10?true:false;
        }
        
        if(show == true) {
            umap[message] = timestamp;
        }
        return show;
    }
};


/* Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.

 

Method read4:

The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf4.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C. */

class Solution {
public:
    
    char buffer[4];
    int bufferInd = 0;
    int len = 0;
    int read(char *buf, int n) {
            
        int i = 0;
        while(i<n) {
            if(bufferInd==len) {
                bufferInd = 0;
                len = read4(buffer);
                if(len == 0) 
                    break;
            }
            buf[i++] = buffer[bufferInd++];
            
        }
        return i;
    }
};
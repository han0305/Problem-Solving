/* You are given an array of network towers towers and an integer radius, where towers[i] = [xi, yi, qi] denotes the ith network tower with location (xi, yi) and quality factor qi. All the coordinates are integral coordinates on the X-Y plane, and the distance between two coordinates is the Euclidean distance.

The integer radius denotes the maximum distance in which the tower is reachable. The tower is reachable if the distance is less than or equal to radius. Outside that distance, the signal becomes garbled, and the tower is not reachable.

The signal quality of the ith tower at a coordinate (x, y) is calculated with the formula ⌊qi / (1 + d)⌋, where d is the distance between the tower and the coordinate. The network quality at a coordinate is the sum of the signal qualities from all the reachable towers.

Return the integral coordinate where the network quality is maximum. If there are multiple coordinates with the same network quality, return the lexicographically minimum coordinate. */


class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        
        int l = towers.size();
        if(l == 0)
            return {};
        int maxQuality = INT_MIN;
        int best_x,best_y;
        for(int i=0;i<l;i++) {
            int currQuality = 0;
            for(int j=0;j<l;j++) {
                double d =sqrt(pow(towers[i][0]-towers[j][0],2) + pow(towers[i][1]-towers[j][1],2));
                if(d<=radius) {
                     currQuality+= floor((1.0 *towers[j][2])/(1.0+d)); 
                }
            }
            
            cout<<towers[i][0]<<" "<<towers[i][1]<<" "<<currQuality<<endl;
            if(currQuality>maxQuality) {
                best_x = towers[i][0];
                best_y = towers[i][1];
                maxQuality = currQuality;
            }
            else if(currQuality == maxQuality) {
                if((towers[i][0]<best_x) || (towers[i][0] == best_x && towers[i][1]<best_y)) {
                    best_x = towers[i][0];
                    best_y = towers[i][1];
                }
            }
            
            }
        return {best_x,best_y};
        }
        
    
};
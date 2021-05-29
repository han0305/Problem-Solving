/* A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.

Implement the MyCalendarThree class:

MyCalendarThree() Initializes the object.
int book(int start, int end) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar. */

class MyCalendarThree {

    TreeMap<Integer,Integer> events;
    public MyCalendarThree() {
        events = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        
        events.put(start,events.getOrDefault(start,0)+1);
        events.put(end,events.getOrDefault(end,0)-1);
        int res = 0;
        int count = 0;
        for(int val:events.values()) {
            count+=val;
            res = Math.max(res,count);
            
        }
        return res;
    }
}

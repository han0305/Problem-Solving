/* You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar. */

class MyCalendarTwo {
    TreeMap<Integer, Integer> schedules;
    public MyCalendarTwo() {
        this.schedules =  new TreeMap<>();
        
    }
    
    public boolean book(int start, int end) {
        schedules.put(start, schedules.getOrDefault(start,0)+1);
        schedules.put(end, schedules.getOrDefault(end,0)-1);
        int active = 0;
        for(int value : schedules.values()) {
            active+=value;
            if(active>2) {
                schedules.put(start, schedules.get(start)-1);
                schedules.put(end, schedules.get(end)+1);
                return false;
            }
        }
        
        return true;
    }
}
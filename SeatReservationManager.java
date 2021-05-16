/* Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber. */

class SeatManager {

    int booked;
    PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        this.pq = new PriorityQueue<Integer>();
        this.booked = 0;
    }
    
    public int reserve() {
        if(this.pq.isEmpty()) {
            this.booked++;
            return booked;
        }
        else {
            int seatNo = pq.poll();
            return seatNo;
        }
    }
    
    public void unreserve(int seatNumber) {
        this.pq.offer(seatNumber);
        
    }
}
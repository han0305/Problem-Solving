/* Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far. */


class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap,minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(maxHeap.size()  == 0) {
            maxHeap.offer(num);
        }
        else if(maxHeap.peek() >= num) {
            maxHeap.offer(num);
            
        }
        else {
            minHeap.offer(num);
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            int maxm = maxHeap.poll();
            minHeap.offer(maxm);
        }
        else if(minHeap.size() - maxHeap.size() > 1) {
            int minm = minHeap.poll();
            maxHeap.offer(minm);
        }
    }
    
    public double findMedian() {
        int len = minHeap.size() + maxHeap.size();
        if(len%2 == 0) {
            double num1 = minHeap.peek();
            double num2 = maxHeap.peek();
            return (num1+num2)/2;
        }
        else {
            return maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek();
        }
    }
}


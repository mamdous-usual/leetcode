class MedianFinder {
    private PriorityQueue<Integer> smallHalf;
    private PriorityQueue<Integer> largeHalf; 

    public MedianFinder() {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder()); 
        largeHalf = new PriorityQueue<>(); 
    }

    public void addNum(int num) {
        if (smallHalf.isEmpty() || num <= smallHalf.peek()) {
            smallHalf.offer(num); 
            } else {
            largeHalf.offer(num);
        }

        if (smallHalf.size() > largeHalf.size() + 1) {
            largeHalf.offer(smallHalf.poll());  
        } else if (largeHalf.size() > smallHalf.size()) {
            smallHalf.offer(largeHalf.poll()); 
        }
    }

    public double findMedian() {
        if (smallHalf.size() > largeHalf.size()) {
            return smallHalf.peek();
        } else {
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
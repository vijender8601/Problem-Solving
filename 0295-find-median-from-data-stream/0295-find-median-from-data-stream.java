class MedianFinder {
       Queue<Integer> left ,right;

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int x) {
        if(right.isEmpty()) right.offer(x);
        else if(left.isEmpty()){
            if(x<=right.peek())
            left.offer(x);
            else {
                left.offer(right.poll());
                right.offer(x);
            }
        }
        else {
            if(x>=left.peek())
            {
                right.offer(x);
            } else {
                left.offer(x);
            }
            
            if(right.size()>left.size()+1)
            {
                left.offer(right.poll());
            }
            
            if(left.size()>right.size())
            {
                right.offer(left.poll());
            }
        }
    }
    
    public double findMedian() {
        if(right.size()==left.size()) {
            double med = right.peek()+left.peek();
            return med/(double)2;
        }
        else return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
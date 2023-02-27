import java.util.Deque;
import java.util.LinkedList;

public class SlideWindowMaxValue {
    class MyQueue{
        Deque<Integer> deque = new LinkedList<>();
        void poll(int value){
            if (!deque.isEmpty() && deque.peek()==value){
                deque.poll();
            }
        }
        void push(int value){
            while (!deque.isEmpty() && value>deque.getLast()){
                deque.removeLast();
            }
            deque.add(value);

        }
        int peek(){
            return deque.peek();
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==1){
            return nums;
        }
        int len = nums.length-k+1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i= 0;i<k;i++){
            myQueue.push(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i= k;i<nums.length;i++){
            myQueue.poll(nums[i-k]);
            myQueue.push(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

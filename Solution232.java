class MyQueue {
    
    private int[] elem;
    private int top;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;
    
    
    /** Initialize your data structure here. */
    public MyQueue() {
        this.elem = new int[DEFAULT_SIZE];
        this.top=0;
        this.usedSize=0;
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.elem[this.top]=x;
        this.top++;
        this.usedSize++;
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data=this.elem[0];
        for(int i=0;i<this.usedSize-1;i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.top--;
        this.usedSize--;
        return data;
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[0];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.top==0;
    }
}
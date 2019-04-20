class MyStack {
    class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data=data;
        }
    }
    private Node front;
    private Node rear;
    private int usedSize;

    /** Initialize your data structure here. */
    public MyStack() {
        this.rear=null;
        this.front=null;
        this.usedSize=0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Node node=new Node(x);
        if(empty()) {
            this.rear=node;
            this.front=node;
            this.usedSize=1;
        }else {
            this.rear.next=node;
            this.rear=this.rear.next;
            this.usedSize++;
        }       
    }
    
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        Node node=this.rear;
        Node cur=this.front;
        for(int i=1;i<usedSize-1;i++) {
            cur=cur.next;
        }
        cur.next=null;
        this.rear=cur;
        usedSize--;
        return node.data;
    }
    
    /** Get the top element. */
    public int top() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.rear.data;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.usedSize==0;
    }
}
public class SampleBrowser{
    public static void main(String[] args){
        SampleBrowser browser=new SampleBrowser();

    }

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser(){
        this.backStack=new LinkedListBasedStack();
        this.forwardStack=new LinkedListBasedStack();
    }

    void goForward(){
        this.currentPage=forwardStack.top.getData();
    }
    void goBackward(){
        this.currentPage=backStack.top.getData();
    }

    void open(String url){
        if(forwardStack.top.getData().equals("")){
            this.currentPage = url;
        }
        if(forwardStack.top.getData())

    }

    public static class LinkedListBasedStack{
        Node top=null;
        int size=0;

        public LinkedListBasedStack(){
        }

        void push(String data){
            var newNode=new Node(data, null);
            if(top==null){
                top=newNode;
                size++;
            }
            else{
                newNode.next=top;
                top=newNode;
                size++;
            }
        }

        String pop(){
            if(top!=null){
                String tempData = top.data;
                top=top.next;
                return tempData;
            }
            else{
                System.out.println("The stack is empty, pop fail");
                return "Error";
            }
        }

        void printAll(){
            if(top==null){
                System.out.println("The stack is empty, print fail");
            }
            var p=top;
            while(p!=null){
                System.out.println(p.data);
                p=p.next;
            }
        }
    }

    public static class Node{
        String data;
        Node next;

        public Node(){
        }
        public Node(String data, Node next){
            this.data=data;
            this.next=next;
        }

        String getData(){
            return data;
        }
    }
}
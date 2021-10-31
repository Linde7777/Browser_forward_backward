import java.util.LinkedList;

import javax.swing.plaf.synth.SynthToggleButtonUI;

public class Browser {
    public static void main(String[] args){
        var browser=new Browser();
        browser.open("a.com");
        browser.open("b.com");
        browser.open("c.com");
        browser.open("d.com");

        browser.goBackward();
        browser.goForward();
        browser.printCurrPage();
    }

    private String currPage;
    LinkedListBasedStack mainStack;
    LinkedListBasedStack tempStack;
    public Browser(){
        this.mainStack=new LinkedListBasedStack();
        this.tempStack=new LinkedListBasedStack();
    }

    void open(String currPage){
        mainStack.push(currPage);
    }

    void goForward(){
        if(tempStack.size>0){
            mainStack.push(tempStack.pop());
        } else {
            System.out.println("Can not go forward");
        }
    }

    void goBackward(){
        if(mainStack.size>0){
            tempStack.push(mainStack.pop());
        } else {
            System.out.println("Can not go backward");
        }
    }

    void printCurrPage(){
        System.out.println(mainStack.top.getData());
    }

    public static class LinkedListBasedStack{
        private Node top;
        private int size;

        void push(String data){
            var newNode = new Node(data,null);
            if(top==null){
                top=newNode;
            }
            else{
                newNode.next=top;
                top=newNode;
            }
        }

        String pop(){
            if(top==null){
                return "Empty";
            }
            else{
                String tempString=top.data;
                top=top.next;
                return tempString;
            }
        }

        void printAll(){
            Node p = top;
            if(p==null){
                System.out.println("Print Fail");
            }
            while(p!=null){
                System.out.println(p.data);
                p=p.next;
            }
        }
    }

    public static class Node{
        private String data;
        private Node next;
        public Node(){}
        public Node(String data, Node next){
            this.data=data;
            this.next=next;
        }

        String getData(){
            return this.data;
        }
    }
}

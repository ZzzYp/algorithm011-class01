import java.util.Deque;
import java.util.LinkedList;

import javax.net.ssl.SSLKeyException;

class Deque_newAPI{


    public void oldAPI(){
        
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);


        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size()>0){
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }


    public void newAPI(){
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println("newAPI: " + deque);

        String str = deque.peekFirst();
        System.out.println("newAPI: " + str);
        System.out.println("newAPI: " + deque);

        while(deque.size()>0){
            System.out.println("newAPI: " + deque.removeFirst());
        }

        System.out.println("newAPI: " + deque);    

    }


    public void newAPI2(){
        Deque<String> deque = new LinkedList<>();
        deque.addLast("c");
        deque.addLast("b");
        deque.addLast("a");
        System.out.println("newAPI2: " + deque);

        String str = deque.peekFirst();
        System.out.println("newAPI2: " + str);
        System.out.println("newAPI2: " + deque);

        while(deque.size()>0){
            System.out.println("newAPI2: " + deque.removeFirst());
        }

        System.out.println("newAPI2: " + deque);    

    }


    public static void main(String[] args) {
        Deque_newAPI dn = new Deque_newAPI();
        dn.oldAPI();
        dn.newAPI();
        dn.newAPI2();
        
    }

}
package For_Fun.lab3;

public class Test {
    public static void main(String[]args){
        Stack<Object> s = new Stack<>(1,3);
        s.push("hi");
        System.out.println(s.pop());
        System.out.println(s);
        Queue<Integer> q = new Queue<>(1, 3);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q);
    }
}

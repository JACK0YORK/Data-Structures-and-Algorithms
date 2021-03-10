package Lab_3.j;
public class Lab_3 {
    public static void main(String[] args) {
        ArrayList<Object> w = new ArrayList<>();
        w.add(0, 5);
        w.add(0, 10);
        w.add(0, 15);
        w.add(0, 20);
        w.add(0, 25);
        w.add(0, "pi");
        w.add(4, -1);
        w.add(4, -1);
        w.add(5, -2);
        w.add(5, -2);
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        System.out.println("Removed " + w.remove(4));
        System.out.println("Removed " + w.remove(5));
        System.out.println("Removed " + w.remove(5));
        System.out.println("Removed " + w.remove(4));
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        System.out.println(w.contains(5));
        System.out.println(w.contains(30));
        System.out.println(w.contains(-1));
        System.out.println("Empty? " + w.isEmpty());
        w.clear();
        System.out.println("Empty? " + w.isEmpty());
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
        w.add(0, 5);
        w.add(1, 6);
        w.add(2, 7);
        for (int i = 0; i < w.size(); i++) {
            System.out.println(i + " -> " + w.get(i));
        }
    }
}

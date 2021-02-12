public class Wolf extends Canine {

    @Override
    public void speak() {
        System.out.println("*Awoooooo..");
    }

    @Override
    public boolean eat(Mammal other) {
        if (!(other instanceof Wolf)) {
            System.out.println("*chomps meat");
            return true;
        }
        System.out.println("no");
        return false;
    }

    @Override
    public boolean mate(Mammal other) {
        if (other instanceof Wolf) {
            System.out.println("*Awoooooo~");
            return true;
        }
        System.out.println("no");
        return false;
    }

}

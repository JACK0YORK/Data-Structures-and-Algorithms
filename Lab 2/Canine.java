public class Canine implements Mammal {

    @Override
    public void speak() {
        System.out.println("*Woof..");
    }

    @Override
    public boolean eat(Mammal other) {
        if (!(other instanceof Canine)) {
            System.out.println("*chomps meat");
            return true;
        }
        return false;
    }

    @Override
    public void sleep() {
        System.out.println("Ssssuu..");
    }

    @Override
    public boolean mate(Mammal other) {
        if (other instanceof Canine) {
            System.out.println("*Woof~");
            return true;
        }
        return false;
    }

}

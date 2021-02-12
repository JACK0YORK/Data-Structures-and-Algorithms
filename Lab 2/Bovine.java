public class Bovine implements Mammal {

    @Override
    public void speak() {
        System.out.println("*Moo");
    }

    @Override
    public boolean eat(Mammal other) {
        if (!(other instanceof Bovine)) {
            System.out.println("*Chews flesh");
            return true;
        }
        return false;
    }

    @Override
    public void sleep() {
        System.out.println("*Zzzzz..");
    }

    @Override
    public boolean mate(Mammal other) {
        if (other instanceof Bovine) {
            System.out.println("*Moo~");
            return true;
        }
        return false;
    }

}

public class Bull extends Bovine {

    @Override
    public void speak() {
        System.out.println("*Mouu..");
    }

    @Override
    public boolean eat(Mammal other) {
        if (!(other instanceof Bovine)) {
            System.out.println("*chews flesh.");
            return true;
        }
        System.out.println("no");
        return false;
    }

    @Override
    public boolean mate(Mammal other) {
        if (other instanceof Bovine) {
            System.out.println("*Moo~");
            return true;
        }
        System.out.println("no");
        return false;
    }
}

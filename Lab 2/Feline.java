public class Feline implements Mammal {

    @Override
    public void speak() {
        System.out.println("*Meow..");
    }

    @Override
    public boolean eat(Mammal other) {
        if (!(other instanceof Feline)) {
            System.out.println("*tears into meat");
            return true;
        }
        return false;
    }

    @Override
    public void sleep() {
        System.out.println("*Purrrrr...");
    }

    @Override
    public boolean mate(Mammal other) {
        if (other instanceof Feline) {
            System.out.println("*Meow~");
            return true;
        }
        return false;
    }

}

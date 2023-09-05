class AbstractionImplement extends Abstraction implements Interface {

    @Override
    void sayHello(String nama) {
        System.out.println("Hello " + nama);
    }


    @Override
    public void sayHi(String nama) {
        System.out.println("Hi " + nama);
    }
}

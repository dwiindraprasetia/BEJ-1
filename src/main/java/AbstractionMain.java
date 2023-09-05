public class AbstractionMain {
    public static void main(String[] args) {

        Abstraction abstractObject = new AbstractionImplement();
        AbstractionImplement abstractObjectLagi = new AbstractionImplement();

        abstractObject.sayHello("Dwi Indra");
        abstractObjectLagi.sayHi("Sri Sintia");

        System.out.println(abstractObject.gender);
    }
}

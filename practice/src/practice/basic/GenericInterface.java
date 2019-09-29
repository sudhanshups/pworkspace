package practice.basic;

class Base {
    int a;
    String name = "base";
}
class Child1 extends Base {
    int b;
}

interface GenInterface {
    int getStatus();
    int getMessage();
}

class Wrapper implements GenInterface {
    Child1 child1;
    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public int getMessage() {
        return 1;
    }
}

public class GenericInterface {

//      populateStatus(){
//        return null;

}

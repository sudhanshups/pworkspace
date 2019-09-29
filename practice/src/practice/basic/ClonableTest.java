package practice.basic;

// all object
class Test implements Cloneable {
    int x, y;

    @Override
    public Test clone() throws CloneNotSupportedException {
        Test t = (Test) super.clone();
        return t;
    }
}

// Contains a reference of Test and implements
// clone with deep copy.
class Test2 implements Cloneable {
    int a, b;

    Test c;
    Integer d;

    @Override
    public Test2 clone() throws CloneNotSupportedException {
        // Assign the shallow copy to new reference variable t
        Test2 t = (Test2) super.clone();
        t.c = this.c.clone();

        t.c.x = this.c.x;
        t.c.y = this.c.y;

        return t;
    }
}

public class ClonableTest {
    public static void main(String args[]) throws CloneNotSupportedException {
        Test2 t2 = new Test2();
        t2.a = 10;
        t2.b = 20;
        t2.d = new Integer(50);

        t2.c = new Test();
        t2.c.x = 30;
        t2.c.y = 40;

        Test2 t3 = (Test2) t2.clone();
        t3.a = 100;
        t3.d = 60;

        // Change in primitive type of t2 will not
        // be reflected in t2 field
        t3.c.x = 300;

        // Change in object type field of t2 will not
        // be reflected in t2(deep copy)
        System.out.println(t2.a + " " + t2.b + " " + t2.d + " " + t2.c.x + " " + t2.c.y);
        System.out.println(t3.a + " " + t3.b + " " + t3.d + " " + t3.c.x + " " + t3.c.y);
    }
}
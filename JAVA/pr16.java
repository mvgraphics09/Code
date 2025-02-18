class A {
    int a = 10, b = 20;

    void add() {
        System.out.println(a + b);
    }
}

class B extends A {
    void sub() {
        System.out.println(b - a);
    }
}

class C extends A {
    void mul() {
        System.out.println(a * b);
    }
}

 class Pr16 {
    public static void main(String[] args) {
        // Object of class B
        B objB = new B();
        System.out.println("Add of two numbers (from class A):");
        objB.add();
        System.out.println("Subtraction of two numbers (from class B):");
        objB.sub();

        // Object of class C
        C objC = new C();
        System.out.println("Add of two numbers (from class A):");
        objC.add();
        System.out.println("Multiplication of two numbers (from class C):");
        objC.mul();
    }
}

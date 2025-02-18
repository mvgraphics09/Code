import java.util.*;
class student
{
    int enrollment ;
    String name;
    void display()
    {
        System.out.println(enrollment);
        System.out.println(name);
    }
}

class pr6
{
    public static void main(String[] args) {
        student s1= new student();
        student s2= new student();
        student s3= new student();

        s1.enrollment = 9;
        s1.name ="abc";
        s1.display();

        s2.enrollment = 10;
        s2.name = "xyz";
        s2.display();

        s3.enrollment = 15;
        s3.name = "pqr";
        s3.display();

    }
}
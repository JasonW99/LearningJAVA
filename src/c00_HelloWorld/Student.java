package c00_HelloWorld;

public class Student {
    public int age = 23;
    //(member) field: the field value is stick to the object. and we set a initial value to it as 23.
    //i.e. some objects equal to 19, some objects equal to 22.
    private final String name;
    //(constant) field: once assigned value to the field, the value cannot change any more.
    private static String school;
    //(static) field: the field value is stick to the class.
    //i.e. once 'Student.school' is assigned by 'UCSD', then all objects under 'Student' will be from 'USCD'.
    //On the other hand, if the 'Student.school' is changed to 'UCLA', then all objects under 'Student' will be from 'USLA'.
    private static final String GREETINGS = "Hello";
    //(static constant) field: the field value is stick to the class, once assigned value, the value can change no more.

    //define the constructor
    public Student(String name) {
        this.name = name;

    }

    //define some method
    public int getAge() {    //(member) method, getter or accessor
        return age;
    }

    public String getName(){    //(member) method, getter or accessor
        return name;
    }

    public void setAge(int age) {   //(member) method, setter
        this.age = age;
    }

    public void sayHello(){    //(member) method
        int a = 5;  // local variable
        System.out.println(GREETINGS + "! I am " + name + ". I am " + age);
    }
}

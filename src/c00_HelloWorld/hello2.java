package c00_HelloWorld;

public class hello2 {
    public static void main(String[] args){
        Student firstStudent = new Student("Tom");
        Student secondStudent = new Student("Jerry");
//        firstStudent.setAge(17);
        secondStudent.setAge(11);
        firstStudent.sayHello();
        secondStudent.sayHello();
        Student thirdStudent = null;
        try{
            thirdStudent.sayHello();
        }catch(NullPointerException e){
            System.out.println("Expected error occured! -" + e.toString());
        }
    }
}

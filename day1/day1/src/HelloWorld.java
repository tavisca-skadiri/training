import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(sayHello("Male", "Saqlain",21, "India"));
    }
    private static String getName(String name){
        return name;
    }
    private static String getDesignation(int age){
        if(age>18)
            return  "Mr.";
        return "Master";
    }
    private static String greet(String country){
        if(country.equals("Spain"))
            return "Hola";
        if(country.equals("India"))
            return "Namastay";
        return "Hello";
    }
    public static String sayHello(String gender, String name,int age,String country){
        if(gender.equals("Male"))
            return greet(country) + getDesignation(age) + getName(name);
        else if(gender.equals("Female"))
            return greet(country) + "Miss." + getName(name);
        else return "";
    }
}
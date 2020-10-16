public class Person {

    private String name;
    public int age;
    public String favoriteColor;

    //constructors
    public Person(String name){
        this.name = name;
        this.age = 0;
        this.favoriteColor = "";
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.favoriteColor = "";
    }
    public Person(String name, int age, String favoriteColor){
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }


    public String getName(){
//        System.out.println(this.name);
        return this.name;
//TODO: return the person's name
    }

    public void setName(String name){
        this.name = name.trim().toUpperCase();
        System.out.println(this.name);
//TODO: change the name property to the passed value
    }
    public void sayHello(){
        System.out.printf("%s says hello! \n", this.name);
//TODO: print a message to the console using the person's name
    }

}

public class Exer1_Functional {
    // OOP: simple class representing an Animal
    static class Animal {
        String name;
        Animal(String name) { this.name = name; }
        void speak() { System.out.println(name + " is making a sound."); }
    }

    public static void main(String[] args) {
        Animal dog = new Animal("Dog");
        Animal cat = new Animal("Cat");

        dog.speak();
        cat.speak();
    }
}

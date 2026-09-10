public class MemoryBasics {

    public static void main(String[] args) {

        // Runtime state and reassignment
        int score = 50;
        System.out.println("Initial score: " + score);

        score = score + 10;
        System.out.println("Updated score: " + score);

        // Variable, type, and value
        int age = 22;
        System.out.println("Age: " + age);

        age = 23;
        System.out.println("Updated age: " + age);

        // Primitive assignment copies the value
        int a = 10;
        int b = a;

        a = 99;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
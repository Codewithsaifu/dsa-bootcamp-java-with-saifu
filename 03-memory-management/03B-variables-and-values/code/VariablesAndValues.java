public class VariablesAndValues {

    public static void main(String[] args) {

        // 1. Declaration and assignment
        int age;
        age = 22;

        System.out.println("Age: " + age);

        // 2. Reassignment
        age = 23;

        System.out.println("Updated age: " + age);

        // 3. Declaration with initialization
        int score = 50;

        System.out.println("Score: " + score);

        // 4. Expression produces a value
        int bonus = 10;
        int total = score + bonus;

        System.out.println("Total: " + total);

        // 5. Primitive value copying
        int a = 10;
        int b = a;

        a = 99;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        // 6. State changes through expressions
        int x = 5;
        int y = x;

        x = x + 10;
        y = y + x;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }
}
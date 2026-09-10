public class PrimitiveTypes {

    // Fields receive default initialization.
    static int defaultNumber;
    static boolean defaultBoolean;
    static char defaultChar;

    public static void main(String[] args) {

        // 1. Integer primitives
        byte byteValue = 127;
        short shortValue = 32_767;
        int intValue = 2_147_483_647;
        long longValue = 9_000_000_000L;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);

        // 2. Integer overflow
        int max = Integer.MAX_VALUE;
        max++;

        System.out.println("int overflow: " + max);

        // 3. Floating-point types
        float price = 10.5f;
        double result = 0.1 + 0.2;

        System.out.println("float: " + price);
        System.out.println("0.1 + 0.2: " + result);
        System.out.println("equals 0.3: " + (result == 0.3));

        // 4. char behavior
        char letter = 'A';

        System.out.println("char: " + letter);
        System.out.println("char numeric value: " + (int) letter);

        letter++;

        System.out.println("char after increment: " + letter);

        // 5. boolean
        boolean isReady = true;

        System.out.println("boolean: " + isReady);

        // 6. Default values of fields
        System.out.println("default int field: " + defaultNumber);
        System.out.println("default boolean field: " + defaultBoolean);
        System.out.println("default char numeric value: " + (int) defaultChar);

        // 7. Numeric promotion
        byte a = 10;
        byte b = 20;

        int sum = a + b;

        System.out.println("byte + byte result: " + sum);

        // 8. Constant-expression narrowing
        byte constantSum = 10 + 20;

        System.out.println("constant byte sum: " + constantSum);

        // 9. Avoiding int multiplication overflow
        int x = 100_000;
        int y = 100_000;

        long safeProduct = (long) x * y;

        System.out.println("safe product: " + safeProduct);
    }
}
package euler;

/**
 * Largest Prime Factor
 * The prime factors of 13195 are 5,7,13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
public class EulerDrei {
    public static void main(String[] args) {
        long originalNummer = 12;
        long nummer = originalNummer;
        int largestPrimeFactor = 0;
        if (nummer % 2 == 0) {
            System.out.println(2);
            largestPrimeFactor = 2;
        }
        for (int i = 3; i <= nummer; i++) {//13
            if (nummer % i == 0) {
                System.out.println(i);
                if (largestPrimeFactor < i) {
                    largestPrimeFactor = i;
                }
                nummer /= i;//29
            }
        }

        System.out.println("Largest Prime Factor of " + originalNummer + " = " + largestPrimeFactor);//13
    }
}


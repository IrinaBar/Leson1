public class Checkdigit {
    public static void main(String[] args) {

        System.out.println(checksum("4731248257"));
    }

    public static int checksum(String code) {

        int weights[] = new int[]{8, 6, 4, 2, 3, 5, 9, 7};
        int countWeights = weights.length;
        int sum = 0;

        for (int i = 0; i < code.length(); i++) {
            int digit = Character.digit(code.charAt(i), 10);
            sum += digit * weights[i % countWeights];
        }

        int controlDigit = (sum % 11 == 10) ? 5 : sum % 11;
        return controlDigit;
    }
}










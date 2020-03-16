public class PznChecker {
    public static String pznCheckDigit(String pznDigits) {
        if (pznDigits.length() != 7) return "";
        int weights[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int countWeights = weights.length;
        int sum = 0;

        for (int i = 0; i < pznDigits.length(); i++) {
            int digit = Character.digit(pznDigits.charAt(i), 10);
            sum += digit * weights[i % countWeights];
        }

        int controlDigit = (sum % 11 == 10) ? 5 : sum % 11;
        String controldigit = Integer.toString(controlDigit);
        return pznDigits + controldigit;
    }
}





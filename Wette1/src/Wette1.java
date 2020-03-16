public class Wette1 {

        String str = "";

        public String lastTwo(){
            if (str.length() < 2)
                return str;

            int len = str.length();
            String first = str.substring(len - 1);
            String second = str.substring(len - 2, len - 1);
            if (len >= 2) {
                return str.substring(0, len - 2) + first + second;
            }
            return first;
        }

    }


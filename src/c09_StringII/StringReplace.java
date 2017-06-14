package c09_StringII;



public class StringReplace {
    public String solve(String input, String s, String t) {
        if (input == null || input.length() == 0 || input.length() < s.length()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = input.indexOf(s, start);
        while (end != -1) {
            result.append(input, start, end);
            result.append(t);
            start = end + s.length();
            end = input.indexOf(s, start);
        }
        result.append(input, start, input.length());
        return new String(result);
    }

    public static void main(String[] args) {
        StringReplace test = new StringReplace();
        System.out.println(test.solve( "docomobbomomc","omo","aa"));
    }
}





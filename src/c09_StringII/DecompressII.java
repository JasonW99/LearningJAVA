package c09_StringII;

public class DecompressII {
    public String solve(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // we need to deal with shortDecompress(a0 a1 a2) ang longDecompress(a3 a4 ... a9) separately
        int len = shortDecomp(array);
//        return new String(array);
        return longDecomp(array, len);
    }

    private int shortDecomp(char[] array) {
        int currNew = 0;
        for (int i = 1; i < array.length; i+=2) {
            int digit = array[i] - '0';
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    array[currNew++] = array[i - 1];
                }
            } else {
                array[currNew++] = array[i - 1];
                array[currNew++] = array[i];
            }
        }
        return currNew;
    }

    private String longDecomp(char[] array, int len) {
        int finalLen = len;
        for (int i = 0; i < len; i++) {
            if (array[i] - '0' > 2 && array[i] - '0' <= 9) {
                finalLen = finalLen - 2 + array[i] - '0';
            }
        }
        char[] result = new char[finalLen];
        int currOld = len - 1;
        int currNew = finalLen - 1;
        while (currOld >= 0) {
            if (array[currOld] - '0' > 2 && array[currOld] - '0' <= 9) {
                for (int i = 0; i < array[currOld] - '0'; i++) {
                    result[currNew--] = array[currOld - 1];
                }
                currOld -= 2;
            } else {
                result[currNew--] = array[currOld--];
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        DecompressII test = new DecompressII();
        System.out.println(test.solve("b2c4d2e1f3"));
    }
}

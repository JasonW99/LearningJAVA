package c11_BitOperation;

public class PowerOf2 {
    public boolean solve1(int number) {
        if (number <= 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }

    public boolean solve2(int number) {
        if (number <= 0) {
            return false;
        }
        while ((number & 1) == 0) {
            number >>>= 1;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        PowerOf2 test = new PowerOf2();
        System.out.println(test.solve1(8));
        System.out.println(test.solve2(8));
    }
}

/**
public class Solution {
    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        while (number > 1) {
            if (number % 2 == 1) {
                return false;
            }
            number /= 2;
        }
        return true;
    }
}
**/

/*
*  for the bit presentation
*  negative number is like " 1 + 31 digits of 0's or 1's "
*  -5 ==> [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1]
*  positive number is like " 0 + 31 digits of 0's or 1's "
*  5 ==>  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1]
*
*  note that -1 ==> [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
*  THEN (5 ^ -1) + 1 = -5
*  AND (-5 - 1) ^ -1 = 5
*
*  for the bit-operation
*  ">>"     will shift the original bits to right, and fill up the left side with its original signs(0 or 1)
*           8 >> 1   :  [0,0,0,...,1,0,0,0]   ==>    [0,0,0,...,0,1,0,0]      FROM 8 to 4
*           8 >> 2   :  [0,0,0,...,1,0,0,0]   ==>    [0,0,0,...,0,0,1,0]      FROM 8 to 2
*           -8 >> 1  :  [1,1,1,...,1,1,0,0,0] ==>    [1,1,1,...,1,1,1,0,0]    FROM -8 to -4
*           -8 >> 2  :  [1,1,1,...,1,1,0,0,0] ==>    [1,1,1,...,1,1,1,1,0]    FROM -8 to -2
*
*  ">>>"    will shift the original bits to right, and always fill up the left side with 0's
*  suppose      x = [1,0,0,1,0,1,....]      and       y = [0,0,1,1,0,1,....]
*  then    x >> 1 = [1,1,0,0,1,0,1,....]         y >> 1 = [0,0,0,1,1,0,1,....]
*         x >>> 1 = [0,1,0,0,1,0,1,....]        y >>> 1 = [0,0,0,1,1,0,1,....]
*          x >> 2 = [1,1,1,0,0,1,0,1,....]       y >> 2 = [0,0,0,0,1,1,0,1,....]
*         x >>> 2 = [0,0,1,0,0,1,0,1,....]      y >>> 2 = [0,0,0,0,1,1,0,1,....]
*
*
*
*
* */
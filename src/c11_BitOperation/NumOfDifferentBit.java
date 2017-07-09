package c11_BitOperation;

public class NumOfDifferentBit {
   public int solve (int a, int b) {
      int diff = a ^ b;
      int count = 0;
      while (diff != 0) {
         count += (diff & 1);
         diff >>>= 1;
      }
      return count;
   }

   public static void main(String[] args) {
      NumOfDifferentBit test = new NumOfDifferentBit();
      System.out.println(test.solve(5, 8));
   }
}

/*Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions
dictionary A is not null
dictionary.get(i) will return null if index i is out of bounds

Examples
A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
*/

/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.

/*
package c02_BinarySearch;

public class searchinunknownsize {
    public int search(Dictionary dict, int target) {
        int start = 0;
        int end = 1;
        while (dict.get(end) != null && dict.get(end) < target){
            start = end;
            end = end * 2;
        }
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(dict.get(mid) == null || dict.get(mid) > target){
                end = mid - 1;
            }else if (dict.get(mid) == target) {
                return mid;
            }else {
                start = mid +1;
            }
        }
        return -1;
    }

}
*/
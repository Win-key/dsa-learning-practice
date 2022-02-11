package archived.Algo;

/**
 * @author Venkatesh Rajendran
 */

public class BinarySearch {

    public static void main(String[] args) {
        int index = search(10,4,5,6,7,8,9,10);
        System.out.println("Recursive - Element found at index " + index);
        index = searchIterative(6,4,5,6,7,8,9,10);
        System.out.println("Iterative - Element found at index " + index);
    }

    public static int search(int num, int ... ar) {
        return search(ar, 0, ar.length-1, num);
    }

    public static int search(int[] ar, int start, int end, int num) {
        if(start > end) {
            throw new RuntimeException("Element not found!!!");
        }
        int mid = (start+end)/2;
        if(ar[mid] == num){
            return mid;
        } else if(ar[mid] < num){
            return search(ar, mid+1 , end, num);
        } else {
            return search(ar, start, mid - 1, num);
        }
    }

    public static int searchIterative(int num, int ... ar) {
        int start = 0, end = ar.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if(ar[mid] == num){
                return mid;
            }else if(ar[mid] < num){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        throw new RuntimeException("Element not found!!!");
    }
}

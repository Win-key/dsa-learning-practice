package archived.Algo;

public class JumpSearch {

    public static void main(String[] args) {
        int[] ar = {1,2,3,55,66,77,88,99,111};
        int idx = search(ar, 88);
        System.out.println(idx > -1 ? "Element found at "+ idx : "Element not found");
    }
    
    public static int search(int[] ar, int search) {
        int m = (int) Math.sqrt((double)ar.length);
        
        System.out.println("Block size is "+ m);
        
        int a = 0, b = m;
        while (b < ar.length) {
            if(ar[a] <= search && search < ar[b]) {
                break;
            }
            a = b;
            b += m;
        }
        
        for (int i = a; i <= b && i < ar.length; i++) {
            if(ar[i] == search) {
                return i;
            }
        }
        
        return -1;
    }
    
}

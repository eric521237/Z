package cn.z.jiutian.algorithm;

/*
 * XOR
 */
public class XORDemo {

    

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 4, 5};
        int x = 0;
        
        for (int n : arr) {
            x ^= n;
        }
        
        System.out.println(x);  // 2

    }
}

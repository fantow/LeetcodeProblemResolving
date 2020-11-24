package Hot100;

public class P_461 {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int distance = hammingDistance(x, y);

        System.out.println(distance);
    }

    public static int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;

        while(temp != 0){
            if((temp & 0x01) == 1){
                count++;
            }
            temp >>>= 1;
        }

        return count;
    }
}

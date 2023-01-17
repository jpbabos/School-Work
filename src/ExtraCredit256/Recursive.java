package ExtraCredit256;

public class Recursive {
    public static int findA_n(int n ,int a_0) {
        if (n==1) {
            return 4 * a_0 - 3;
        }
        else {
            return 4 * findA_n(n-1,a_0) - 3;
        }
    }
    public static void main(String[] args) {
        System.out.println("Answer of findA_n(5,0) :"+findA_n(5,0));
        System.out.println("\nAnswer of findA_n(5,1) :"+findA_n(5,1));
        System.out.println("\nAnswer of findA_n(5,2) :"+findA_n(5,2));
    }
}

package ExtraCredit256;

public class PascalTriangle {
    public int factorial(int n) {
        if(n==0||n==1)
            return 1;
        return n*factorial(n-1);
    }
    public int nChooseR(int n,int r) {
        return factorial(n)/(factorial (r)*factorial(n-r));
    }
    String displayPascal(int row) {
        String result="";
        for(int i=0;i<row;i++) {
            result+=nChooseR(row-1,i);

            result+=" ";
        }
        return result;
    }
    public static void main(String[] args){
        PascalTriangle obj=new PascalTriangle();
        System.out.println(obj.displayPascal(12));

    }
}

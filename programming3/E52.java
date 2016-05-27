import java.util.Scanner;

public class E52{
  public static void main(String[] args){
    System.out.print("何の階乗？  ");
    Scanner scan = new Scanner(System.in);
    int x = Integer.parseInt(scan.next());
    System.out.printf("%d! = %d\n", x, kaijo(x));
  }
  
  public static int kaijo(int x){
    if(x == 0) return 1;
    return x * ( kaijo( x - 1 ) );
  }
}
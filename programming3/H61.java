import java.util.Scanner;
import java.util.Arrays;

public class H61{
  public static void sort(int[] a, int i, int j){
    if(i >= j)
      return;
    int key = a[i], temp;
    for(; i < j; i++){
      if(a[i] >= key){
        for(; i < j; j--){
          if(a[j] < key){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            System.out.println(Arrays.toString(a));
            j--;
            break;
          }
        }
      }
    }
    System.out.printf("i=%d, j=%d\n", i, j);
    
    sort(a, 0, i);
    sort(a, i + 1, j);
  }
  
  public static void main(String[] args){
    int[] vals = new int[10];
    System.out.printf("%d個の整数を入力\n>>>", vals.length);
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < vals.length; i++)
      vals[i] = Integer.parseInt(scan.next());
      sort(vals, 0, vals.length - 1);
    System.out.printf("%s\n", Arrays.toString(vals));
  }
}
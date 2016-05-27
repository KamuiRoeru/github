import java.util.Scanner;
//文字列判定するとき、==だとオブジェクト(入れ物)同士が等しいか判別するので、文字列を比較するときは"定数equals(変数)を使う
public class H52{
  public static void main(String[] args){
    while(true){
      System.out.printf("\n何年？(終了するときはq)：\n>>");
      Scanner scan = new Scanner(System.in);
      String s = scan.next();
      if("q".equals(s)){
        break;
      }
      int x = Integer.parseInt(s);
      if(x % 4 == 0){
        if(x % 100 != 0 || x % 400 == 0){
          System.out.printf("%d年はうるう年です。\n", x);
          continue;
        }
      }
      
      System.out.printf("%d年はうるう年ではありません。\n", x);
    }
  }
}
//プログラムの中で長さと角の個数を指定する方式

import java.util.Scanner;//Scanner使うための宣言

public class H41{
  public static void main(String[] args){
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle();
    f.add(m);
    System.out.print("整数\"一辺の長さ\" \"角の数\"で入力：");
    Scanner scan = new Scanner(System.in); //空白区切りで文字列読み取り
    int distance = Integer.parseInt(scan.next()); //空白区切りで順次排出
    int n = Integer.parseInt(scan.next()); 
    for(int i = 0; i < n; i++){
      m.fd(distance);
      m.rt(360/n);
    }
  }
}
//コマンドライン引数で一辺の長さと角の個数を指定

import java.awt.Color;

public class H41{
  public static void main(String[] args){
    
    //引数がなかった場合のエラー処理
    if(args.length < 2){
      System.out.println("エラー\nH41.java \"一辺の長さ\" \"角の個数\"で引数指定してください");
      System.exit(1);
    }
    
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle(100,200,0);
    Color colors[] = new Color[4]; //color型の配列を作成
    int j = 0;                     //colorsの引数遷移用
    colors[0] = Color.black;
    colors[1] = Color.red;
    colors[2] = Color.blue;
    colors[3] = Color.yellow;
    f.add(m);
    
    int distance = Integer.parseInt(args[0]); //Stringからintへの型変換
    int n = Integer.parseInt(args[1]); 
    for(int i = 0; i < n; i++){
      if(j == 4){ //黄→黒への引数リセット
        j = 0;
      }
      m.setColor(colors[j++]);
      m.fd(distance);
      m.rt(360/n);
    }
    System.out.println("一辺" + distance + "で正" + n + "角形を描きました。");
  }
}
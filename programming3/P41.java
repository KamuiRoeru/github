//星形を書くプログラム

public class P41{
  public static void main(String[] args){
    
    //引数がなかった場合のエラー処理
    if(args.length < 2){
      System.out.println("エラー\nH41.java \"一辺の長さ\" \"角の個数\" \"角の角度\"で引数指定してください");
      System.exit(1);
    }
    
    TurtleFrame f;
    f = new TurtleFrame();
    Turtle m;
    m = new Turtle(100,100,90);
    f.add(m);
    
    int n = Integer.parseInt(args[1]), l = Integer.parseInt(args[0]), theta = Integer.parseInt(args[2]);
    for(int i=0; i<n; i++){
      m.fd(l);
      m.rt(theta);
    }
  }
}

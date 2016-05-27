import java.util.Formatter;   //桁数指定出力するため

public class H43{
  public static void main(String[] args){
    System.out.println("  x  |   e^x");
    for(int j = 0; j < 15; j++){
      System.out.print("-");
    }
      System.out.println();
      
    for(double x = 0.0; x <= 2.0; x += 0.2){
      System.out.println(String.format(" %.1f | %f", x ,beki_keisan(x)));
    }
    System.exit(0);
  }
  
  public static double beki_keisan(double x){
    double y = 1;
    for(int n = 1; ;n++){   //無限ループ（無限項計算）
      double bunbo = 1;
      for(int i = n; i > 0; i--){   //分母(n!)を計算
        bunbo *= i;
      }
      double kou = Math.pow(x, n) / bunbo;   //何回も書くのが面倒なので変数作成
      if(kou < Math.pow(10, -10)){    //kou < 1*10^-10の時その項を無視して返す
        return y;
      }
      y += kou;
    }
  }
}
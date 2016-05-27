public class H42{
  public static void main(String[] args){
    int i = 10000;
    double x;
    while(i-- > 0){
      x = Math.random();
      double y = Math.pow((Math.sin(x) + Math.log(x)), 2);    //powは累乗計算
      if(y < 0.00001){
        System.out.println("sinx + logxの近似解=" + x);
        System.exit(0);   //正常に終了
      }
    }
    
    System.out.println("近似解は得られなかった");    //残念でした
  }
}
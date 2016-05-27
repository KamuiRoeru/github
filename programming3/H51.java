import java.util.Scanner;

public class H51{
  public static void main(String[] args){
    while(true){
      System.out.printf("\nじゃんけん");
      System.out.printf("(グー:0, チョキ:1, パー：2いずれかを選択)\n>>");
      Scanner scan = new Scanner(System.in);
      double h = Math.random();
      int hand = 0;
      String sign = "";
      if(h*3 < 1){
        hand = 0;
        sign = "グー";
      }else if(h*3 >= 1 && h*3 < 2){
          hand = 1;
          sign = "チョキ";
      }else if(h*3 >= 2){
          hand = 2;
          sign = "パー";
      }
      String str = scan.next();
      if("q".equals(str)) break;    //qで終了
      int m = Integer.parseInt(str);
      String m_s = "";
      switch(m){
        case 0:
          m_s = "グー"; break;
        case 1:
          m_s = "チョキ"; break;
        case 2:
          m_s = "パー"; break;
        default:
          System.out.println("0~2を入力してください。"); continue;
      }
      int s = Math.abs(m - hand);
      String res = "";
      switch(s){
        case 0:
          res = "あいこ"; break;
        case 1:
          res = "勝ち"; break;
        case 2:
          res = "負け"; break;
      }
      System.out.printf("自分の手：%s, 相手の手:%s\n%s!!",m_s, sign, res);
    }
  }
}
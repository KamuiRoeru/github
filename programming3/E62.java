import java.util.Scanner;
import java.util.Date;

public class E62{
  public static void main(String[] args){
    int gantan = 5;
    int[] mon = {0, 31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30 , 31};
    System.out.printf("今日に日付を月 日で指定\n>>>");
    Scanner scan = new Scanner(System.in);
    int m = Integer.parseInt(scan.next());
    int d = Integer.parseInt(scan.next());
    System.out.printf("今日は%d月%d日\n", m, d);
    String[] week = {"日", "月", "火", "水", "木", "金", "土"};
    
    int days = 0;
    for(int i = 1; i < m; i++)
      days += mon[i];
    days += d;
    
    int youbi = days;
    youbi = (youbi % 7) + gantan;
    if(youbi > 6)
      youbi -= 7;  
    System.out.printf("今日は今年の元旦から%d日目で、%s曜日です。", days, week[youbi]);
  }
}
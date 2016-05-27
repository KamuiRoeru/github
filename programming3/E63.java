import java.awt.Color;

public class E63{
  public static void main(String[] args){
    int[] size = {20, 10, 30, 40};
    int[] m = {5, 7, 4};
    Color[] c = {Color.red, Color.blue, Color.cyan, Color.green, Color.magenta};
    
    TurtleFrame f = new TurtleFrame(600, 300);
    Turtle[] hm = new Turtle[10];
    for(int i = 0; i < 10; i++){
      hm[i] = new Turtle(i * 50 + 25, 150, 0);
      f.add(hm[i]);
    }
    for(int i = 0; i < 10; i++){
      int l = m[i % m.length];
      for(int j = 0; j < l; j++){
        hm[i].setColor(c[i % c.length]);
        hm[i].fd(size[i % size.length]);
        hm[i].rt(360/l);
      }
    }
  }
}
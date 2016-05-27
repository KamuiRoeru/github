import java.awt.Color;
public class HHH31{
  public static int a;
  public static int d;
  public static TurtleFrame f;
  public static void main(String[] args){
    H31.d = 50;
    H31.a = 40;
    H31.f = new TurtleFrame(800, 800);
    Turtle m = new Turtle(400,400,0);
    f.add(m);
    m.fd(d);
    for(Turtle t: bunki(m, 3)){
      for(Turtle t1: bunki(t, 2)){
        bunki(t1, 1);
      }
    }
  }
  
  public static Turtle[] bunki(Turtle m0, int x){
    Turtle ml = m0.clone();
    f.add(ml);
    ml.lt(a*x);
    ml.fd(d);
    Turtle mr = m0.clone();
    f.add(mr);
    mr.rt(a*x);
    mr.fd(d);
    if(x == 1){
      m0.tcolor = new Color(0,255,255);
      m0.tscale *= 2;
    }
    m0.fd(d);
    
    Turtle ta[] = new Turtle[3];
    ta[0] = ml;
    ta[1] = m0;
    ta[2] = mr;
    
    return ta;
  }
}
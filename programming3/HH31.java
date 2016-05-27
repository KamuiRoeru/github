public class HH31{
  public static int a;
  public static int d;
  public static TurtleFrame f;
  public static void main(String[] args){
    HH31.f = new TurtleFrame(800, 800);
    HH31.a = 15;
    HH31.d = 100;
    Turtle m = new Turtle(400,600,0);
    f.add(m);
    m.fd(d);
    bunki(m, 3, 3, 3);
//    m.tcolor = new java.awt.Color(0,255,255);
//    m.tscale *= 2;
//    m.fd(0);     
  }
  
  public static int bunki(Turtle m0, int l, int s, int r){
    if(l == 0 || s == 0 || r == 0) return 0;
    Turtle ml = m0.clone();
    f.add(ml);
    ml.lt(a*l);
    ml.fd(d);
    bunki(ml, --l, s, r);
    Turtle mr = m0.clone();  
    f.add(mr);
    mr.rt(a*r);
    mr.fd(d);
    bunki(mr, l, s, --r);
    Turtle ms = m0.clone();
    f.add(ms);
    if(s == 1){
      ms.tcolor = new java.awt.Color(0,255,255);
      ms.tscale *= 2;
    }
    ms.fd(d);
    bunki(ms, l, --s, r);
    
    return 0;
  }
}
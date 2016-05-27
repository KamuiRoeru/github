public class E33{
  public static void main(String[] args){
    int d = 50, a = 45;
    TurtleFrame f;
    f = new TurtleFrame();
    Turtle m = new Turtle(200,300,0);
    f.add(m);
    m.fd(d);
    Turtle m1 = m.clone();
    f.add(m1);
    m1.lt(a);
    m1.fd(d);
    Turtle m2 = m.clone();
    f.add(m2);
    m2.rt(a);
    m2.fd(d);
    m.tscale *= 2;    
    m.fd(d);
    Turtle m3 = m2.clone();
    f.add(m3);
    m3.lt(a);
    m3.fd(d);
    Turtle m4 = m2.clone();
    f.add(m4);
    m4.rt(a);
    m4.fd(d);
    m2.tscale *= 2;
    m2.fd(d);
  }
}
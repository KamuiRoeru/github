public class E42{
  public static void main(String[] args){
    int d = 100, x, y, a;
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle(200,300,0);
    f.add(m);
    m.fd(d);
    Turtle.withTurtleAll = false; //【 1 】
    x = m.getX();
    y = m.getY();
    a = m.getAngle() - 45;
    Turtle m1 = new Turtle(x, y, a);
    f.add(m1);
    m1.fd(d);
    Turtle m2 = m.clone();
    f.add(m2);
    m.rt(45);
    m.fd(d);
    m2.tcolor = new java.awt.Color(0,255,255);
    m2.tscale *= 4;
    m2.fd(d);
    System.out.println(m1.getX() + "," + m1.getY());  //【 2 】
    System.out.println(m.getX() + "," + m.getY());//【 3 】
    System.out.println(m2.getX() + "," + m2.getY());//【 4 】
  }
}
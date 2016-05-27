public class T21{
  public static void main(String[] args){
    TurtleFrame f;
    f = new TurtleFrame();
    Turtle m = new Turtle();
    Turtle m1 = new Turtle();
    f.add(m);
    f.add(m1);
    m.fd(100);
    m.rt(90);
    m.fd(150);
    m1.rt(90);
    m1.fd(100);
  }
}
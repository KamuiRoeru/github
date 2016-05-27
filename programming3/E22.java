//6角形を書かせるプログラム
public class E22{
  public static void main(String[] args){
    TurtleFrame f;
    f = new TurtleFrame();
    Turtle m;
    m = new Turtle();
    f.add(m);
    
    for(int i=0; i<6; i++){
      m.fd(60);
      m.rt(60);
    }
  }
}

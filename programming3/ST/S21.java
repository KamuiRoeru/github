//10角形を書かせるプログラム

public class S21{
  public static void main(String[] args){
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle();
    f.add(m);
    
    for(int i=0; i<10; i++){
      m.fd(60);
      m.rt(36);
    }
    m.moveTo(0,0);
  }
}
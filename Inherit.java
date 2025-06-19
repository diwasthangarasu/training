public interface A {
    void teach();  
}
class Teaching2 implements A {
    public void teach() {
        System.out.println("B is Teaching");
    }
}

class Teaching1 implements A {
    public void teach() {
        System.out.println("A is Teaching");
    }
}
public class Inherit {
  public static void main(String[] args) {
    Teaching1 obj = new Teaching1();     
    Teaching2 obj2 = new Teaching2();

    obj.teach(); 
    obj2.teach(); 
  }
}

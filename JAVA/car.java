class car {
    private String color;
    public int nooftyer;
    
    public car(String color, int nooftyer) {
        this.color = color;
        this.nooftyer = nooftyer;
    }

}
class BMW extends car{
    public BMW(String color, int nooftyer) {
        super(color, nooftyer);
    }
}
public class car{
    public static void main(String[] args) {
        BMW b=new BMW("red", 10);
        b.show();
    }
}



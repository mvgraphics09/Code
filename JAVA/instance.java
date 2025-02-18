public class instance {
            String name;
            static int count;
            public static void main(String[] args) {
                instance ob = new instance();
                ob.count++;
                System.out.println("Count in main"+instance.count);
                ob.add_count();
            }
            public void add_count(){
                instance ob = new instance();
                ob.count=ob.count+2;
                System.out.println("Count in add_count"+ob.count);
            }
}
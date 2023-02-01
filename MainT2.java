public class MainT2 {
    public static void main(String[] args) {
        HiloHijoT2 ht2=new HiloHijoT2();
        ht2.setNombre("Miguelon");
        ht2.setTime(500);

        Thread t1=new Thread(ht2);
        t1.start();

        HiloHijoT2 ht3=new HiloHijoT2();
        ht3.setNombre("Juanito");
        ht3.setTime(250);

        Thread t2=new Thread(ht3);
        t2.start();
    }
}
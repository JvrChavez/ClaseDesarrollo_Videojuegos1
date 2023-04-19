public class Main{
    public static void main(String[] args){
        Thread t=Thread.currentThread();
        System.out.println("Hilo Actual:"+t);
        System.out.println("Hilo Actual 2:"+Thread.currentThread());
        
        HiloHijo1 h1=new HiloHijo1();
        //h1.name="H1";
        h1.setNombre("H1");
        h1.setTime(500);
        h1.start();
        
        HiloHijo1 h2=new HiloHijo1();
        //h2.name="H2";
        h2.setNombre("H2");
        h2.setTime(1000);
        h2.start();
        /* 
        try {
            System.out.print("Esperando a finalizar");
            /*Thread.sleep(1000);  
            System.out.print(".");
            Thread.sleep(1000);  
            System.out.print(".");
            Thread.sleep(1000);  
            System.out.print(".");
            for (int i = 0; i <3; i++) {
                Thread.sleep(1000);  
                System.out.print(".");
            }
        } catch (Exception e) {            
        }*/
    }
}
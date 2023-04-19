public class HiloHijo1 extends Thread{
    private String name;
    private int time;
    /*public HiloHijo1(String name){
        this.name=name;
    }*/
    public void run(){
        System.out.println("Hilo ["+name+"]: "+Thread.currentThread());

        for (int i = 1; i <=10; i++) {
            try {
                System.out.println("Hilo ["+name+"]: "+i);
                Thread.sleep(time);
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        } //end for
    }//end run
    public void setNombre(String name){
        this.name=name;
    }
    public void setTime(Integer time){
        this.time=time;
    }
}
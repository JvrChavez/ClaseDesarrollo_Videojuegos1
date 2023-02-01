public class HiloHijoT2 implements Runnable {
    private String name;
    private int time;
    public void run(){
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

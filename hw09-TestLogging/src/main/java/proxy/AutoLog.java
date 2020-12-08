package proxy;


public class AutoLog implements AutoLogInterface{

    public void calculation(int param) {
        System.out.println(param);
    }


    public void calculation(int param1, int param2) {
        System.out.println(param1+","+param2);
    }


    public void calculation(int param1, int param2, String param) {
        System.out.println(param1+","+param2+", "+param);
    }

    public void calculation(){
        System.out.println("nothing to calculate");
    }
}

package proxy;


public class AutoLog implements AutoLogInterface{
    @Log
    public void calculation(int param) {
        System.out.println(param);
    }

    @Log
    public void calculation(int param1, int param2) {
        System.out.println(param1+","+param2);
    }

    @Log
    public void calculation(int param1, int param2, String param) {
        System.out.println(param1+","+param2+", "+param);
    }

}

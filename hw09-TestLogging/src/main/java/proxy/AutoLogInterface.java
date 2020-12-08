package proxy;

public interface AutoLogInterface {

     void calculation();

     @Log
     void calculation(int param);

     @Log
     void calculation(int param1, int param2);

     @Log
     void calculation(int param1, int param2, String param3);
}

import java.util.ArrayList;
import java.util.List;

public class ErrorClass {

    public static void main(String[] args) throws InterruptedException {
        List<Long> list = new ArrayList<>();
            long i = 1000;
            while (i < 100_000_000) {
                list.add(i);
                i++;
               if (i%50==0)   Thread.sleep(1);
                if (i%500_000==0) {
                   long j = i;
                    while (j < list.size()/2) {
                        list.remove(j);
                        j++;
                    }
                }
            }
    }
}

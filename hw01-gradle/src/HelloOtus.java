import com.google.common.base.CaseFormat;

public class HelloOtus {
    public static void main(String... args) {
        String str = "it's_coronatime";
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str));
    }
}

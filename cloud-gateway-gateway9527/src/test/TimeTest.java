import java.time.ZonedDateTime;

/**
 * @author dingwenbin
 * @create 2021-01-26
 * 使用java8 的时间
 */
public class TimeTest {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        //2021-01-26T22:26:21.996+08:00[Asia/Shanghai]
        System.out.println("now = " + now);

    }
}

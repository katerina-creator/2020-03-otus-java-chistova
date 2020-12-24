import org.junit.Before;
import org.junit.jupiter.api.Test;
import ru.otus.listener.homework.DateTimeProvider;
import ru.otus.model.Message;
import ru.otus.processor.homework.ProcessorError;
import java.time.LocalDateTime;

public class ProcessorErrorTest {
    private ProcessorError processorError;

    @Before
    public void setUp() {
        processorError = new ProcessorError();
    }

    @Test
    public void process()  {
        DateTimeProvider dateTime = LocalDateTime::now;
        var message = new Message.Builder(1L)
                .build();
        if (dateTime.getDate().getSecond()%2!=0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            processorError.process(message);
    }
}
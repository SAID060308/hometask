package vazifa4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long step = 1_000_000;
        for (int i = 0; i < 3; i++) {
            final int k = i+1;
            final long start = i*step+1;
            final long end = (i+1)*step;
            executorService.submit(()->{
               String URL = "files3/a" + k + ".txt";
               Path path = Path.of(URL);
               long sum = 0;
                for (long j = start; j < end; j++) {
                    sum+=j;
                }
                ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
                byteBuffer.putLong(sum);
                try {
                    Files.write(path,byteBuffer.array(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("Filelar yaratildi");
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            long value = 0;
            String URL = "files3/a" + (i+1) + ".txt";
            byte[] bytes = Files.readAllBytes(Path.of(URL));

            if (bytes.length >= Long.BYTES) {
                ByteBuffer buffer = ByteBuffer.wrap(bytes);
                value = buffer.getLong();
            }
            sum += value;
        }
        System.out.println("Natija:" + sum);
    }

}

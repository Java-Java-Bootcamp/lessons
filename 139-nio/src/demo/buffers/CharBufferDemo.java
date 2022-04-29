package demo.buffers;

import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;

@Slf4j
public class CharBufferDemo {
    private static final String[] quotes =
            {
                    "1. Что разум человека может постигнуть и во что он может поверить, того он способен достичь",
                    "2. Стремитесь не к успеху, а к ценностям, которые он дает",
                    "3. Своим успехом я обязана тому, что никогда не оправдывалась и не принимала оправданий от других.",
                    "4. За свою карьеру я пропустил более 9000 бросков, проиграл почти 300 игр. 26 раз мне доверяли сделать финальный победный бросок, и я промахивался. Я терпел поражения снова, и снова, и снова. И именно поэтому я добился успеха.",
                    "5. Сложнее всего начать действовать, все остальное зависит только от упорства.",
                    "6. Надо любить жизнь больше, чем смысл жизни.",
                    "7. Жизнь - это то, что с тобой происходит, пока ты строишь планы.",
                    "8. Логика может привести Вас от пункта А к пункту Б, а воображение — куда угодно.",
                    "9. Через 20 лет вы будете больше разочарованы теми вещами, которые вы не делали, чем теми, которые вы сделали. Так отчальте от тихой пристани. Почувствуйте попутный ветер в вашем парусе. Двигайтесь вперед, действуйте, открывайте!",
                    "10. Начинать всегда стоит с того, что сеет сомнения.",
                    "11. Настоящая ответственность бывает только личной.",
                    "12. Неосмысленная жизнь не стоит того, чтобы жить.",
            };

    public static void main(String[] args) {

        CharBuffer buffer = CharBuffer.allocate(250);

        for (String quote : quotes) {
            // Fill the buffer.
            for (int j = 0; j < Math.min(quote.length(), buffer.capacity()); j++) {
                buffer.put(quote.charAt(j));
            }

            // Flip the buffer so that its contents can be read.
            buffer.flip();

            StringBuilder quoteBuilder = new StringBuilder();
            // Drain the buffer.
            while (buffer.hasRemaining()) {
                quoteBuilder.append(buffer.get());
            }


            // Empty the buffer to prevent BufferOverflowException.
            buffer.clear();
            log.info("{}", quoteBuilder);
        }
    }
}
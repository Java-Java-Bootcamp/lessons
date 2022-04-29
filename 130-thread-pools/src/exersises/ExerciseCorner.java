package exersises;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

public class ExerciseCorner {
    // 1. Создаем ExecutorsService
    // 2. Кастомизируем ThreadFactory - используем свое имя треда + порядковый номер треда
    // 3. Остановить работу в момент, когда (на выбор)
    //      3.2 Все задачи выполнятся
    //      3.1 Не дожидаться выполнения задач
    // 4. Добавить еще задач (execute)
    // 5. Сходить в доку и посмотреть, что такое
    //      5.1 isShutdown(): https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html#isShutdown--
    //      5.2 isTerminated(): https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html#isTerminated--
    public static void main(String[] args) {
        // здесь должен быть кот
    }
}

@Slf4j
class Worker implements Runnable {
    private static String[] works = {"create butter", "milking a cow", "plant potatoes"};

    @Override
    public void run() {
        int idx = new Random().nextInt(works.length);
        log.info(works[idx]);
    }
}
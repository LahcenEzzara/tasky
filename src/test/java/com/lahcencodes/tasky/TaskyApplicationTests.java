package com.lahcencodes.tasky;

import com.lahcencodes.tasky.entities.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskyApplicationTests {

    @Test
    void contextLoads() {
    }

    // Minimal test coverage
    @Test
    void testDoNothing() {
        Task task = new Task();
        task.doNothing();
    }
}
package com.itq.testproblem;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ItqTestProblemApplicationTests {

    @Test
    @Tag("unit")
    void unitTest() {
        assertTrue(true);
    }

    @Test
    @Tag("integration")
    void integrationTest() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

}

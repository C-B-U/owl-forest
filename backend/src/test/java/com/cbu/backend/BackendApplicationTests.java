package com.cbu.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
class BackendApplicationTests {

    // @Test
    // void contextLoads() {}
}

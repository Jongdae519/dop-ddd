package com.example.modularmonolith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ModularMonolithApplicationTests {

    @Test
    void contextLoads() {
        var am = ApplicationModules.of(ModularMonolithApplication.class);
        am.verify(); // is modular!

        System.out.println(am);

        new Documenter(am).writeDocumentation();
    }

}

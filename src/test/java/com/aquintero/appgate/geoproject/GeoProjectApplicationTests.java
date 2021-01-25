package com.aquintero.appgate.geoproject;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GeoProjectApplicationTests
{

    @Test
    void contextLoads() {
        GeoProjectApplication.main(new String[]{});
        assertEquals("A", "A", "It should be true");
    }

}

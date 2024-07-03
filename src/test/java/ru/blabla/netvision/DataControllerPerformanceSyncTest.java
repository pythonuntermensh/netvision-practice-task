package ru.blabla.netvision;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.web.servlet.MockMvc;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerPerformanceSyncTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void dataControllerStatsTest_syncPerformanceTest() throws Exception {
        LocalTime start = LocalTime.now();
        for (int i = 0; i < 100; i++) {
            mockMvc.perform(post("/data/stats")
                    .content(resourceLoader.getResource("classpath:stats.json").getContentAsByteArray())
                    .contentType("application/json")
            ).andExpect(status().isOk());
        }
        System.out.println(MILLIS.between(start, LocalTime.now()));
    }

    @Test
    public void dataControllerDetectorsTest_syncPerformanceTest() throws Exception {
        LocalTime start = LocalTime.now();
        for (int i = 0; i < 100; i++) {
            mockMvc.perform(post("/data/detectors")
                    .content(resourceLoader.getResource("classpath:detectors.json").getContentAsByteArray())
                    .contentType("application/json")
            ).andExpect(status().isOk());
        }
        System.out.println(MILLIS.between(start, LocalTime.now()));
    }
}

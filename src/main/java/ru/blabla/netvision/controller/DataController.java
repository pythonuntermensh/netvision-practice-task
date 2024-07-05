package ru.blabla.netvision.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.blabla.netvision.dto.BorderStatisticsRequest;
import ru.blabla.netvision.dto.TrafficHardwareDetectorRequest;
import ru.blabla.netvision.service.DataService;

@RestController
@Slf4j
@RequestMapping("/push/exchange")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/passages_statistic")
    public ResponseEntity<?> sendBorderStatisticsData(@Valid @RequestBody BorderStatisticsRequest borderStatisticsRequest) {
        log.info("Stats request");
        dataService.sendDataToStatistics(borderStatisticsRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/passages")
    public ResponseEntity<?> sendTrafficHardwareDetectorData(@Valid @RequestBody TrafficHardwareDetectorRequest trafficHardwareDetectorRequest) {
        log.info("Detectors request");
        dataService.sendDataToDetectors(trafficHardwareDetectorRequest);
        return ResponseEntity.ok().build();
    }
}
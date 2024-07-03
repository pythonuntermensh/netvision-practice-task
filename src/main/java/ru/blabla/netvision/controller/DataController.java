package ru.blabla.netvision.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.blabla.netvision.dto.BorderStatisticsRequest;
import ru.blabla.netvision.dto.TrafficHardwareDetectorRequest;
import ru.blabla.netvision.service.DataService;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/stats")
    public ResponseEntity<?> sendStatsData(@Valid @RequestBody BorderStatisticsRequest borderStatisticsRequest) {
        dataService.sendDataToStatistics(borderStatisticsRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/detectors")
    public ResponseEntity<?> sendDetectorsData(@Valid @RequestBody TrafficHardwareDetectorRequest trafficHardwareDetectorRequest) {
        dataService.sendDataToDetectors(trafficHardwareDetectorRequest);
        return ResponseEntity.ok().build();
    }
}
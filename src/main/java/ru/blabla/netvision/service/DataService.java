package ru.blabla.netvision.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.blabla.netvision.dto.BorderStatisticsRequest;
import ru.blabla.netvision.dto.TrafficHardwareDetectorRequest;

@Service
public class DataService {

    @Value("${kafka.topic-name-stats}")
    private String statisticsTopicName;

    @Value("${kafka.topic-name-detectors}")
    private String detectorsTopicName;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, TrafficHardwareDetectorRequest> detectorsKafkaTemplate;
    private final KafkaTemplate<String, BorderStatisticsRequest> statsKafkaTemplate;

    @Autowired
    public DataService(ObjectMapper objectMapper, KafkaTemplate<String, TrafficHardwareDetectorRequest> detectorsKafkaTemplate, KafkaTemplate<String, BorderStatisticsRequest> statsKafkaTemplate) {
        this.objectMapper = objectMapper;
        this.detectorsKafkaTemplate = detectorsKafkaTemplate;
        this.statsKafkaTemplate = statsKafkaTemplate;
    }

    @SneakyThrows
    public void sendDataToStatistics(BorderStatisticsRequest dataRequest) {
        statsKafkaTemplate.send(statisticsTopicName, dataRequest);
    }

    @SneakyThrows
    public void sendDataToDetectors(TrafficHardwareDetectorRequest dataRequest) {
        detectorsKafkaTemplate.send(detectorsTopicName, dataRequest);
    }

    //objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataRequest)
}

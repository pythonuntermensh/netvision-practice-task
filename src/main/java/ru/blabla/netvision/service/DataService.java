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

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public DataService(ObjectMapper objectMapper, KafkaTemplate<String, Object> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @SneakyThrows
    public void sendDataToStatistics(BorderStatisticsRequest dataRequest) {
        kafkaTemplate.send(statisticsTopicName, dataRequest);
    }

    @SneakyThrows
    public void sendDataToDetectors(TrafficHardwareDetectorRequest dataRequest) {
        kafkaTemplate.send(detectorsTopicName, dataRequest);
    }

    //objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataRequest)
}

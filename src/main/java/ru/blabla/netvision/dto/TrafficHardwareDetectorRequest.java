package ru.blabla.netvision.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrafficHardwareDetectorRequest {
    @NotNull
    private List<MessageData> message_data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class MessageData {
        private UUID sensor_id;
        private String name;
        private Boolean connected;
        private List<Integer> lane_direction;
        private Integer direction;
        private List<RangeData> data;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RangeData {
        private String range_end;
        private String range_start;
        private Integer range_value;
        private List<Lane> lanes;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Lane {
        private Integer lane;
        private Integer volume;
        private Integer class_0;
        private Integer class_1;
        private Integer class_2;
        private Integer class_3;
        private Integer class_4;
        private Float gap_avg;
        private Float gap_sum;
        private Float speed_avg;
        private Float headway_avg;
        private Float headway_sum;
        private Float speed85_avg;
        private String occupancy_per;
        private Float occupancy_prc;
        private Float occupancy_sum;
    }
}



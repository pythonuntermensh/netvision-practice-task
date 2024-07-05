package ru.blabla.netvision.dto.traffichardwaredetector;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.blabla.netvision.util.CustomFloatDeserializer;
import ru.blabla.netvision.util.CustomIntegerDeserializer;
import ru.blabla.netvision.util.CustomStringDeserializer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lane {
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer lane;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer volume;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer class_0;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer class_1;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer class_2;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer class_3;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer class_4;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float gap_avg;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float gap_sum;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float speed_avg;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float headway_avg;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float headway_sum;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float speed85_avg;
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String occupancy_per;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float occupancy_prc;
    @NotNull
    @JsonDeserialize(using = CustomFloatDeserializer.class)
    private Float occupancy_sum;
}

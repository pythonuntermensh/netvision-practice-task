package ru.blabla.netvision.dto.traffichardwaredetector;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.blabla.netvision.util.CustomBooleanDeserializer;
import ru.blabla.netvision.util.CustomIntegerDeserializer;
import ru.blabla.netvision.util.CustomStringDeserializer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageData {
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String sensor_id;
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String name;
    @NotNull
    @JsonDeserialize(using = CustomBooleanDeserializer.class)
    private Boolean connected;
    @NotNull
    private List<Integer> lane_direction;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer direction;
    @NotNull
    @NotEmpty
    @Valid
    private List<@NotNull RangeData> data;
}
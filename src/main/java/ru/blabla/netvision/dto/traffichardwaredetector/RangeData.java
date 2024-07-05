package ru.blabla.netvision.dto.traffichardwaredetector;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.blabla.netvision.util.CustomIntegerDeserializer;
import ru.blabla.netvision.util.CustomStringDeserializer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RangeData {
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String range_end;
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String range_start;
    @NotNull
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer range_value;
    @NotNull
    @NotEmpty
    @Valid
    private List<@NotNull Lane> lanes;
}
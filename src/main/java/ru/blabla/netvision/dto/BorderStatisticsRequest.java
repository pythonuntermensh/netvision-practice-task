package ru.blabla.netvision.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.blabla.netvision.dto.borderstatistics.Data;
import ru.blabla.netvision.util.CustomStringDeserializer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorderStatisticsRequest {
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String id_border;
    @NotNull
    @NotEmpty
    @Valid
    private List<@NotNull Data> data;
}
package ru.blabla.netvision.dto.borderstatistics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.blabla.netvision.util.CustomStringDeserializer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String id_car;
    @NotNull
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private String time;
}
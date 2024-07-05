package ru.blabla.netvision.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.blabla.netvision.dto.traffichardwaredetector.MessageData;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrafficHardwareDetectorRequest {
    @NotNull
    @NotEmpty
    @Valid
    private List<@NotNull MessageData> message_data;
}



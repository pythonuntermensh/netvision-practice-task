package ru.blabla.netvision.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorderStatisticsRequest {
    @NotNull
    private String id_border;
    @NotNull
    private List<Data> data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Data {
        private String id_car;
        private String time;
    }

}

//        {
//        "id_border": "string",
//          "data": [
//              {
//                  "id_car": "string",
//                  "time": "string"
//              }
//          ]
//        }

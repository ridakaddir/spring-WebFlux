package com.ridakaddir.backend.campaign;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("campaigns")
public class Campaign {

    @Id
    private Long id;
     private String name;
     private String description;
     private String targetAudience;
     private Long budget;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
     private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
     private LocalDateTime endDate;
}

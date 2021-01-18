package com.scheduler.schedulertask.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchedulerTaskDtoRequest {
    @Size( max = 250, message = "Name needs to have exactly 250 characters")
    private String name;
    @Size( max = 30, message = "Recurrency needs to have exactly 30 characters")
    private String recurrency;
    private String code;

}

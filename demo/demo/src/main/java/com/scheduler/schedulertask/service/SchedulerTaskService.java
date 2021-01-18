package com.scheduler.schedulertask.service;



import com.scheduler.schedulertask.api.dto.SchedulerTaskDtoRequest;
import com.scheduler.schedulertask.domain.SchedulerTask;

import java.util.List;


public interface SchedulerTaskService {

    SchedulerTask save(SchedulerTask schedulerTask);

    List<SchedulerTask> findAll();

    SchedulerTask updateSchedulerTask(SchedulerTaskDtoRequest schedulerTaskDtoRequest, Long idSchedulerTask) throws Exception;

    void delete(Long idSchedulerTask) throws Exception;
}

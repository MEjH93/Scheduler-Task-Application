package com.scheduler.schedulertask.service.impl;



import com.scheduler.schedulertask.api.dto.SchedulerTaskDtoRequest;
import com.scheduler.schedulertask.domain.SchedulerTask;
import com.scheduler.schedulertask.repository.SchedulerTaskRepository;
import com.scheduler.schedulertask.service.SchedulerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulerTaskServiceImplements implements SchedulerTaskService {

    private final SchedulerTaskRepository schedulerTaskRepository;

    @Autowired
    private ThreadPoolTaskExecutor executor;
    @Autowired
    private Worker worker;
    @Autowired
    public SchedulerTaskServiceImplements(SchedulerTaskRepository schedulerTaskRepository){
        this.schedulerTaskRepository = schedulerTaskRepository;

    }


    @Transactional
    @Override
    public SchedulerTask save(SchedulerTask schedulerTask) {

        return schedulerTaskRepository.save(schedulerTask);

    }



    @Transactional
    @Override
    public List<SchedulerTask> findAll() {
        return schedulerTaskRepository.findAll();
    }

    @Transactional
    @Override
    public SchedulerTask updateSchedulerTask(SchedulerTaskDtoRequest schedulerTaskDtoRequest, Long idSchedulerTask) throws Exception {
        Optional<SchedulerTask> schedulerTaskD = schedulerTaskRepository.findById(idSchedulerTask);
        if(!schedulerTaskD.isPresent()){
            throw new Exception("Scheduler task does not exist");
        }
        schedulerTaskD.get().setName(schedulerTaskDtoRequest.getName());
        schedulerTaskD.get().setCode(schedulerTaskDtoRequest.getCode());
        schedulerTaskD.get().setRecurrency(schedulerTaskDtoRequest.getRecurrency());
        return schedulerTaskD.get();
    }

    @Override
    public void delete(Long idSchedulerTask)throws Exception {
        Optional<SchedulerTask>schedulerTaskD = schedulerTaskRepository.findById(idSchedulerTask);
        if(!schedulerTaskD.isPresent()){
            throw new Exception("Scheduler task does not exist in database");
        }
        schedulerTaskRepository.deleteById(idSchedulerTask);
    }
}

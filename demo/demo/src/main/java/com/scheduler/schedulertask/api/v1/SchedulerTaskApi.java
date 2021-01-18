package com.scheduler.schedulertask.api.v1;



import com.scheduler.schedulertask.api.dto.SchedulerTaskDtoRequest;
import com.scheduler.schedulertask.domain.SchedulerTask;
import com.scheduler.schedulertask.service.SchedulerTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/schedulerTask")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SchedulerTaskApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerTaskApi.class);
    private final SchedulerTaskService schedulerTaskService;

    @Autowired
    public SchedulerTaskApi(SchedulerTaskService schedulerTaskService) {
        this.schedulerTaskService = schedulerTaskService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SchedulerTask save(@RequestBody SchedulerTask schedulerTask){
        return schedulerTaskService.save(schedulerTask);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<SchedulerTask> findAll(){
        return schedulerTaskService.findAll();
    }

    @PutMapping("{idSchedulerTask}")
    public ResponseEntity<SchedulerTask> updateSchedulerTask(@RequestBody SchedulerTaskDtoRequest schedulerTaskDtoRequest, @PathVariable Long idSchedulerTask){
        try {
            return new ResponseEntity<SchedulerTask>(schedulerTaskService.updateSchedulerTask(schedulerTaskDtoRequest, idSchedulerTask), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("{idSchedulerTask}")
    public ResponseEntity<String> delete(@PathVariable Long idSchedulerTask){
        try {
            schedulerTaskService.delete(idSchedulerTask);
            return new ResponseEntity<String>("Scheduler task is deleted" + idSchedulerTask, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

package com.scheduler.schedulertask.repository;


import com.scheduler.schedulertask.domain.SchedulerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerTaskRepository extends JpaRepository<SchedulerTask,Long> {
}

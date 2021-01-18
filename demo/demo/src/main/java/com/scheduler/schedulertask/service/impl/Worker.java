package com.scheduler.schedulertask.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.scheduler.schedulertask.domain.SchedulerTask;
import com.scheduler.schedulertask.service.SchedulerTaskService;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Worker implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(Worker.class);

	private final SchedulerTaskService schedulerTaskService;

	public Worker(SchedulerTaskService schedulerTaskService) {
		this.schedulerTaskService = schedulerTaskService;
	}

	@Override
	public void run() {
		logger.info("Worker Started", Thread.currentThread().getName());
		try {
			List<SchedulerTask> allTasks = schedulerTaskService.findAll();
			for(SchedulerTask a : allTasks) {
				groovyScript(a);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Worker ended", Thread.currentThread().getName());
	}

	private void groovyScript(SchedulerTask schedulerTask) {
		GroovyShell shell = new GroovyShell();
		Object value = shell.evaluate(schedulerTask.getCode(),"test");
		System.out.println(value);
	}
}
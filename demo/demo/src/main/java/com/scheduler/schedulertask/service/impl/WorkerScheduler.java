package com.scheduler.schedulertask.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class WorkerScheduler {

	@Autowired
	private ThreadPoolTaskExecutor executor;
	private static final Logger logger = LoggerFactory.getLogger(WorkerScheduler.class);

	private final String a ="*/1 * * * * *";

	@Autowired
	private Worker worker;

	@Scheduled(cron = a)
	public void startWorkerThread() {
		executor.execute(worker);
	}

}
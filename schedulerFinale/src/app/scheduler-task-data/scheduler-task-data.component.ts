import { Component, OnInit } from '@angular/core';
import { SchedulerTaskService } from '../scheduler-task.service';

@Component({
  selector: 'app-scheduler-task-data',
  templateUrl: './scheduler-task-data.component.html',
  styleUrls: ['./scheduler-task-data.component.scss']
})

export class SchedulerTaskDataComponent implements OnInit {

  schedulerTasks: any;
  cols: any;

  constructor(private schedulerTasksService: SchedulerTaskService) { }

  
  ngOnInit(): void {
      this.getAllSchedulerTasks();
    this.cols = [
      { field: "id", header: " ID" },
      { field: "name", header: "Name" },
      { field: "recurrency", header: "Recurrency" },
      { field: "code", header: "Code" },
      { field: "?", header: "Action" }
      ]
  }

  getAllSchedulerTasks() {
    this.schedulerTasksService.getAllSchedulerTasks().subscribe((schedulerTasks)=>{
      this.schedulerTasks=this.schedulerTasks;
      console.log(schedulerTasks);
    })
  }
}

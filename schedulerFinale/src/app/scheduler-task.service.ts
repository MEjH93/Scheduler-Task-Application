import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { SchedulerTask } from './scheduler-task';

@Injectable({
  providedIn: 'root'
})
export class SchedulerTaskService {

  constructor(private http: HttpClient) { }
    getAllSchedulerTasks() {
      return this.http.get<SchedulerTask[]>(
        `${environment.apiUrl}/api/v1/schedulerTask`
      )
      
    }
    postNewScheduler(name: string, recurrency: string, code: string) {
      return this.http.post<SchedulerTask[]>(
      `${environment.apiUrl}/api/v1/schedulerTask`, { name : name, recurrency: recurrency, code: code})
      }
    editScheduler(name: string, recurrency: string, code: string, id: any) {
      return this.http.post(
      `${environment.apiUrl}/api/v1/schedulerTask/idSchedulerTask` + id, { name: name, recurrency: recurrency, code: code})
      }   
      deleteScheduler(id: number) {
      return this.http.delete(`${environment.apiUrl}/api/v1/schedulerTask` + id, { responseType: 'text' });
      }
  }

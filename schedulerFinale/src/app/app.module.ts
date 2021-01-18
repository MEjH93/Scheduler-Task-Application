import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SchedulerTaskDataComponent } from './scheduler-task-data/scheduler-task-data.component';
import {TableModule} from 'primeng/table';
import { MessageService } from 'primeng/api';
//import { ProductService } from './productservice';
import { ConfirmationService } from 'primeng/api';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SchedulerTaskDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TableModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent],
  providers: [MessageService, ConfirmationService]
})
export class AppModule { }

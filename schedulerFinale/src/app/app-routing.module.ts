import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SchedulerTaskDataComponent } from './scheduler-task-data/scheduler-task-data.component';

const routes: Routes = [ {
   path: '', redirectTo: '/scheduler', pathMatch: 'full' },
{path:'scheduler', component:SchedulerTaskDataComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

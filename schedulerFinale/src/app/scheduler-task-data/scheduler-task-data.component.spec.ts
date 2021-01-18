import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerTaskDataComponent } from './scheduler-task-data.component';

describe('SchedulerTaskDataComponent', () => {
  let component: SchedulerTaskDataComponent;
  let fixture: ComponentFixture<SchedulerTaskDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchedulerTaskDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerTaskDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

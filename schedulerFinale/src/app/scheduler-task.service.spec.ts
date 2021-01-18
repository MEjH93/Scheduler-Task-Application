import { TestBed } from '@angular/core/testing';

import { SchedulerTaskService } from './scheduler-task.service';

describe('SchedulerTaskService', () => {
  let service: SchedulerTaskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SchedulerTaskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

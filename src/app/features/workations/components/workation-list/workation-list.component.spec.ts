import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkationListComponent } from './workation-list.component';

describe('WorkationListComponent', () => {
  let component: WorkationListComponent;
  let fixture: ComponentFixture<WorkationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

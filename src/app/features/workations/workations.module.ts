import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WorkationsRoutingModule } from './workations-routing.module';
import { WorkationListComponent } from './components/workation-list/workation-list.component';


@NgModule({
  declarations: [WorkationListComponent],
  imports: [
    CommonModule,
    WorkationsRoutingModule
  ]
})
export class WorkationsModule { }

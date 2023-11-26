import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkationListComponent } from './components/workation-list/workation-list.component';


const routes: Routes = [
  { path: '', component: WorkationListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkationsRoutingModule { }

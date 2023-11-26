import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';


const routes: Routes = [
  { path: '', component: LayoutComponent, children: [
    {
      path: 'workation',
      loadChildren: () => import(`src/app/features/workations/workations.module`).then(m => m.WorkationsModule)
    },
  ] },
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }

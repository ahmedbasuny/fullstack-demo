import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogoIconComponent } from './logo-icon/logo-icon.component';
import { IconsBaseComponent } from './icons-base.component';



@NgModule({
  declarations: [LogoIconComponent, IconsBaseComponent],
  imports: [
    CommonModule
  ],
  exports: [
    LogoIconComponent
  ]
})
export class IconsModule { }

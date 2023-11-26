import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IconsModule } from './icons/icons.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ValidationsMsgComponent } from './components/validations-msg/validations-msg.component';

@NgModule({
  declarations: [ValidationsMsgComponent],
  imports: [
    CommonModule,
    IconsModule,
    ReactiveFormsModule
  ],
  exports: [
    IconsModule,
    ReactiveFormsModule,
    ValidationsMsgComponent
  ]
})
export class SharedModule { }

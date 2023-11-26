import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-icons-base',
  template: '',
})
export class IconsBaseComponent implements OnInit {

  @Input() width = 16;
  @Input() height = 16;

  constructor() { }

  ngOnInit(): void {
  }

}

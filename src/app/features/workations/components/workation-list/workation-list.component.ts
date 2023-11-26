import { Component, OnInit } from '@angular/core';
import { WorkationService } from '../../services/workation.service';
import { WorkationInterface } from 'src/app/core/interfaces/workation.interface';

@Component({
  selector: 'app-workation-list',
  templateUrl: './workation-list.component.html',
  styleUrls: ['./workation-list.component.scss']
})
export class WorkationListComponent implements OnInit {
  workationList: WorkationInterface[];
  constructor(private workationService: WorkationService) { }

  ngOnInit(): void {
    this.getWorkationList();
  }

  getWorkationList() {
    this.workationService.getWorkationList().subscribe(res => {
      this.workationList = res;
    }
    );
  }
}

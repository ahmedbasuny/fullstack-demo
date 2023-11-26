import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WorkationInterface } from 'src/app/core/interfaces/workation.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WorkationService {

  baseUrl = environment.baseUrl;
  
  constructor(private httpClient: HttpClient) { }

  getWorkationList() : Observable<WorkationInterface[]> {
    return this.httpClient.get<WorkationInterface[]>(`${this.baseUrl}/workflex/workation`);
  }
}

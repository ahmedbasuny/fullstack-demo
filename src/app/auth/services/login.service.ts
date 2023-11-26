import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = environment.baseUrl;
  constructor(private http: HttpClient) { }

  login(payload): Observable<any>{
    return this.http.post(`${this.baseUrl}/workflex/login`, payload);
  }
}

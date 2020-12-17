import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API = `${environment.baseUrl}/members`;

@Injectable({
  providedIn: 'root',
})
export class MemberService {
  constructor(private http: HttpClient) {}

  save(data: any) {
    return data?.id > 0 ? this.http.put(API, data) : this.http.post(API, data);
  }

  search(form: any, page = '0', size = '10'): Observable<any> {
    return this.http.get(API, {
      params: {
        page,
        size,
        ...form,
      },
    });
  }
}

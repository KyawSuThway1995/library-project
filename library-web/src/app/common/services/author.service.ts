import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';

const API = `${environment.baseUrl}/authors`;

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  constructor(private http: HttpClient) {}

  search(form: any, page = '0', size = '10'): Observable<any> {
    return this.http.get(API, {
      params: {
        page,
        size,
        ...form,
      },
    });
  }

  save(data: any): Observable<any> {
    return data.id > 0 ? this.http.put(API, data) : this.http.post(API, data);
  }
}

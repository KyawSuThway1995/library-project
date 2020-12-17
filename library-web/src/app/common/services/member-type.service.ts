import { HttpClient } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';

const API = `${environment.baseUrl}/member-types`

@Injectable({
  providedIn: 'root'
})
export class MemberTypeService {

  constructor(private http: HttpClient) { }

  save(data: any){
    return data?.id > 0 ? this.http.put(API, data) : this.http.post(API, data);
  }

  findAll(){
    return this.http.get<any[]>(API)
  }
}

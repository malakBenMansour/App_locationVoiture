import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Marque } from '../model/marque';
@Injectable({
  providedIn: 'root'
})
export class MarqueService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getMarques() {
    return this.http.get<Marque[]>(`${this.apiServerUrl}/marque/all`);
  }

  public addMarque(marque: Marque): Observable<Marque> {
    return this.http.post<Marque>(`${this.apiServerUrl}/marque/add`, marque);
  }

  public updateMarque(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/marque/update/${id}`, value);
  }
  public deleteMarque(marqueId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/marque/delete/${marqueId}`);
  }

  public getMarque(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/marque/find/${id}`);
  }
}

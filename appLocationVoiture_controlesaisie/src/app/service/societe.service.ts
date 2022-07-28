import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Societe } from '../model/societe';
@Injectable({
  providedIn: 'root'
})
export class SocieteService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getSocietes() {
    return this.http.get<Societe[]>(`${this.apiServerUrl}/societe/all`);
  }

  public addSociete(societe: Societe): Observable<Societe> {
    return this.http.post<Societe>(`${this.apiServerUrl}/societe/add`, societe);
  }

  public updateSociete(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/societe/update/${id}`, value);
  }
  public deleteSociete(societeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/societe/delete/${societeId}`);
  }

  public getSociete(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/societe/find/${id}`);
  }
}

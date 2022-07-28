import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Agence } from '../model/agence';
import { Societe } from '../model/societe';
@Injectable({
  providedIn: 'root'
})
export class AgenceService {
  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getAgences() {
    //return this.http.get<Agence[]>(`${this.apiServerUrl}/agence/all`);
    return this.http.get<Agence[]>(`${this.apiServerUrl}/agence/all`);

  }

  public addAgence(agence: Agence): Observable<Agence> {
    return this.http.post<Agence>(`${this.apiServerUrl}/agence/add`, agence);
  }

  public updateAgence(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/agence/update/${id}`, value);
  }
  public deleteAgence(agenceId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/agence/delete/${agenceId}`);
  }

  public getAgence(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/agence/find/${id}`);
  }

}

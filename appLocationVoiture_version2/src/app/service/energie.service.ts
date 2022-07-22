import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Energie } from '../model/energie';

@Injectable({
  providedIn: 'root'
})
export class EnergieService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getEnergies(): Observable<Energie[]> {
    return this.http.get<Energie[]>(`${this.apiServerUrl}/energie/all`);
  }

  public addEnergie(energie: Energie): Observable<Energie> {
    return this.http.post<Energie>(`${this.apiServerUrl}/energie/add`, energie);
  }

  public updateEnergie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/energie/update/${id}`, value);
  }
  public deleteEnergie(energieId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/energie/delete/${energieId}`);
  }

  public getEnergie(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/energie/find/${id}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Boite } from '../model/boite';

@Injectable({
  providedIn: 'root'
})
export class BoiteService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getBoites(): Observable<Boite[]> {
    return this.http.get<Boite[]>(`${this.apiServerUrl}/boite/all`);
  }

  public addBoite(boite: Boite): Observable<Boite> {
    return this.http.post<Boite>(`${this.apiServerUrl}/boite/add`, boite);
  }

  public updateBoite(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/boite/update/${id}`, value);
  }
  public deleteBoite(boiteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/boite/delete/${boiteId}`);
  }

  public getBoite(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/boite/find/${id}`);
  }


}
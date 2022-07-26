import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Modele } from '../model/modele';
import { Categorie } from '../model/categorie';
import { Energie } from '../model/energie';
import { Marque } from '../model/marque';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ModeleService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getModeles(): Observable<Modele[]> {
    return this.http.get<Modele[]>(`${this.apiServerUrl}/modele/all`);
  }

  public addModele(modele: Modele): Observable<Modele> {
    return this.http.post<Modele>(`${this.apiServerUrl}/modele/add`, modele);
  }

  public updateModele(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/modele/update/${id}`, value);
  }
  public deleteModele(modeleId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/modele/delete/${modeleId}`);
  }

  public getModele(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/modele/find/${id}`);
  }

}

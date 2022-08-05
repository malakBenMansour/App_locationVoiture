import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Categorie } from '../model/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getCategories() {
  //  return this.http.get<Categorie[]>(`${this.apiServerUrl}/categorie/all`);
  return this.http.get<Categorie[]>(`${this.apiServerUrl}/categorie/all`);

  }

  public addCategorie(categorie: Categorie): Observable<Categorie> {
    return this.http.post<Categorie>(`${this.apiServerUrl}/categorie/add`, categorie);
  }

  public updateCategorie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/categorie/update/${id}`, value);
  }
  public deleteCategorie(categorieId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/categorie/delete/${categorieId}`);
  }

  public getCategorie(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/categorie/find/${id}`);
  }
}

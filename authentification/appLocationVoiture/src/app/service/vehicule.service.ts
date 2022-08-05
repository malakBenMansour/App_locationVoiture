import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { ITPercentage } from '../interface/vehicule.interface';
import { Vehicule } from '../model/vehicule';

@Injectable({
  providedIn: 'root'
})
export class VehiculeService {
  private apiServerUrl = "http://localhost:8090";

  constructor(private http: HttpClient){}

  public getVehicules(){
    return this.http.get<Vehicule[]>(`${this.apiServerUrl}/vehicule/all`);
  }

  public addVehicule(vehicule: Vehicule): Observable<Vehicule> {
    return this.http.post<Vehicule>(`${this.apiServerUrl}/vehicule/add`, vehicule);
  }

  public updateVehicule(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/vehicule/update/${id}`, value);
  }
  public deleteVehicule(vehiculeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/vehicule/delete/${vehiculeId}`);
  }

  public getVehicule(id: number): Observable<any> {
    return this.http.get(`${this.apiServerUrl}/vehicule/find/${id}`);
  }

  getTypePercentage(): Observable<Array<ITPercentage>> {
    return this.http.get<Array<ITPercentage>>(`http://localhost:8090/vehicule/stat`)
      .pipe(map((d: Array<ITPercentage>) => d));
  }

}

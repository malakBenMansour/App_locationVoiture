import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Boite } from 'src/app/model/boite';
import { Modele } from 'src/app/model/modele';
import { Vehicule } from 'src/app/model/vehicule';
import { BoiteService } from 'src/app/service/boite.service';
import { ModeleService } from 'src/app/service/modele.service';
import { VehiculeService } from 'src/app/service/vehicule.service';

@Component({
  selector: 'app-list-vehicule',
  templateUrl: './list-vehicule.component.html',
  styleUrls: ['./list-vehicule.component.scss']
})
export class ListVehiculeComponent implements OnInit {

  vehicules: Observable<Vehicule[]> | undefined;
  modeles: Observable<Modele[]> | undefined;
  boites: Observable<Boite[]> | undefined;
  employees: Vehicule[] = [];
   nom:any;
   p:number=1;
  constructor(private employeeService: VehiculeService,private boiteService:BoiteService,private modeleService:ModeleService,
   
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.modeles=this.modeleService.getModeles();
    this.boites=this.boiteService.getBoites();
  }

  reloadData() {
   // this.vehicules = this.employeeService.getVehicules();
   this.employeeService.getVehicules().subscribe((response)=>{
    this.employees=response;
  })
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteVehicule(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['updateVehicule', id]);
  }
  
  Search()
  {
    if(this.nom=="")
    {
      this.reloadData();
    }
    else 
    {
      this.employees=this.employees.filter(res=>{
        return res.nom.toLocaleLowerCase().match(this.nom.toLocaleLowerCase());
      })
    }
  }
  
  
  key:string='nom';
  reverse:boolean=false;
  sort(key:string)
  {
  this.key=key;
  this.reverse=!this.reverse;
  }

}

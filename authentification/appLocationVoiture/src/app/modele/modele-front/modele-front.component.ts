import { Component, OnInit } from '@angular/core';
import { Modele } from '../../model/modele';
import { ModeleService } from '../../service/modele.service';
import { Router } from '@angular/router';
import { Marque } from 'src/app/model/marque';
import { MarqueService } from 'src/app/service/marque.service';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';
import { Energie } from 'src/app/model/energie';
import { EnergieService } from 'src/app/service/energie.service';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-modele-front',
  templateUrl: './modele-front.component.html',
  styleUrls: ['./modele-front.component.scss']
})
export class ModeleFrontComponent implements OnInit {

  
  modeles: Observable<Modele[]> | undefined;
  energies: Observable<Energie[]> | undefined;
  marques: Observable<Marque[]> | undefined;
  categories: Observable<Categorie[]> | undefined;
  employees: Marque[] = [];
  nom:any;
  p:number=1;
  constructor(private employeeService: ModeleService,private energieService:EnergieService,
    private marqueService:MarqueService,private categorieService:CategorieService,
    private router: Router) {}

  ngOnInit() {
    this.energies=this.energieService.getEnergies();
    this.marques=this.marqueService.getMarques();
    this.categories=this.categorieService.getCategories();
    this.reloadData();
   }

  reloadData() {
 //   this.modeles = this.employeeService.getModeles();
 this.employeeService.getModeles().subscribe((response)=>{
  this.employees=response;
})
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteModele(id)
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
    this.router.navigate(['updateModele', id]);
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

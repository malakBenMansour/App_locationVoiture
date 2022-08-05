import { Component, OnInit } from '@angular/core';
import { Energie } from '../../model/energie';
import { EnergieService } from '../../service/energie.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-energie-front',
  templateUrl: './energie-front.component.html',
  styleUrls: ['./energie-front.component.scss']
})
export class EnergieFrontComponent implements OnInit {

  energies: Observable<Energie[]> | undefined;
  employees: Energie[] = [];
  nom:any;
  p:number=1;
  constructor(private employeeService: EnergieService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
   // this.energies = this.employeeService.getEnergies();
   this.employeeService.getEnergies().subscribe((response)=>{
    this.employees=response;
  })
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEnergie(id)
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
    this.router.navigate(['updateEnergie', id]);
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
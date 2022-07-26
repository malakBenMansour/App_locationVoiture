import { Component, OnInit } from '@angular/core';
import { Agence } from '../../model/agence';
import { AgenceService } from '../../service/agence.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import { Societe } from 'src/app/model/societe';
import { SocieteService } from 'src/app/service/societe.service';
@Component({
  selector: 'app-list-agence',
  templateUrl: './list-agence.component.html',
  styleUrls: ['./list-agence.component.scss']
})
export class ListAgenceComponent implements OnInit {
  agences: Observable<Agence[]> | undefined;
  employees: Agence[] = [];
   nom:any;
   p:number=1;
  societes: Observable<Societe[]> | undefined;
  constructor(private employeeService: AgenceService,private societeService:SocieteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
   this.societes=this.societeService.getSocietes();
  }

  reloadData() {
 //   this.agences = this.employeeService.getAgences();
 this.employeeService.getAgences().subscribe((response)=>{
  this.employees=response;
})
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteAgence(id)
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
    this.router.navigate(['updateAgence', id]);
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

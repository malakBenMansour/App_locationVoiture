import { Component, OnInit } from '@angular/core';
import { Societe } from '../../model/societe';
import { SocieteService } from '../../service/societe.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-societe-front',
  templateUrl: './societe-front.component.html',
  styleUrls: ['./societe-front.component.scss']
})
export class SocieteFrontComponent implements OnInit {

  societes: Observable<Societe[]> | undefined;
  employees: Societe[] = [];
  nom:any;
  p:number=1;
  constructor(private employeeService: SocieteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
   // this.societes = this.employeeService.getSocietes();
   this.employeeService.getSocietes().subscribe((response)=>{
    this.employees=response;
  })
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteSociete(id)
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
    this.router.navigate(['updateSociete', id]);
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

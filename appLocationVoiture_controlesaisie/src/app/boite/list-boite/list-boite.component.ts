import { Component, OnInit } from '@angular/core';
import { Boite } from '../../model/boite';
import { BoiteService } from '../../service/boite.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-boite',
  templateUrl: './list-boite.component.html',
  styleUrls: ['./list-boite.component.scss']
})
export class ListBoiteComponent implements OnInit {

 boites: Observable<Boite> | undefined;
  
 employees: Boite[] = [];
   nom:any;
   p:number=1;
  constructor(private employeeService: BoiteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
  
  // this.employees = this.employeeService.getBoites();
  this.employeeService.getBoites().subscribe((response)=>{
    this.employees=response;
  })
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteBoite(id)
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
    this.router.navigate(['update', id]);
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
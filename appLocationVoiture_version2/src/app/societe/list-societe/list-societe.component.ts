import { Component, OnInit } from '@angular/core';
import { Societe } from '../../model/societe';
import { SocieteService } from '../../service/societe.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-societe',
  templateUrl: './list-societe.component.html',
  styleUrls: ['./list-societe.component.scss']
})
export class ListSocieteComponent implements OnInit {

  societes: Observable<Societe[]> | undefined;

  constructor(private employeeService: SocieteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.societes = this.employeeService.getSocietes();
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


}

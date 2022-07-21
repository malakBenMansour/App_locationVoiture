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

  boites: Observable<Boite[]> | undefined;

  constructor(private employeeService: BoiteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.boites = this.employeeService.getBoites();
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


}
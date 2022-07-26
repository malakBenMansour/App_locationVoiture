import { Component, OnInit } from '@angular/core';
import { Marque } from '../../model/marque';
import { MarqueService } from '../../service/marque.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-marque',
  templateUrl: './list-marque.component.html',
  styleUrls: ['./list-marque.component.scss']
})
export class ListMarqueComponent implements OnInit {

  marques: Observable<Marque[]> | undefined;

  constructor(private employeeService: MarqueService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.marques = this.employeeService.getMarques();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteMarque(id)
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
    this.router.navigate(['updateMarque', id]);
  }


}

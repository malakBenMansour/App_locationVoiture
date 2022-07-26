import { Component, OnInit } from '@angular/core';
import { Categorie } from '../../model/categorie';
import { CategorieService } from '../../service/categorie.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-categorie',
  templateUrl: './list-categorie.component.html',
  styleUrls: ['./list-categorie.component.scss']
})
export class ListCategorieComponent implements OnInit {

  categories: Observable<Categorie[]> | undefined;

  constructor(private employeeService: CategorieService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.categories = this.employeeService.getCategories();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteCategorie(id)
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
    this.router.navigate(['updateCategorie', id]);
  }


}

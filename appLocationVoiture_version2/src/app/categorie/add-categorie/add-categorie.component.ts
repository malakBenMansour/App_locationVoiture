import { Component, OnInit } from '@angular/core';
import { Categorie } from '../../model/categorie';
import { CategorieService } from '../../service/categorie.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent implements OnInit {

  employee: Categorie = new Categorie();
  submitted = false;

  constructor(private employeeService: CategorieService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Categorie();
  }

  save() {
    this.employeeService
    .addCategorie(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Categorie();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/categories']);
  }

  

}

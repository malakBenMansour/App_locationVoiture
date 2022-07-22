import { Component, OnInit } from '@angular/core';
import { Categorie } from '../../model/categorie';
import { CategorieService } from '../../service/categorie.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent implements OnInit {

  employee: Categorie = new Categorie();
  submitted = false;
  public registerForm!: FormGroup;
  constructor(private employeeService: CategorieService,
    private router: Router) { }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl()
    });
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

  onSubmit(registerForm: NgForm) {
    this.submitted = true;
    console.log(registerForm.form);
    console.log('valeurs: ', JSON.stringify(registerForm.value));
   
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/categories']);
  }

  

}

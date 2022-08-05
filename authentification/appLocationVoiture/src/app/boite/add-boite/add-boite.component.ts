import { Component, OnInit } from '@angular/core';
import { Boite } from '../../model/boite';
import { BoiteService } from '../../service/boite.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-boite',
  templateUrl: './add-boite.component.html',
  styleUrls: ['./add-boite.component.scss']
})
export class AddBoiteComponent implements OnInit {

  employee: Boite = new Boite();
  submitted = false;
  public registerForm!: FormGroup;
  constructor(private employeeService: BoiteService,
    private router: Router) { }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl()
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Boite();
  }

  save() {
    this.employeeService
    .addBoite(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Boite();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit(registerForm: NgForm) {
    this.submitted = true;
    console.log(registerForm.form);
    console.log('valeurs: ', JSON.stringify(registerForm.value))
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/boites']);
  }

  
}
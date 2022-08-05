import { Component, OnInit } from '@angular/core';
import { Societe } from '../../model/societe';
import { SocieteService } from '../../service/societe.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-societe',
  templateUrl: './add-societe.component.html',
  styleUrls: ['./add-societe.component.scss']
})
export class AddSocieteComponent implements OnInit {

  public registerForm!: FormGroup;
  employee: Societe = new Societe();
  submitted = false;
  numberRegEx = /[0-9\+\-\ ]/;
  
  telForm!: FormGroup;
  constructor(private employeeService: SocieteService,
    private router: Router) { this.telForm = new FormGroup({
      year: new FormControl("", {
        validators: [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8}$")],
        updateOn: "blur"
      })
    }); }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl(),
      adresse:new FormControl(),
      email: new FormControl(),
      tel:new FormControl(),
    site:new FormControl()
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Societe();
  }

  save() {
    this.employeeService
    .addSociete(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Societe();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit(registerForm: NgForm) {
    this.submitted = true;
    console.log('valeurs: ', JSON.stringify(registerForm.value));
    console.log(registerForm.form);
 
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/societes']);
  }

}

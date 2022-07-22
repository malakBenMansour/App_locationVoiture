import { Component, OnInit } from '@angular/core';
import { Agence } from '../../model/agence';
import { AgenceService } from '../../service/agence.service';
import { Router } from '@angular/router';
import { Societe } from 'src/app/model/societe';
import { SocieteService } from 'src/app/service/societe.service';
import { Observable } from 'rxjs';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-agence',
  templateUrl: './add-agence.component.html',
  styleUrls: ['./add-agence.component.scss']
})
export class AddAgenceComponent implements OnInit {
  public registerForm!: FormGroup;
  employee: Agence = new Agence();
  submitted = false;
  societes: Observable<Societe[]> | undefined;
  numberRegEx = /[0-9\+\-\ ]/;
  
  telForm!: FormGroup;
  
  
  constructor(private employeeService: AgenceService,private societeService:SocieteService,
    private router: Router) {

      this.telForm = new FormGroup({
        year: new FormControl("", {
          validators: [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8}$")],
          updateOn: "blur"
        })
      });
     }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl(),
      adresse:new FormControl(),
      email: new FormControl(),
      tel:new FormControl()
      
     

    });
    this.societes=this.societeService.getSocietes();
  }

  newEmployee(): void {
    this.submitted = false;
    this.societes=this.societeService.getSocietes();
    this.employee = new Agence();

  }

  save() {
    this.employeeService
    .addAgence(this.employee).subscribe(data => {
      console.log(data)
      this.societes=this.societeService.getSocietes();
      this.employee = new Agence();
      
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
    this.router.navigate(['/agences']);
  }
  

}

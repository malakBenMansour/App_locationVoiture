import { Component, OnInit } from '@angular/core';
import { Energie } from '../../model/energie';
import { EnergieService } from '../../service/energie.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
@Component({
  selector: 'app-add-energie',
  templateUrl: './add-energie.component.html',
  styleUrls: ['./add-energie.component.scss']
})
export class AddEnergieComponent implements OnInit {

  employee: Energie = new Energie();
  submitted = false;
  public registerForm!: FormGroup;
  constructor(private employeeService: EnergieService,
    private router: Router) { }

  ngOnInit()  : void {
    this.registerForm = new FormGroup({
      nom: new FormControl()
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Energie();
  }

  save() {
    this.employeeService
    .addEnergie(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Energie();
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
    this.router.navigate(['/energies']);
  }

  

}

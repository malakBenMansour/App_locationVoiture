import { Component, OnInit } from '@angular/core';
import { Marque } from '../../model/marque';
import { MarqueService } from '../../service/marque.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
@Component({
  selector: 'app-add-marque',
  templateUrl: './add-marque.component.html',
  styleUrls: ['./add-marque.component.scss']
})
export class AddMarqueComponent implements OnInit {

  employee: Marque = new Marque();
  submitted = false;
  public registerForm!: FormGroup;
  constructor(private employeeService: MarqueService,
    private router: Router) { }

  ngOnInit()  : void {
    this.registerForm = new FormGroup({
      nom: new FormControl()
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Marque();
  }

  save() {
    this.employeeService
    .addMarque(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Marque();
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
    this.router.navigate(['/marques']);
  }

  

}

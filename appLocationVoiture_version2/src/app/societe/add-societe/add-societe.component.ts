import { Component, OnInit } from '@angular/core';
import { Societe } from '../../model/societe';
import { SocieteService } from '../../service/societe.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-societe',
  templateUrl: './add-societe.component.html',
  styleUrls: ['./add-societe.component.scss']
})
export class AddSocieteComponent implements OnInit {

 
  employee: Societe = new Societe();
  submitted = false;

  constructor(private employeeService: SocieteService,
    private router: Router) { }

  ngOnInit() {
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

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/societes']);
  }

}

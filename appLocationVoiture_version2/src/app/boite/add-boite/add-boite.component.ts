import { Component, OnInit } from '@angular/core';
import { Boite } from '../../model/boite';
import { BoiteService } from '../../service/boite.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-boite',
  templateUrl: './add-boite.component.html',
  styleUrls: ['./add-boite.component.scss']
})
export class AddBoiteComponent implements OnInit {

  employee: Boite = new Boite();
  submitted = false;

  constructor(private employeeService: BoiteService,
    private router: Router) { }

  ngOnInit() {
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

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/boites']);
  }

  
}
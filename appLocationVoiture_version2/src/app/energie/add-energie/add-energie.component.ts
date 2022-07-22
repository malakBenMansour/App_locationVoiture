import { Component, OnInit } from '@angular/core';
import { Energie } from '../../model/energie';
import { EnergieService } from '../../service/energie.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-energie',
  templateUrl: './add-energie.component.html',
  styleUrls: ['./add-energie.component.scss']
})
export class AddEnergieComponent implements OnInit {

  employee: Energie = new Energie();
  submitted = false;

  constructor(private employeeService: EnergieService,
    private router: Router) { }

  ngOnInit() {
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

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/energies']);
  }

  

}

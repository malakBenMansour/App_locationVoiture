import { Component, OnInit } from '@angular/core';
import { Marque } from '../../model/marque';
import { MarqueService } from '../../service/marque.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-marque',
  templateUrl: './add-marque.component.html',
  styleUrls: ['./add-marque.component.scss']
})
export class AddMarqueComponent implements OnInit {

  employee: Marque = new Marque();
  submitted = false;

  constructor(private employeeService: MarqueService,
    private router: Router) { }

  ngOnInit() {
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

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/marques']);
  }

  

}

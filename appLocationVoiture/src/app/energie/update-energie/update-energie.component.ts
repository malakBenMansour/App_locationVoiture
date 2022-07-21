import { Component, OnInit } from '@angular/core';
import { Energie } from '../../model/energie';
import { ActivatedRoute, Router } from '@angular/router';
import { EnergieService } from '../../service/energie.service';
@Component({
  selector: 'app-update-energie',
  templateUrl: './update-energie.component.html',
  styleUrls: ['./update-energie.component.scss']
})
export class UpdateEnergieComponent implements OnInit {

  id!: number;
  employee!: Energie;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EnergieService) { }

  ngOnInit() {
    this.employee = new Energie();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getEnergie(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateEnergie(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Energie();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/energies']);
  }



}

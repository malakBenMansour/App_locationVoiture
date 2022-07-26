import { Component, OnInit } from '@angular/core';
import { Boite } from '../../model/boite';
import { ActivatedRoute, Router } from '@angular/router';
import { BoiteService } from '../../service/boite.service';
@Component({
  selector: 'app-update-boite',
  templateUrl: './update-boite.component.html',
  styleUrls: ['./update-boite.component.scss']
})
export class UpdateBoiteComponent implements OnInit {

  id!: number;
  employee!: Boite;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: BoiteService) { }

  ngOnInit() {
    this.employee = new Boite();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getBoite(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateBoite(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Boite();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/boites']);
  }

}

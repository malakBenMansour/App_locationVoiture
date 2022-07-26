import { Component, OnInit } from '@angular/core';
import { Marque } from '../../model/marque';
import { ActivatedRoute, Router } from '@angular/router';
import { MarqueService } from '../../service/marque.service';
@Component({
  selector: 'app-update-marque',
  templateUrl: './update-marque.component.html',
  styleUrls: ['./update-marque.component.scss']
})
export class UpdateMarqueComponent implements OnInit {
  id!: number;
  employee!: Marque;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: MarqueService) { }

  ngOnInit() {
    this.employee = new Marque();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getMarque(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateMarque(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Marque();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/marques']);
  }




}

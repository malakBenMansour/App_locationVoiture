import { Component, OnInit } from '@angular/core';
import { Societe } from '../../model/societe';
import { ActivatedRoute, Router } from '@angular/router';
import { SocieteService } from '../../service/societe.service';
@Component({
  selector: 'app-update-societe',
  templateUrl: './update-societe.component.html',
  styleUrls: ['./update-societe.component.scss']
})
export class UpdateSocieteComponent implements OnInit {

  id!: number;
  employee!: Societe;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: SocieteService) { }

  ngOnInit() {
    this.employee = new Societe();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getSociete(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateSociete(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Societe();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/societes']);
  }


}

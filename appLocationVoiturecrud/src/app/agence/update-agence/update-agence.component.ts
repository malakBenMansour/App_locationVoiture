import { Component, OnInit } from '@angular/core';
import { Agence } from 'src/app/model/agence';
import { AgenceService } from 'src/app/service/agence.service';
import { Societe } from 'src/app/model/societe';
import { SocieteService } from 'src/app/service/societe.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-agence',
  templateUrl: './update-agence.component.html',
  styleUrls: ['./update-agence.component.scss']
})
export class UpdateAgenceComponent implements OnInit {

  id!: number;
  employee!: Agence;
  societes: Observable<Societe[]> | undefined;
  

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: AgenceService,private societeService:SocieteService,) { }

  ngOnInit() {
    this.societes=this.societeService.getSocietes();
    this.employee = new Agence();

    this.id = this.route.snapshot.params['id'];
  
    this.employeeService.getAgence(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateAgence(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.societes=this.societeService.getSocietes();
        this.employee = new Agence();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/agences']);
  }
  
 
}

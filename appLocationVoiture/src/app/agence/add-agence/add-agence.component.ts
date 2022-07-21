import { Component, OnInit } from '@angular/core';
import { Agence } from '../../model/agence';
import { AgenceService } from '../../service/agence.service';
import { Router } from '@angular/router';
import { Societe } from 'src/app/model/societe';
import { SocieteService } from 'src/app/service/societe.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-add-agence',
  templateUrl: './add-agence.component.html',
  styleUrls: ['./add-agence.component.scss']
})
export class AddAgenceComponent implements OnInit {

  employee: Agence = new Agence();
  submitted = false;
  societes: Observable<Societe[]> | undefined;

  constructor(private employeeService: AgenceService,private societeService:SocieteService,
    private router: Router) { }

  ngOnInit() {
    this.societes=this.societeService.getSocietes();
  }

  newEmployee(): void {
    this.submitted = false;
    this.societes=this.societeService.getSocietes();
    this.employee = new Agence();

  }

  save() {
    this.employeeService
    .addAgence(this.employee).subscribe(data => {
      console.log(data)
      this.societes=this.societeService.getSocietes();
      this.employee = new Agence();
      
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
 
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/agences']);
  }
  

}

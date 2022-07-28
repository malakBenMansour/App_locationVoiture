import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Boite } from 'src/app/model/boite';
import { Modele } from 'src/app/model/modele';
import { Vehicule } from 'src/app/model/vehicule';
import { BoiteService } from 'src/app/service/boite.service';
import { ModeleService } from 'src/app/service/modele.service';
import { VehiculeService } from 'src/app/service/vehicule.service';

@Component({
  selector: 'app-update-vehicule',
  templateUrl: './update-vehicule.component.html',
  styleUrls: ['./update-vehicule.component.scss']
})
export class UpdateVehiculeComponent implements OnInit {

  id!: number;
  employee!: Vehicule;
  modeles: Observable<Modele[]> | undefined;
  boites: Observable<Boite[]> | undefined;
  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: VehiculeService,private boiteService:BoiteService,private modeleService:ModeleService) { }

  ngOnInit() {
    this.modeles=this.modeleService.getModeles();
    this.boites=this.boiteService.getBoites();
    this.employee = new Vehicule();

    this.id = this.route.snapshot.params['id'];
  
    this.employeeService.getVehicule(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateVehicule(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.modeles=this.modeleService.getModeles();
    this.boites=this.boiteService.getBoites();
        this.employee = new Vehicule();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/vehicules']);
  }
  

}

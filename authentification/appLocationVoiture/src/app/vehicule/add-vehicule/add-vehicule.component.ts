import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Boite } from 'src/app/model/boite';
import { Modele } from 'src/app/model/modele';
import { Vehicule } from 'src/app/model/vehicule';
import { BoiteService } from 'src/app/service/boite.service';
import { ModeleService } from 'src/app/service/modele.service';
import { VehiculeService } from 'src/app/service/vehicule.service';

@Component({
  selector: 'app-add-vehicule',
  templateUrl: './add-vehicule.component.html',
  styleUrls: ['./add-vehicule.component.scss']
})
export class AddVehiculeComponent implements OnInit {
  public registerForm!: FormGroup;
  employee: Vehicule = new Vehicule();
  submitted = false;
  modeles: Observable<Modele[]> | undefined;
  boites: Observable<Boite[]> | undefined;
  numChassisForm!: FormGroup;
  
  
  constructor(private employeeService: VehiculeService,private boiteService:BoiteService,private modeleService:ModeleService,
    private router: Router) {
      this.numChassisForm = new FormGroup({
        year: new FormControl("", {
          validators: [Validators.required, Validators.pattern("^((\\91-?)|0)?[0-9]$")],
          updateOn: "blur"
        })
      });
     }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl(),
      color:new FormControl(),
      numChassis: new FormControl(),
      
      matricule:new FormControl()
    });
    this.modeles=this.modeleService.getModeles();
    this.boites=this.boiteService.getBoites();
  }

  newEmployee(): void {
    this.submitted = false;
    this.modeles=this.modeleService.getModeles();
    this.boites=this.boiteService.getBoites();
    this.employee = new Vehicule();

  }

  save() {
    this.employeeService
    .addVehicule(this.employee).subscribe(data => {
      console.log(data)
      this.modeles=this.modeleService.getModeles();
      this.boites=this.boiteService.getBoites();
      this.employee = new Vehicule();
      
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit(registerForm: NgForm) {
    this.submitted = true;
    console.log('valeurs: ', JSON.stringify(registerForm.value));
    console.log(registerForm.form);
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/vehicules']);
  }
  
}

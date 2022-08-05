import { Component, OnInit } from '@angular/core';
import { Modele } from '../../model/modele';
import { ModeleService } from '../../service/modele.service';
import { Router } from '@angular/router';
import { Marque } from 'src/app/model/marque';
import { MarqueService } from 'src/app/service/marque.service';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';
import { Energie } from 'src/app/model/energie';
import { EnergieService } from 'src/app/service/energie.service';

import { Observable } from 'rxjs';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-modele',
  templateUrl: './add-modele.component.html',
  styleUrls: ['./add-modele.component.scss']
})
export class AddModeleComponent implements OnInit {
  public registerForm!: FormGroup;
  employee: Modele = new Modele();
  submitted = false;
  energies: Observable<Energie[]> | undefined;
  marques: Observable<Marque[]> | undefined;
  categories: Observable<Categorie[]> | undefined;
  
  nbportesForm!: FormGroup;
  
  nbplacesForm!: FormGroup;
 volumeForm!: FormGroup;

  constructor(private employeeService: ModeleService,private energieService:EnergieService,
    private marqueService:MarqueService,private categorieService:CategorieService,
    private router: Router) { 
      this.nbportesForm = new FormGroup({
        year: new FormControl("", {
          validators: [Validators.required, Validators.pattern("^((\\91-?)|0)?[0-9]$")],
          updateOn: "blur"
        })
      });

      this.nbplacesForm = new FormGroup({
        year: new FormControl("", {
          validators: [Validators.required, Validators.pattern("^((\\91-?)|0)?[0-9]$")],
          updateOn: "blur"
        })
      });
      this.volumeForm = new FormGroup({
        year: new FormControl("", {
          validators: [Validators.required, Validators.pattern("^((\\91-?)|0)?[0-9]$")],
          updateOn: "blur"
        })
      });


    }

  ngOnInit() : void {
    this.registerForm = new FormGroup({
      nom: new FormControl(),
      nbplaces:new FormControl(),
      nbportes: new FormControl(),
      puissance:new FormControl(),
      version:new FormControl(),
      volumecoffre:new FormControl()


    });
    this.energies=this.energieService.getEnergies();
    this.marques=this.marqueService.getMarques();
    this.categories=this.categorieService.getCategories();
  }

  newEmployee(): void {
    this.submitted = false;
    this.energies=this.energieService.getEnergies();
    this.marques=this.marqueService.getMarques();
    this.categories=this.categorieService.getCategories();
    this.employee = new Modele();

  }

  save() {
    this.employeeService
    .addModele(this.employee).subscribe(data => {
      console.log(data)
      this.energies=this.energieService.getEnergies();
    this.marques=this.marqueService.getMarques();
    this.categories=this.categorieService.getCategories();
      this.employee = new Modele();
      
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
    this.router.navigate(['/modeles']);
  }
  

}

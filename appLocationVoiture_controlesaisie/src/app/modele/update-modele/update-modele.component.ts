import { Component, OnInit } from '@angular/core';
import { Modele } from 'src/app/model/modele';
import { ModeleService } from '../../service/modele.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Marque } from 'src/app/model/marque';
import { MarqueService } from 'src/app/service/marque.service';
import { Categorie } from 'src/app/model/categorie';
import { CategorieService } from 'src/app/service/categorie.service';
import { Energie } from 'src/app/model/energie';
import { EnergieService } from 'src/app/service/energie.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-update-modele',
  templateUrl: './update-modele.component.html',
  styleUrls: ['./update-modele.component.scss']
})
export class UpdateModeleComponent implements OnInit {

  id!: number;
  employee!: Modele;
  energies: Observable<Energie[]> | undefined;
  marques: Observable<Marque[]> | undefined;
  categories: Observable<Categorie[]> | undefined;


  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: ModeleService,private energieService:EnergieService,
    private marqueService:MarqueService,private categorieService:CategorieService) { }

  ngOnInit() {
    this.energies=this.energieService.getEnergies();
    this.marques=this.marqueService.getMarques();
    this.categories=this.categorieService.getCategories();
    this.employee = new Modele();

    this.id = this.route.snapshot.params['id'];
  
    this.employeeService.getModele(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateModele(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.energies=this.energieService.getEnergies();
        this.marques=this.marqueService.getMarques();
        this.categories=this.categorieService.getCategories();
        this.employee = new Modele();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/modeles']);
  }
  

}

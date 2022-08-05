import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAgenceComponent } from './agence/add-agence/add-agence.component';
import { AgenceFrontComponent } from './agence/agence-front/agence-front.component';
import { ListAgenceComponent } from './agence/list-agence/list-agence.component';
import { UpdateAgenceComponent } from './agence/update-agence/update-agence.component';
import { AddBoiteComponent } from './boite/add-boite/add-boite.component';
import { BoiteFrontComponent } from './boite/boite-front/boite-front.component';
import { ListBoiteComponent } from './boite/list-boite/list-boite.component';
import { UpdateBoiteComponent } from './boite/update-boite/update-boite.component';
import { AddCategorieComponent } from './categorie/add-categorie/add-categorie.component';
import { CategorieFrontComponent } from './categorie/categorie-front/categorie-front.component';
import { ListCategorieComponent } from './categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './categorie/update-categorie/update-categorie.component';
import { AddEnergieComponent } from './energie/add-energie/add-energie.component';
import { EnergieFrontComponent } from './energie/energie-front/energie-front.component';
import { ListEnergieComponent } from './energie/list-energie/list-energie.component';
import { UpdateEnergieComponent } from './energie/update-energie/update-energie.component';
import { ExportSocieteComponent } from './export-societe/export-societe.component';
import { LoginComponent } from './login/login.component';
import { AddMarqueComponent } from './marque/add-marque/add-marque.component';
import { ListMarqueComponent } from './marque/list-marque/list-marque.component';
import { MarqueFrontComponent } from './marque/marque-front/marque-front.component';
import { UpdateMarqueComponent } from './marque/update-marque/update-marque.component';
import { AddModeleComponent } from './modele/add-modele/add-modele.component';
import { ListModeleComponent } from './modele/list-modele/list-modele.component';
import { ModeleFrontComponent } from './modele/modele-front/modele-front.component';
import { UpdateModeleComponent } from './modele/update-modele/update-modele.component';
import { RegisterComponent } from './register/register.component';
import { AddSocieteComponent } from './societe/add-societe/add-societe.component';
import { ListSocieteComponent } from './societe/list-societe/list-societe.component';
import { SocieteFrontComponent } from './societe/societe-front/societe-front.component';
import { UpdateSocieteComponent } from './societe/update-societe/update-societe.component';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import { AddVehiculeComponent } from './vehicule/add-vehicule/add-vehicule.component';
import { ListVehiculeComponent } from './vehicule/list-vehicule/list-vehicule.component';
import { UpdateVehiculeComponent } from './vehicule/update-vehicule/update-vehicule.component';
import { VehiculeFrontComponent } from './vehicule/vehicule-front/vehicule-front.component';

const routes: Routes = [{ path: '', redirectTo: 'boite', pathMatch: 'full' },
{ path: 'boites', component: ListBoiteComponent },
{ path: 'add', component: AddBoiteComponent },
{ path: 'update/:id', component: UpdateBoiteComponent },
{ path: 'categories', component: ListCategorieComponent },
{ path: 'addCategorie', component: AddCategorieComponent },
{ path: 'updateCategorie/:id', component: UpdateCategorieComponent },
{ path: 'energies', component: ListEnergieComponent },
{ path: 'addEnergie', component: AddEnergieComponent },
{ path: 'updateEnergie/:id', component: UpdateEnergieComponent },
{ path: 'marques', component: ListMarqueComponent },
{ path: 'addMarque', component: AddMarqueComponent },
{ path: 'updateMarque/:id', component: UpdateMarqueComponent },
{ path: 'societes', component: ListSocieteComponent },
{ path: 'addSociete', component: AddSocieteComponent },
{ path: 'updateSociete/:id', component: UpdateSocieteComponent },
{ path: 'agences', component: ListAgenceComponent },
{ path: 'addAgence', component: AddAgenceComponent },
{ path: 'updateAgence/:id', component: UpdateAgenceComponent },
{ path: 'modeles', component:ListModeleComponent },
{ path: 'addModele', component: AddModeleComponent },
{ path: 'updateModele/:id', component: UpdateModeleComponent },
{ path: 'vehicules', component:ListVehiculeComponent },
{ path: 'addVehicule', component: AddVehiculeComponent },
{ path: 'updateVehicule/:id', component: UpdateVehiculeComponent },
{ path: 'stat', component: StatistiquesComponent },
{ path: 'pdfsocietes', component: ExportSocieteComponent },
{path:'register',component:RegisterComponent},
{path:'login',component:LoginComponent},
{path:'agencefront',component:AgenceFrontComponent},
{path:'boitefront',component:BoiteFrontComponent},
{path:'categoriefront',component:CategorieFrontComponent},
{path:'energiefront',component:EnergieFrontComponent},
{path:'modelefront',component:ModeleFrontComponent},
{path:'societefront',component:SocieteFrontComponent},
{path:'vehiculefront',component:VehiculeFrontComponent},
{path:'marquefront',component:MarqueFrontComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

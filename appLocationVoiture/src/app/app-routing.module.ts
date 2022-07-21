import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAgenceComponent } from './agence/add-agence/add-agence.component';
import { ListAgenceComponent } from './agence/list-agence/list-agence.component';
import { UpdateAgenceComponent } from './agence/update-agence/update-agence.component';
import { AddBoiteComponent } from './boite/add-boite/add-boite.component';
import { ListBoiteComponent } from './boite/list-boite/list-boite.component';
import { UpdateBoiteComponent } from './boite/update-boite/update-boite.component';
import { AddCategorieComponent } from './categorie/add-categorie/add-categorie.component';
import { ListCategorieComponent } from './categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './categorie/update-categorie/update-categorie.component';
import { AddEnergieComponent } from './energie/add-energie/add-energie.component';
import { ListEnergieComponent } from './energie/list-energie/list-energie.component';
import { UpdateEnergieComponent } from './energie/update-energie/update-energie.component';
import { AddMarqueComponent } from './marque/add-marque/add-marque.component';
import { ListMarqueComponent } from './marque/list-marque/list-marque.component';
import { UpdateMarqueComponent } from './marque/update-marque/update-marque.component';
import { AddSocieteComponent } from './societe/add-societe/add-societe.component';
import { ListSocieteComponent } from './societe/list-societe/list-societe.component';
import { UpdateSocieteComponent } from './societe/update-societe/update-societe.component';

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

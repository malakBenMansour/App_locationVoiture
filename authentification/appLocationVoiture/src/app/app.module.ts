import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBoiteComponent } from './boite/add-boite/add-boite.component';
import { ListBoiteComponent } from './boite/list-boite/list-boite.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateBoiteComponent } from './boite/update-boite/update-boite.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { AddCategorieComponent } from './categorie/add-categorie/add-categorie.component';
import { ListCategorieComponent } from './categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './categorie/update-categorie/update-categorie.component';
import { ListEnergieComponent } from './energie/list-energie/list-energie.component';
import { AddEnergieComponent } from './energie/add-energie/add-energie.component';
import { UpdateEnergieComponent } from './energie/update-energie/update-energie.component';
import { ListMarqueComponent } from './marque/list-marque/list-marque.component';
import { AddMarqueComponent } from './marque/add-marque/add-marque.component';
import { UpdateMarqueComponent } from './marque/update-marque/update-marque.component';
import { ListSocieteComponent } from './societe/list-societe/list-societe.component';
import { AddSocieteComponent } from './societe/add-societe/add-societe.component';
import { UpdateSocieteComponent } from './societe/update-societe/update-societe.component';
import { ListAgenceComponent } from './agence/list-agence/list-agence.component';
import { AddAgenceComponent } from './agence/add-agence/add-agence.component';
import { UpdateAgenceComponent } from './agence/update-agence/update-agence.component';
import { ListModeleComponent } from './modele/list-modele/list-modele.component';
import { AddModeleComponent } from './modele/add-modele/add-modele.component';
import { UpdateModeleComponent } from './modele/update-modele/update-modele.component';
import { AddVehiculeComponent } from './vehicule/add-vehicule/add-vehicule.component';
import { ListVehiculeComponent } from './vehicule/list-vehicule/list-vehicule.component';
import { UpdateVehiculeComponent } from './vehicule/update-vehicule/update-vehicule.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { NgxPaginationModule } from 'ngx-pagination';
import { ChartsModule } from 'ng2-charts';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import { ExportSocieteComponent } from './export-societe/export-societe.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AgenceFrontComponent } from './agence/agence-front/agence-front.component';
import { BoiteFrontComponent } from './boite/boite-front/boite-front.component';
import { CategorieFrontComponent } from './categorie/categorie-front/categorie-front.component';
import { EnergieFrontComponent } from './energie/energie-front/energie-front.component';
import { MarqueFrontComponent } from './marque/marque-front/marque-front.component';
import { ModeleFrontComponent } from './modele/modele-front/modele-front.component';
import { SocieteFrontComponent } from './societe/societe-front/societe-front.component';
import { VehiculeFrontComponent } from './vehicule/vehicule-front/vehicule-front.component';


@NgModule({
  declarations: [
    AppComponent,
    AddBoiteComponent,
    ListBoiteComponent,
    UpdateBoiteComponent,
    AddCategorieComponent,
    ListCategorieComponent,
    UpdateCategorieComponent,
    ListEnergieComponent,
    AddEnergieComponent,
    UpdateEnergieComponent,
    ListMarqueComponent,
    AddMarqueComponent,
    UpdateMarqueComponent,
    ListSocieteComponent,
    AddSocieteComponent,
    UpdateSocieteComponent,
    ListAgenceComponent,
    AddAgenceComponent,
    UpdateAgenceComponent,
    ListModeleComponent,
    AddModeleComponent,
    UpdateModeleComponent,
    AddVehiculeComponent,
    ListVehiculeComponent,
    UpdateVehiculeComponent,
    StatistiquesComponent,
    ExportSocieteComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    AgenceFrontComponent,
    BoiteFrontComponent,
    CategorieFrontComponent,
    EnergieFrontComponent,
    MarqueFrontComponent,
    ModeleFrontComponent,
    SocieteFrontComponent,
    VehiculeFrontComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,   HttpClientModule, BrowserAnimationsModule,    MatSliderModule,ReactiveFormsModule, Ng2SearchPipeModule,Ng2OrderModule,NgxPaginationModule
    ,ChartsModule

  ],
  providers: [ListBoiteComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

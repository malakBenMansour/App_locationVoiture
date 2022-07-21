import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBoiteComponent } from './boite/add-boite/add-boite.component';
import { ListBoiteComponent } from './boite/list-boite/list-boite.component';
import { FormsModule } from '@angular/forms';
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
    UpdateAgenceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,   HttpClientModule, BrowserAnimationsModule,    MatSliderModule,

  ],
  providers: [ListBoiteComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

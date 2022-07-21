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

@NgModule({
  declarations: [
    AppComponent,
    AddBoiteComponent,
    ListBoiteComponent,
    UpdateBoiteComponent
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

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBoiteComponent } from './boite/add-boite/add-boite.component';
import { ListBoiteComponent } from './boite/list-boite/list-boite.component';
import { UpdateBoiteComponent } from './boite/update-boite/update-boite.component';

const routes: Routes = [{ path: '', redirectTo: 'boite', pathMatch: 'full' },
{ path: 'boites', component: ListBoiteComponent },
{ path: 'add', component: AddBoiteComponent },
{ path: 'update/:id', component: UpdateBoiteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

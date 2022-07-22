import { Component, OnInit } from '@angular/core';
import { Energie } from '../../model/energie';
import { EnergieService } from '../../service/energie.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-energie',
  templateUrl: './list-energie.component.html',
  styleUrls: ['./list-energie.component.scss']
})
export class ListEnergieComponent implements OnInit {

  energies: Observable<Energie[]> | undefined;

  constructor(private employeeService: EnergieService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.energies = this.employeeService.getEnergies();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEnergie(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['updateEnergie', id]);
  }



}

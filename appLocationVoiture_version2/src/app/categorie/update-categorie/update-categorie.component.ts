import { Component, OnInit } from '@angular/core';
import { Categorie } from '../../model/categorie';
import { ActivatedRoute, Router } from '@angular/router';
import { CategorieService } from '../../service/categorie.service';
@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.scss']
})
export class UpdateCategorieComponent implements OnInit {

  id!: number;
  employee!: Categorie;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: CategorieService) { }

  ngOnInit() {
    this.employee = new Categorie();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getCategorie(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateCategorie(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Categorie();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/categories']);
  }


}

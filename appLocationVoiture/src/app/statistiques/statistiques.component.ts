import { Component, OnInit, Version } from '@angular/core';
import { ChartOptions, ChartType } from 'chart.js';
import { Color, Label, SingleDataSet } from 'ng2-charts';
import { ITypePercentage } from '../interface/agence.interface';
import { AgenceService } from '../service/agence.service';
import { ChartConfiguration } from 'chart.js';
import { ITPercentage } from '../interface/vehicule.interface';
import { VehiculeService } from '../service/vehicule.service';

@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.scss']
})
export class StatistiquesComponent implements OnInit {

  public doughnutChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      display: false,
    },
    cutoutPercentage: 80,
  };


  public doughnutChartLabels: Label[] = [];
  public doughnutChartData: SingleDataSet = [];
  public doughnutChartType: ChartType = 'doughnut';
  public doughnutChartColor: Color[] = [
    { backgroundColor: ['#f68059', '#ffbf3a', '#4e3dc8'] },
  ];
  public typeData: Array<ITypePercentage> = [];


// *******************************

public barChartLabels: Label[] = [];
  public barChartData: SingleDataSet = [];
  public barChartType: ChartType = 'bar';
  public barChartColor: Color[] = [
    { backgroundColor: ['#6FA8DC', '#C27BA0', '#93C47D'] },
  ];
  public typeData1: Array<ITPercentage> = [];


public barChartLegend = true;
  public barChartPlugins = [];

  public barChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      display: false,
    },
    cutoutPercentage: 90,
  };

  constructor(private taskService:AgenceService,private vehiculeService:VehiculeService) { }

  ngOnInit(): void {
    this.getTypePercentage();
    this.getPercentage();
  }

  getTypePercentage() {
    this.doughnutChartData = [];
    this.doughnutChartLabels = [];
    this.taskService.getTypePercentage().subscribe(
      (d) => {
        // console.log(d);
        d.forEach((typeCount: ITypePercentage) => {
          console.log(typeCount.count);
          console.log(typeCount.adresse);
          this.doughnutChartData.push(typeCount.count);
          this.doughnutChartLabels.push(typeCount.adresse);
        });
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  getPercentage() {
    this.barChartData = [];
    this.barChartLabels = [];
    this.vehiculeService.getTypePercentage().subscribe(
      (d) => {
        // console.log(d);
        d.forEach((typeCount: ITPercentage) => {
          console.log(typeCount.count);
          console.log(typeCount.color);
          this.barChartData.push(typeCount.count);
          this.barChartLabels.push(typeCount.color);
        });
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

}

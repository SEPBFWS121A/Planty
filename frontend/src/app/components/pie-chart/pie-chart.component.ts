import { Component, Input, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
// import { ApiService } from 'src/app/services/api.service';
import { DefaultService } from 'src/assets/ts-api-client';

@Component({
  selector: 'app-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css'],
})
export class PieChartComponent implements OnInit {
  @Input() plantID: string = '';
  plant: any;
  moistureData: number = NaN;
  plantData: any;
  plantName: string = '';

  constructor(
    // private apiService: ApiService,
    private defaultService: DefaultService
  ) {}

  ngOnInit(): void {
    // this.apiService
    //   .moistureRecordByPlantPlantIdGet(this.plantID)
    //   .subscribe((result) => {
    //     this.plantData = result;
    //     if (this.plantData != null) {
    //       this.moistureData =
    //         this.plantData[this.plantData.length - 1].humidityLevel;
    //       this.renderChart();
    //     }
    //   });
    // this.apiService.plantPlantIdGet(this.plantID).subscribe((result) => {
    //   this.plant = result;
    //   this.plantName = this.plant[0].name;
    // });
    this.defaultService
      .moistureRecordByPlantPlantIdGet(this.plantID)
      .subscribe((result) => {
        this.plantData = result;
        if (this.plantData != null) {
          this.moistureData =
            this.plantData[this.plantData.length - 1].humidityLevel;
          this.renderChart();
        }
      });
    this.defaultService.plantPlantIdGet(this.plantID).subscribe((result) => {
      this.plant = result;
      this.plantName = this.plant.name;
    });
  }

  renderChart() {
    new Chart(this.plantName + 'pie', {
      type: 'doughnut',
      data: {
        labels: ['moistlevel'],
        datasets: [
          {
            label: 'Percent',
            data: [this.moistureData, 100 - this.moistureData],
            backgroundColor: ['rgb(54, 162, 235)', 'rgb(211,211,211)'],
            hoverOffset: 4,
          },
        ],
      },
    });
  }
}

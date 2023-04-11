import { Component, Input, OnInit } from '@angular/core';
import { Chart, registerables } from 'node_modules/chart.js';
// import { ApiService } from 'src/app/services/api.service';
import { DefaultService } from 'src/assets/ts-api-client';
Chart.register(...registerables);

@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css'],
})
export class LineChartComponent implements OnInit {
  @Input() plantID: string = '';
  plantData: any;
  plant: any;
  lableData: any[] = [];
  moistureData: any[] = [];
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
    //       for (
    //         let i = this.plantData.length - 20;
    //         i < this.plantData.length;
    //         i++
    //       ) {
    //         //this.plantData.length
    //         console.log();
    //         this.lableData.push(this.plantData[i].timestamp.substring(0, 10));
    //         this.moistureData.push(this.plantData[i].humidityLevel);
    //       }
    //       this.renderChart(this.lableData, this.moistureData);
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
          for (
            let i = this.plantData.length - 20;
            i < this.plantData.length;
            i++
          ) {
            this.lableData.push(this.plantData[i].timestamp.substring(0, 10));
            this.moistureData.push(this.plantData[i].humidityLevel);
          }
          this.renderChart(this.lableData, this.moistureData);
        }
      });
    this.defaultService.plantPlantIdGet(this.plantID).subscribe((result) => {
      this.plant = result;
      this.plantName = this.plant.name;
    });
  }

  renderChart(lableData: any, moistureData: any) {
    new Chart(this.plantName + 'line', {
      type: 'line',
      data: {
        labels: lableData,
        datasets: [
          {
            label: this.plantName,
            data: moistureData,
            borderWidth: 1,
            fill: 'start',
            backgroundColor: 'rgba(39, 131, 245, 0.27)',
          },
        ],
      },
      options: {
        responsive: true,
        scales: {
          y: {
            beginAtZero: true,
            max: 100,
          },

          //     x: {
          //       beginAtZero: true,
          //     },
        },
      },
    });
  }
}

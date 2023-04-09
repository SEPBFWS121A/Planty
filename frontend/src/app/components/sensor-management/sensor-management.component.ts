import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-sensor-management',
  templateUrl: './sensor-management.component.html',
  styleUrls: ['./sensor-management.component.css'],
})
export class SensorManagementComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'name',
    'description',
    'humidityScalingFrom',
    'humidityScalingTo',
    'lastCalibration',
    'sleepTimeout',
  ];
  data: any;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.sensorGet().subscribe((result) => {
      this.data = result;
    });
  }
}

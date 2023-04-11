import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
// import { ApiService } from 'src/app/services/api.service';
import { DefaultService } from 'src/assets/ts-api-client';

@Component({
  selector: 'app-plant-management',
  templateUrl: './plant-management.component.html',
  styleUrls: ['./plant-management.component.css'],
})
export class PlantManagementComponent implements OnInit {
  selectedFW = new FormControl();
  categories: string[] = ['Category 1', 'Category 2', 'Category 3'];
  sensors: string[] = ['Sensor 1', 'Sensor 2', 'Sensor 3'];

  displayedColumns: string[] = [
    'id',
    'name',
    'description',
    'category',
    'sensor',
  ];
  data: any;

  constructor(
    private defaultService: DefaultService // private apiService: ApiService
  ) {}
  ngOnInit(): void {
    this.defaultService.plantGet().subscribe((result) => {
      this.data = result;
    });
    // this.apiService.plantGet().subscribe((result) => {
    //   this.data = result;
    // });
  }
}

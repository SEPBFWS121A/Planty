import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-plant-managemnet',
  templateUrl: './plant-managemnet.component.html',
  styleUrls: ['./plant-managemnet.component.css'],
})
export class PlantManagemnetComponent implements OnInit {
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

  constructor(private apiService: ApiService) {}
  ngOnInit(): void {
    this.apiService.plantGet().subscribe((result) => {
      this.data = result;
    });
  }
}

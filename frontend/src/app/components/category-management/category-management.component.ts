import { Component, OnInit } from '@angular/core';
// import { ApiService } from 'src/app/services/api.service';
import { DefaultService } from 'src/assets/ts-api-client';

@Component({
  selector: 'app-category-management',
  templateUrl: './category-management.component.html',
  styleUrls: ['./category-management.component.css'],
})
export class CategoryManagementComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'name',
    'description',
    'minHumidityLevel',
  ];
  data: any;

  constructor(
    private defaultService: DefaultService
  ) // private apiService: ApiService
  {}

  ngOnInit(): void {
    this.defaultService.plantTypeGet().subscribe((result) => {
      this.data = result;
    });
    // this.apiService.plantTypeGet().subscribe((result) => {
    //   this.data = result;
    // });
  }
}

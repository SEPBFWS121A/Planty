import { Component, OnInit } from '@angular/core';
// import { ApiService } from 'src/app/services/api.service';
import { DefaultService, PlantTypePayload } from 'src/assets/ts-api-client';

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
    'delete',
  ];
  data: any;
  width: number = 0;
  tempDescription: string = '';
  category: PlantTypePayload = {};
  showData: boolean = false;

  constructor(
    private defaultService: DefaultService // private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.defaultService.plantTypeGet().subscribe((result) => {
      this.data = result;
    });
    this.width = window.innerWidth > 0 ? window.innerWidth : screen.width;
    // this.apiService.plantTypeGet().subscribe((result) => {
    //   this.data = result;
    // });
  }
  async saveCategory(
    name: string,
    description: string,
    minHumidityLevel: string
  ) {
    this.category.name = name;
    this.category.description = description;
    this.category.minHumidityLevel = Number(minHumidityLevel);
    this.defaultService.plantTypePost(this.category).subscribe({
      next(answer) {
        location.reload();
      },
      error(msg) {
        console.log('Error posting category: ', msg);
      },
    });
  }

  async deleteItem(data: any) {
    await this.defaultService.plantTypePlantTypeIdDelete(data.id).subscribe({
      next(answer) {
        location.reload();
      },
      error(msg) {
        console.log('Error posting category: ', msg);
      },
    });
  }

  showMoreData(description: string) {
    this.tempDescription = description;
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth',
    });
  }
}

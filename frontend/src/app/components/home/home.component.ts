import { Component, OnInit } from '@angular/core';
import { DefaultService } from 'src/assets/ts-api-client';
// import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  plants: any;

  constructor(
    private defaultService: DefaultService // private apiService: ApiService
  ) {}

  ngOnInit(): void {
    this.defaultService.plantGet().subscribe((result) => {
      this.plants = result;
    });
    // this.apiService.plantGet().subscribe((result) => {
    //   this.plants = result;
    // });
  }
}

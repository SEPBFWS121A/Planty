import { Injectable } from '@angular/core';

import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable()
export class ApiService {
  baseURL: string = 'https://api.github.com/';

  constructor(private http: HttpClient) {}

  getRepos(endPoint: string | undefined): Observable<any> {
    return this.http.get(this.baseURL + endPoint);
  }

  moistureRecordByPlantPlantIdGet(id: string) {
    return this.http.get('http://localhost:3000/moistureRecordbyPlant' + id);
  }

  plantPlantIdGet(id: string) {
    return this.http.get('http://localhost:3000/plant' + id);
  }

  sensorGet() {
    return this.http.get('http://localhost:3000/sensor');
  }

  plantTypeGet() {
    return this.http.get('http://localhost:3000/plantType');
  }

  plantGet() {
    return this.http.get('http://localhost:3000/plant');
  }
}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlantInfoComponent } from './plantinfo-dialog.component';

describe('PlantInfoComponent', () => {
  let component: PlantInfoComponent;
  let fixture: ComponentFixture<PlantInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlantInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlantInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

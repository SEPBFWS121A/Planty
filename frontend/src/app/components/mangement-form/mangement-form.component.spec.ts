import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MangementFormComponent } from './mangement-form.component';

describe('MangementFormComponent', () => {
  let component: MangementFormComponent;
  let fixture: ComponentFixture<MangementFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MangementFormComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MangementFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
});

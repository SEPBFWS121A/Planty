import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterComponent } from './footer.component';

describe('FooterComponent', () => {
  let component: FooterComponent;
  let fixture: ComponentFixture<FooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FooterComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should contain the GitHub link', () => {
    const bannerElement: HTMLElement = fixture.nativeElement;
    const a = bannerElement.querySelectorAll('a')!;
    expect(a.item(a.length - 1).href).toEqual('https://github.com/SEPBFWS121A/Planty');
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderComponent } from './header.component';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HeaderComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should have img sunflower', () => {
    const bannerElement: HTMLElement = fixture.nativeElement;
    const img = bannerElement.querySelector('img')!;
    expect(img.src).toEqual('https://openmoji.org/data/color/svg/1F33B.svg');
  });
});

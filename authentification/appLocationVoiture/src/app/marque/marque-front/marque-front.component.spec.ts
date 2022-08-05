import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarqueFrontComponent } from './marque-front.component';

describe('MarqueFrontComponent', () => {
  let component: MarqueFrontComponent;
  let fixture: ComponentFixture<MarqueFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MarqueFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MarqueFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergieFrontComponent } from './energie-front.component';

describe('EnergieFrontComponent', () => {
  let component: EnergieFrontComponent;
  let fixture: ComponentFixture<EnergieFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnergieFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnergieFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

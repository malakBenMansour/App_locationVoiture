import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeFrontComponent } from './vehicule-front.component';

describe('VehiculeFrontComponent', () => {
  let component: VehiculeFrontComponent;
  let fixture: ComponentFixture<VehiculeFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehiculeFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiculeFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

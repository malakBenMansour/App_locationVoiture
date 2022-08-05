import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoiteFrontComponent } from './boite-front.component';

describe('BoiteFrontComponent', () => {
  let component: BoiteFrontComponent;
  let fixture: ComponentFixture<BoiteFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoiteFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoiteFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

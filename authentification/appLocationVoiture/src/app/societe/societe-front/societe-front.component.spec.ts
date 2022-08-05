import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocieteFrontComponent } from './societe-front.component';

describe('SocieteFrontComponent', () => {
  let component: SocieteFrontComponent;
  let fixture: ComponentFixture<SocieteFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SocieteFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SocieteFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

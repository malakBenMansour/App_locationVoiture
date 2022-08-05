import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategorieFrontComponent } from './categorie-front.component';

describe('CategorieFrontComponent', () => {
  let component: CategorieFrontComponent;
  let fixture: ComponentFixture<CategorieFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategorieFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategorieFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

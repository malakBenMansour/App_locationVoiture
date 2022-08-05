import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeleFrontComponent } from './modele-front.component';

describe('ModeleFrontComponent', () => {
  let component: ModeleFrontComponent;
  let fixture: ComponentFixture<ModeleFrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModeleFrontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModeleFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

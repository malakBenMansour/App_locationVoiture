import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBoiteComponent } from './add-boite.component';

describe('AddBoiteComponent', () => {
  let component: AddBoiteComponent;
  let fixture: ComponentFixture<AddBoiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBoiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddBoiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBoiteComponent } from './update-boite.component';

describe('UpdateBoiteComponent', () => {
  let component: UpdateBoiteComponent;
  let fixture: ComponentFixture<UpdateBoiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBoiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateBoiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

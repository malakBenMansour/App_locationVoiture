import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEnergieComponent } from './add-energie.component';

describe('AddEnergieComponent', () => {
  let component: AddEnergieComponent;
  let fixture: ComponentFixture<AddEnergieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEnergieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEnergieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEnergieComponent } from './update-energie.component';

describe('UpdateEnergieComponent', () => {
  let component: UpdateEnergieComponent;
  let fixture: ComponentFixture<UpdateEnergieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEnergieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateEnergieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

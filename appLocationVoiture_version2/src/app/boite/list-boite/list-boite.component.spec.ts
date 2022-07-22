import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBoiteComponent } from './list-boite.component';

describe('ListBoiteComponent', () => {
  let component: ListBoiteComponent;
  let fixture: ComponentFixture<ListBoiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBoiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListBoiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportSocieteComponent } from './export-societe.component';

describe('ExportSocieteComponent', () => {
  let component: ExportSocieteComponent;
  let fixture: ComponentFixture<ExportSocieteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExportSocieteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExportSocieteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

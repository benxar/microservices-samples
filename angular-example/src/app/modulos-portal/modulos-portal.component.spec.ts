import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModulosPortalComponent } from './modulos-portal.component';

describe('ModulosPortalComponent', () => {
  let component: ModulosPortalComponent;
  let fixture: ComponentFixture<ModulosPortalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModulosPortalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModulosPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

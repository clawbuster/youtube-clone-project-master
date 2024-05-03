import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JspContainerComponent } from './jsp-container.component';

describe('JspContainerComponent', () => {
  let component: JspContainerComponent;
  let fixture: ComponentFixture<JspContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JspContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JspContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

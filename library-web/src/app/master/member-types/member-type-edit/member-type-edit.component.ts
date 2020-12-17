import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-member-type-edit',
  templateUrl: './member-type-edit.component.html',
  styles: [
  ]
})
export class MemberTypeEditComponent{
  form: FormGroup;

  @Input()
  set data(data: any) {
    if (data) this.form.patchValue(data);
    else this.form.reset();
  }

  @Output()
  saveListener = new EventEmitter();

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      id: 0,
      name: ['', Validators.required],
      duration: 1,
      noOfBook: 1
    });
  }

  save() {
    this.saveListener.emit(this.form.value);
    this.form.reset();
  }

  get edit() {
    return this.form.get('id')?.value > 0;
  }
}

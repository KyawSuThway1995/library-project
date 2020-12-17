import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-member-edit',
  templateUrl: './member-edit.component.html',
  styles: [
  ]
})
export class MemberEditComponent{

  @Input() memberTypes: any[] = [];

  @Input()
  set data(data: any) {
    if (data) {
      this.form.patchValue(data);
    } else {
      this.form.reset();
    }
  }

  @Output('saveListener')
  emtter = new EventEmitter();

  form: FormGroup;

  constructor(builder: FormBuilder) {
    this.form = builder.group({
      id: 0,
      name: ['', Validators.required],
      memberType: null,
      email: '',
      phone: '',
      address: '',
    });
  }

  save() {
    this.emtter.emit(this.form.value);
    this.form.reset();
  }

  get edit() {
    return this.form.get('id')?.value > 0;
  }

  equals(membType1: any, membType2: any){
    return membType1?.id === membType2?.id;
  }
}

import { MemberTypeService } from './../../common/services/member-type.service';
import { Component, OnInit } from '@angular/core';

declare const $: any;

@Component({
  templateUrl: './member-types.component.html',
  styles: [],
})
export class MemberTypesComponent implements OnInit {
  list: any[] = [];
  target: any;

  constructor(private service: MemberTypeService) {
    this.reload();
  }

  ngOnInit() {
    $('#editDialog').on('hidden.bs.modal', () => (this.target = null));
  }

  addNew() {
    $('#editDialog').modal('show');
  }

  edit(data: any) {
    this.target = data;
    $('#editDialog').modal('show');
  }

  save(data: any) {
    this.service.save(data).subscribe(() => this.reload());
    $('#editDialog').modal('hide');
  }

  private reload() {
    this.service.findAll().subscribe((data) => (this.list = data));
  }
}

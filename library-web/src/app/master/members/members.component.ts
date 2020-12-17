import { FormGroup, FormBuilder } from '@angular/forms';
import { MemberService } from './../../common/services/member.service';
import { MemberTypeService } from './../../common/services/member-type.service';
import { Component } from '@angular/core';

declare const $: any;

@Component({
  templateUrl: './members.component.html',
  styles: [],
})
export class MembersComponent {
  memberTypes: any[] = [];
  members: any[] = [];

  form: FormGroup;

  targetData: any;
  totalPages: any;

  constructor(
    fb: FormBuilder,
    mtSrv: MemberTypeService,
    private mSrv: MemberService
  ) {
    this.form = fb.group({
      memberTypeId: 0,
      name: '',
      size: 5,
    });

    mtSrv.findAll().subscribe((data) => (this.memberTypes = data));
    this.search();
  }

  ngOnInit() {
    $('#editDialog').on('hidden.bs.modal', () => (this.targetData = null));
  }

  addNew() {
    $('#editDialog').modal('show');
  }

  edit(data: any) {
    this.targetData = data;
    $('#editDialog').modal('show');
  }

  save(data: any) {
    this.mSrv.save(data).subscribe(() => this.search());
    $('#editDialog').modal('hide');
  }

  setPage(page: any) {
    this.search(page);
  }

  search(page?: any) {
    this.mSrv.search(this.form.value, page).subscribe((result) => {
      this.members = result.content;
      this.totalPages = result.totalPages;
    });
  }
}

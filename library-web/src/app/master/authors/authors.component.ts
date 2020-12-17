import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthorService } from 'src/app/common/services/author.service';

declare var $: any;

@Component({
  templateUrl: './authors.component.html',
  styles: [],
})
export class AuthorsComponent {
  form: FormGroup;
  list: any[] = [];
  totalPages: any;
  targetData: any;

  constructor(buider: FormBuilder, private service: AuthorService) {
    this.form = buider.group({
      name: '',
      jobTitle: '',
      size: 1,
    });

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
    this.service.save(data).subscribe(() => this.search());
    $('#editDialog').modal('hide');
  }

  search(page?: any) {
    this.service.search(this.form.value, page).subscribe((result) => {
      this.list = result.content;
      this.totalPages = result.totalPages;
    });
  }

  setPage(page: any) {
    this.search(page);
  }

  export() {}
}

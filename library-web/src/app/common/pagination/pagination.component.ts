import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styles: [
    `
      li {
        cursor: pointer;
      }
    `,
  ],
})
export class PaginationComponent {
  currentPage = 1;

  @Input() totalPages: any;

  @Output() pageChanged = new EventEmitter();

  getPages() {
    let startPage, endPage;
    let pages = [];

    if (this.totalPages <= 10 || this.currentPage <= 6) {
      startPage = 1;
      endPage = this.totalPages;
    } else {
      if (this.currentPage + 4 >= this.totalPages) {
        startPage = this.totalPages - 9;
        endPage = this.totalPages;
      } else {
        startPage = this.currentPage - 4;
        endPage = this.currentPage + 5;
      }
    }

    for (let i = startPage; i <= endPage; i++) {
      pages.push(i);
    }

    return pages;
  }

  setPage(page: any) {
    if (page < 0 || page > this.totalPages) return;

    this.currentPage = page;
    this.pageChanged.emit(page - 1);
  }
}

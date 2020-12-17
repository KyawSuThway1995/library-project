import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { PaginationComponent } from './pagination/pagination.component';

@NgModule({
  declarations: [PaginationComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [PaginationComponent]
})
export class CommonsModule { }

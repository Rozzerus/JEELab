import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookEditorComponent} from './book/book.editor.component';
import {BooksListComponent} from './books/books.list.component';

const routes: Routes = [
  // { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: '', component: BooksListComponent },
  { path: 'detail/:id', component: BookEditorComponent },

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

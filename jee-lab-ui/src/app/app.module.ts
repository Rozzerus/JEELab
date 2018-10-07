import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BookEditorComponent} from './book/book.editor.component';
import {BooksListComponent} from './books/books.list.component';
import {HttpClientModule} from "@angular/common/http";
import {MessagesComponent} from './messages/messages.component';
import {FormsModule} from "@angular/forms";
//import { InMemoryDataService }  from './in-memory-data.service';
import {AppRoutingModule} from './app-routing.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    BookEditorComponent,
    BooksListComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, AppRoutingModule, NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [ BookEditorComponent ]
})
export class AppModule { }

import {Component, OnInit} from '@angular/core';
import {BookService} from "../services/book.service";
import {Book} from "../model/book";

@Component({
  selector: 'books-list',
  templateUrl: './books.list.component.html',
})
export class BooksListComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.bookService.getBooks().subscribe(books => this.books = books);
  }

  delete(book: Book): void {
    this.books = this.books.filter(h => h !== book);
    this.bookService.deleteBook(book).subscribe();
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.bookService.postBook({ name } as Book)
      .subscribe(book => {
        this.books.push(book);
      });
  }



}

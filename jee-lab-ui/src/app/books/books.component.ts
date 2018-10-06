import {Component, OnInit} from '@angular/core';
import {BookService} from "../services/book.service";
import {Book} from "../model/book";

@Component({
  selector: 'books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.bookService.getBooks().subscribe(books => this.books = books);
  }

}

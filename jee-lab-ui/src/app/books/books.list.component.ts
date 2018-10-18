import {Component, OnInit} from '@angular/core';
import {BookService} from "../services/book.service";
import {Book} from "../model/book";

@Component({
  selector: 'books-list',
  templateUrl: './books.list.component.html',
})
export class BooksListComponent implements OnInit {
  page : number = 0;
  books: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.getBooks();
  }

  getBooks(){
    this.bookService.getBooks(this.page).subscribe(data =>
    {
      console.log(data);
    },
      (error)=>{
      console.log(error.error.message);
      });
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

  setPage(i,event:any){

    event.preventDefault();
    this.page = i;
    this.getBooks();
  }

}

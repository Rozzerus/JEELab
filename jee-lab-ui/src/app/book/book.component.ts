import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../model/book";
import {GenreService} from "../services/genre.service";
import {BookService} from "../services/book.service";

@Component({
  selector: 'book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  private bookService: BookService;

  genres: String[];

  @Input() book: Book;


  constructor(genreService: GenreService, bookService: BookService) {
    this.bookService = bookService;
    genreService.getGenres().subscribe((value : String[]) => {
      this.genres = value;
    });
  }

  ngOnInit() {
  }

  save(){
    if (this.book.id == null){
      this.bookService.postBook(this.book);
    } else {
      this.bookService.putBook(this.book);
    }
  }

}

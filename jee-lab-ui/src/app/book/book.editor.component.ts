import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../model/book";
import {GenreService} from "../services/genre.service";
import {BookService} from "../services/book.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'book-editor',
  templateUrl: './book.editor.component.html',
})
export class BookEditorComponent implements OnInit {

  genres: String[];

  @Input() book: Book;


  constructor(genreService: GenreService, private bookService: BookService, private modalService: NgbModal) {
    genreService.getGenres().subscribe((value : String[]) => {
      this.genres = value;
    });
  }

  ngOnInit() {
  }


  open(){
    if (this.book ==null){
      this.book= new Book();
    }
    this.modalService.open(this.book, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.book = result;
      this.save();
    }, (reason) => {
      this.book = reason;
    });
  }

  save(){
    if (this.book.id == null){
      this.bookService.postBook(this.book);
    } else {
      this.bookService.putBook(this.book);
    }
  }

}

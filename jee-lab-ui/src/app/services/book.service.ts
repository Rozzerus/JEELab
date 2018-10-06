import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Book} from "../model/book";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private url = 'book';

  constructor(private http: HttpClient) {
  }


  /** GET all books */
  getBooks (): Observable<Book[]> {
    return this.http.get<Book[]>(this.url+"/all").pipe(
        map(this.extractData)
      );
  }

  /** GET book by id.  */
  getBook(id: number): Observable<Book> {
    return this.http.get<Book>(this.url).pipe(
      map(this.extractData)
    );
  }

  /** POST new book   */
  postBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.url, book).pipe(
      map(this.extractData)
    );
  }

  /** PUT book by id.  */
  putBook(book: Book): Observable<Book> {
    return this.http.put<Book>(this.url, book).pipe(
      map(this.extractData)
    );
  }

  public extractData(res: Response) {
    let body = res;
    return body || { };
  }


}

import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Book} from "../model/book";
import {catchError, tap} from 'rxjs/operators';
import {MessageService} from './message.service';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private url = 'book';

  constructor(private http: HttpClient,
              private messageService: MessageService) {
  }


  /** GET all books */
  getBooks (): Observable<Book[]> {
    return this.http.get<Book[]>(this.url+"/all")
      .pipe(
        tap(books => this.log('fetched book')),
        catchError(this.handleError('getBooks', []))
      );
  }

  /** GET book by id.  */
  getBook(id: number): Observable<Book> {
    const url = `${this.url}/${id}`;
    return this.http.get<Book>(url).pipe(
      tap(_ => this.log(`fetched book id=${id}`)),
      catchError(this.handleError<Book>(`getBook id=${id}`))
    );
  }

  /** POST new book   */
  postBook(book: Book): Observable<Book> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post<Book>(this.url, book, httpOptions).pipe(
      tap((book: Book) => this.log(`added Book w/ id=${book.id}`)),
      catchError(this.handleError<Book>('addBook'))
    );
  }

  /** PUT book by id.  */
  putBook(book: Book): Observable<Book> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.put(this.url, book, httpOptions).pipe(
      tap(_ => this.log(`updated book id=${book.id}`)),
      catchError(this.handleError<any>('updateBook'))
    );
  }
 /** Search book by name*/
  searchBooks(term: string): Observable<Book[]> {
    if (!term.trim()) {
      // if not search term, return empty book array.
      return of([]);
    }
    return this.http.get<Book[]>(`${this.url}/?name=${term}`).pipe(
      tap(_ => this.log(`found Book matching "${term}"`)),
      catchError(this.handleError<Book[]>('searchBooks', []))
    );
  }

  deleteBook (book: Book | number): Observable<Book> {
    const id = typeof book === 'number' ? book : book.id;
    const url = `${this.url}/${id}`;
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.delete<Book>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted book id=${id}`)),
      catchError(this.handleError<Book>('deleteBook'))
    );
  }

  public extractData(res: Response) {
    let body = res;
    return body || { };
  }

  /** Write messages as logs */
  private log(message: string) {
    this.messageService.add(`BookService: ${message}`);
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


}

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {map} from "rxjs/internal/operators";
import {AbstractService} from "./abstract.service";

@Injectable({
  providedIn: 'root'
})
export class GenreService extends AbstractService {

  private url = 'genre';

  constructor(private http: HttpClient) { super()}


  /** GET all genres */
  getGenres (): Observable<String[]> {
    return this.http.get<String[]>(this.url+"/all").pipe(
      map(this.extractData)
    );
  }


}

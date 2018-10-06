import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  private url = 'genre';

  constructor(private http: HttpClient) { }


  /** GET all genres */
  getGenres (): Observable<String[]> {
    return this.http.get<String[]>(this.url+"/all").pipe(
      map(this.extractData)
    );
  }

  public extractData(res: Response) {
    let body = res;
    return body || { };
  }


}

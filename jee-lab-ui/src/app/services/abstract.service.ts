import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AbstractService {

  constructor() { }

  public extractData(res: Response) {
    let body = res;
    return body || { };
  }


}

import { Injectable } from '@angular/core';
import { BehaviorSubject} from'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchserviceService {
  public updateName: BehaviorSubject<string>=new BehaviorSubject<string>('')
  

  constructor() { }

 
  }


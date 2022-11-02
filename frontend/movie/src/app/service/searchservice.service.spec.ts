import { TestBed } from '@angular/core/testing';

import { SearchserviceService } from './searchservice.service';

describe('SearchserviceService', () => {
  let service: SearchserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ForexServiceService } from './forex-service.service';

describe('ForexServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForexServiceService = TestBed.get(ForexServiceService);
    expect(service).toBeTruthy();
  });
});

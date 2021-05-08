import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { facturas } from '../models/facturas';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {


  constructor(private http: HttpClient) { }

  Url='http://localhost:9000//api/v1/factura/all';

  getFacturas(){
    return this.http.get<facturas[]>(this.Url);
  }

}

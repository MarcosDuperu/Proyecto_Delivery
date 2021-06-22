import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { detalleFactura } from '../models/detalleFactura';

@Injectable({
  providedIn: 'root'
})
export class DetalleFacturaService {

  detalleFactura: detalleFactura[];
  constructor(private http: HttpClient) { }


  listarId='http://localhost:9000/api/v1/detallefactura/all';

  getDetalleId(){
    return this.http.get<detalleFactura[]>(this.listarId);
  }


}

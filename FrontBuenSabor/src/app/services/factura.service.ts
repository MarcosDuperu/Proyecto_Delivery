import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from '../models/factura';

@Injectable({
  providedIn: 'root',
})
export class FacturaService {
  facturas: Factura[];
  constructor(private http: HttpClient) {}

  url = 'http://localhost:9000/api/v1/factura'

  getFacturas() {
    return this.http.get<Factura[]>(this.url);
  }
  getFacturasbyNumero(numero: Factura) {
    return this.http.get<Factura[]>(`${this.url}/${numero}`);
  }
  createFactura(factura: Factura[]) {
    return this.http.post<Factura[]>(this.url, factura);
  }
  deleteFacturas(factura: Factura): Observable<Object> {
    return this.http.delete(`${this.url}/${factura.numero}`);
  }
  editarFactura(factura: Factura) {
    return this.http.put<Factura[]>(
      `${this.url}/${factura.numero}`,
      factura
    );
  }
}

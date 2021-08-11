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

  listar = 'http://localhost:9000/api/v1/factura/all';
  listarId = 'http://localhost:9000/api/v1/factura';
  delete = 'http://localhost:9000/api/v1/factura/id';

  getFacturas() {
    return this.http.get<Factura[]>(this.listar);
  }
  getFacturasbyNumero(numero: Factura) {
    return this.http.get<Factura[]>(this.listarId + '/' + numero);
  }
  createFactura(facturas: Factura[]) {
    return this.http.post<Factura[]>(this.listarId, facturas);
  }
  deleteFacturas(facturas: Factura): Observable<Object> {
    return this.http.delete(this.listarId + '/' + facturas.numero);
  }
  editarFactura(facturas: Factura) {
    return this.http.put<Factura[]>(
      this.listarId + '/' + facturas.numero,
      facturas
    );
  }
}

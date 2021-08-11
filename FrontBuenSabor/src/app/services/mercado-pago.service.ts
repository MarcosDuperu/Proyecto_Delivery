import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from '../models/factura';
import { Preferencia } from '../models/Preferencia';

@Injectable({
  providedIn: 'root',
})
export class MercadoPagoService {
  //editar base endpoint, crear back
  protected baseEndpoint = 'http://localhost:9000/api/v1/mpago';
  protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient) {}
  public procesarPago(
    factura: Factura,
    cantidad: number
  ): Observable<Preferencia> {
    return this.http.post<Preferencia>(
      `${this.baseEndpoint}/efectuarpago`,
      factura,
      {
        headers: this.cabeceras,
      }
    );
  }
}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticuloInsumo } from '../models/ArticuloInsumo';
import { ArticuloMfact } from '../models/ArticuloMfact';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root',
})
export class ProductosService {
  protected url = 'http://localhost:9000/api/v1';
  /* protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer 
  }); */
  constructor(private httpClient: HttpClient, private tokenService: TokenService) {}

  public getLikeArtInsumo(): Observable<ArticuloInsumo[]> {
    return this.httpClient.get<ArticuloInsumo[]>(
      this.url + '/articuloinsumo/like'
    );
  }

  public getArtInsumoById(id: number): Observable<ArticuloInsumo> {
    return this.httpClient.get<ArticuloInsumo>(
      `${this.url}/articuloinsumo/${id}`
    );
  }
  public getLikeArtMfact(): Observable<ArticuloMfact[]> {
    return this.httpClient.get<ArticuloMfact[]>(
      this.url + '/articulomanufaturado/like'
    );
  }
  public getArtMfactById(id: number): Observable<ArticuloMfact> {
    return this.httpClient.get<ArticuloMfact>(
      `${this.url}/articulomanufaturado/${id}`
    );
  }

  public postArtInsumo(insumo: ArticuloInsumo): Observable<ArticuloInsumo> {
    const token = this.tokenService.getToken();
    return this.httpClient.post<ArticuloInsumo>(`${this.url}/articuloinsumo`,
    insumo,
    {headers: 
       new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      })
    })
  }
}

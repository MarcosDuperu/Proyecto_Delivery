import { ArticuloInsumo } from './ArticuloInsumo';
import { ArticuloMfact } from './ArticuloMfact';
import { Factura } from './factura';

export class DetalleFactura {
  id: number;
  cantidad: number;
  subtotal: number;
  articuloMfact: ArticuloMfact;
  articuloInsumo: ArticuloInsumo;
  factura: Factura;
}

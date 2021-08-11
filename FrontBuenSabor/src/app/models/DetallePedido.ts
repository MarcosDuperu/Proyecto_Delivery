import { ArticuloInsumo } from './ArticuloInsumo';
import { ArticuloMfact } from './ArticuloMfact';
import { Pedido } from './Pedido';

export class detallePedido {
  id: number;
  cantidad: number;
  subtotal: number;
  articuloInsumo: ArticuloInsumo;
  articulomfact: ArticuloMfact;
  pedido: Pedido;
}

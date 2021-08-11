import { Cliente } from './Cliente';
import { detallePedido } from './DetallePedido';
import { Domicilio } from './domicilio';
import { Factura } from './factura';
import { mercadoPagoDatos } from './MercadoPagoDatos';

export class Pedido {
  id: number;
  estado: string;
  horaEstimadafin: Date;
  tipoEnvio: string;
  total: number;
  fecha: Date;
  detallesPedido: detallePedido;
  factura: Factura;
  cliente: Cliente;
  domicilio: Domicilio;
  mercadoPagoDatos: mercadoPagoDatos;
}

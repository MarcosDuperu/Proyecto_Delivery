import { DetalleFactura } from './detalleFactura';
import { Pedido } from './Pedido';
import { Usuario } from './Usuario';

export class Factura {
  fecha: Date;
  numero: number;
  montoDescuento: number;
  formaPago: string;
  nroTarjeta: string;
  totalVenta: number;
  totalCosto: number;
  detalleFactura: DetalleFactura;
  pedido: Pedido;
  usuario: Usuario; /* Devería cambiarlo por Cliente */
}

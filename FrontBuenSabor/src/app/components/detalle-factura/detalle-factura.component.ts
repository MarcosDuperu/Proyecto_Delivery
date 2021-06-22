import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { detalleFactura } from '../../models/detalleFactura';
import { DetalleFacturaService } from '../../services/detalle-factura.service';
import { facturas } from '../../models/facturas';

@Component({
  selector: 'app-detalle-factura',
  templateUrl: './detalle-factura.component.html',
  styleUrls: ['./detalle-factura.component.css']
})
export class DetalleFacturaComponent implements OnInit {
  detalleFactura: detalleFactura[];
  factura:facturas[];
  constructor(private router: Router,private DetalleFacturaService: DetalleFacturaService) { }

  ngOnInit(): void {
    
    let id= localStorage.getItem('id')
    //Arreglar pasar por parametro id
 this.DetalleFacturaService.getDetalleId().subscribe((data) => {
     this.detalleFactura = data; });
    
  

 }

}

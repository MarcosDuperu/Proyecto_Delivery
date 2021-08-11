import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FacturaService } from 'src/app/services/factura.service';
import { Factura } from '../../../models/factura';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
})
export class UpdateComponent implements OnInit {
  factura: Factura = new Factura();
  constructor(private router: Router, private FacturaService: FacturaService) {}

  ngOnInit(): void {}

  Guardar(factura) {
    this.FacturaService.editarFactura(factura).subscribe((data) => {
      alert('Factura editada con exito!');
      this.router.navigate(['facturas']);
    });
  }
}

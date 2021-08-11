import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Factura } from 'src/app/models/factura';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  factura: Factura = new Factura();
  constructor(private router: Router, private FacturaService: FacturaService) {}

  ngOnInit(): void {}

  Guardar(factura) {
    this.FacturaService.createFactura(factura).subscribe((data) => {
      alert('Factura añadida con exito!');
      this.router.navigate(['facturas']);
    });
  }
}

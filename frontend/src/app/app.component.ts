import { Component, OnInit } from '@angular/core';

import { ApiService } from 'src/core/services/api.service';
import { Product } from 'src/@types/app/index';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  products: Product[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.apiService.getProducts().subscribe((response) => {
      this.products = response;
    });
  }

  fetch(e: KeyboardEvent) {
    const techName = (e.target as HTMLInputElement).value;
    if(techName !== "") {
      this.apiService.getProductsByTech(techName).subscribe((response) => {
        this.products = response.flatMap(tech => tech.products);
      })
    } else {
      this.getAllProducts();
    }
  }
}

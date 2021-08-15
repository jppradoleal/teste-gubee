import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Product, TechProduct } from 'src/@types/app/index';

import { ApiService } from 'src/core/services/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  products: Product[] = [];
  techs: string[] = [];
  form: FormGroup | undefined;

  constructor(private fb: FormBuilder, private apiService: ApiService) {}

  ngOnInit() {
    this.form = this.fb.group({
      techs: this.fb.array([])
    })

    this.apiService.getProducts().subscribe((response) => {
      this.products = response;
      const techNames = response
        .flatMap(product => product.techs)
        .map(tech => tech.name);
      this.techs = Array.from(new Set(techNames));
    });
  }

  fetch(e: KeyboardEvent) {
    const techName = (e.target as HTMLInputElement).value;
    if(techName !== "") {
      this.apiService.getProductsByTech(techName).subscribe((response) => {
        this.products = response.flatMap(tech => tech.products);
      });
    } else {
      this.apiService.getProducts().subscribe((response) => {
        this.products = response;
      });
    }
  }

  onChange(tech: string, target: EventTarget | null) {
    const isChecked = (target as HTMLInputElement).checked; 
    const techFormArray = this.form?.controls.techs as FormArray;

    if(isChecked) {
      techFormArray.push(new FormControl(tech));
    } else {
      let index = techFormArray.controls.findIndex(x => x.value == tech);
      techFormArray.removeAt(index);
    }

    const techNames = this.form?.value.techs.join();

    this.apiService.getProductsByTech(techNames).subscribe((response) => {
      const productsByTech = response.flatMap(tech => tech.products);
      const uniqueProducts = [...new Map(productsByTech.map(item => [item["name"], item])).values()];
      this.products = uniqueProducts;
      console.log(uniqueProducts);
    });
  }
}

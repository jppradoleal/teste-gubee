import { Product, TechProduct } from "src/@types/app";

import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable()
export class ApiService {
  apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {};

  getProducts() {
    return this.http.get<Product[]>(this.apiUrl + "/products");
  }
  
  getProductsByTech(techName: string) {
    return this.http.get<TechProduct[]>(`${this.apiUrl}/techs?techNames=${techName}`);
  }
}
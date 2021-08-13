import { Component, Input, OnInit } from '@angular/core';

import { Product } from 'src/@types/app';

@Component({
  selector: 'app-card',
  template: `
    <section class="card">
      <h2>{{product.name}}</h2>
      <p>{{product.description}}</p>
      <h3>Publico alvo: <span>{{getTargetNames().join(", ")}}</span></h3>
      <section class="bullets">
        <div class="bullet" *ngFor="let tech of product.techs">{{tech.name}}</div>
      </section>
    </section>
  `,
  styles: [
    `
       .card {
          background: #222;
          width: 250px;
          color: white;
          padding: .725rem 1rem;
          display: flex;
          flex-direction: column;
          border-radius: .5rem;
          gap: .5rem;

          h2 {
            font-size: 1.5rem;
            font-weight: bold;
          }

          h3 {
            font-size: 1.125rem;
            font-weight: bold;
            display: inline;

            span {
              font-size: 1rem;
              font-weight: normal;
              display: inline;
            }
          }
          
          p {
            white-space: break-spaces;
          }

          .bullets {
            display: flex;
            flex-wrap: wrap;
            gap: .125rem;
            .bullet {
              font-size: .750rem;
              padding: .250rem 1rem;
              background: #ff0;
              color: black;
              border-radius: .5rem;
              cursor: pointer;

              &:hover {
                filter: brightness(.9);
              }
            }
          }
       }
    `
  ]
})
export class CardComponent implements OnInit {
  @Input()
  product: Product = {} as Product;

  constructor() { }

  ngOnInit(): void {
  }

  getTargetNames() {
    return this.product.targetMarket.map(e => e.name);
  }
}

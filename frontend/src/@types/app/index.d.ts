export interface Product {
  id: number;
  name: string;
  description: string;
  techs: Tech[];
  targetMarket: TargetMarket[];
}

export interface Tech {
  id: number;
  name: string;
}

export interface TargetMarket {
  id: number;
  name: string;
}

export interface TechProduct extends Tech {
  products: Product[];
}
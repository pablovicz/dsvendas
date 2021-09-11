import { Seller } from "./seller";

export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: string;
  seller: Seller;
}

export type SalePage = {
  content?: Sale[]; //? -> significa que é opcional
  last: boolean;
  totalElements: number;
  totalPages: number;
  size?: number;
  number: number;
  first: boolean;
  numberOfElements?: number;
  empty?: boolean;
}


export type SalesSum = {
  sellerName: string;
  sum: number;
};

export type SaleSucess = {
  sellerName: string;
  visited: number;
  deals: number;
};

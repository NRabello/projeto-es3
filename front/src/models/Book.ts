import { Author } from "./Author";
import { Category } from "./Category";
import { Dimension } from "./Dimension";
import { PricingGroup } from "./PricingGroup";
import { PublishingCompany } from "./PublishingCompany";

  export interface IBookModel {
    id?: number;
    title?: string;
    author?: Author;
    categories?: Category[];
    year?: string;
    publishingCompany?: PublishingCompany;
    acquisitionValue?: string;
    edition?: string;
    isbn?: string;
    pages?: string;
    synopsis?: string;
    dimensions?: Dimension;
    pricingGroup?: PricingGroup;
    barcode?: string;
    active?: boolean;
  }
  
  export class Book {
    id: number;
    title: string;
    author: Author;
    categories: Category[];
    year: string;
    publishingCompany: PublishingCompany;
    acquisitionValue: string;
    edition: string;
    isbn: string;
    pages: string;
    synopsis: string;
    dimensions: Dimension;
    pricingGroup: PricingGroup;
    barcode: string;
    active: boolean;
  
    constructor({
      id = 0,
      title = '',
      author = (new Author()),
      categories = [],
      year = '',
      publishingCompany = (new PublishingCompany()),
      acquisitionValue = '',
      edition = '',
      isbn = '',
      pages = '',
      synopsis = '',
      dimensions = (new Dimension()),
      pricingGroup = (new PricingGroup()),
      barcode = '',
      active= true
    }: IBookModel = {}) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.categories = categories;
      this.year = year;
      this.publishingCompany = publishingCompany;
      this.acquisitionValue = acquisitionValue;
      this.edition = edition;
      this.isbn = isbn;
      this.pages = pages;
      this.synopsis = synopsis;
      this.dimensions = dimensions;
      this.pricingGroup = pricingGroup;
      this.barcode = barcode;
      this.active = active;
    }

    // get id(): number {
    //   return this._id;
    // }
    // set id(id: number) {
    //   this._id = id;
    // }
  
    // get title(): string {
    //   return this._title;
    // }
    // set title(title: string) {
    //   this._title = title;
    // }
  
    // get author(): Author {
    //   return this._author;
    // }
    // set author(author: Author) {
    //   this._author = author;
    // }
  
    // get categories(): Category[] {
    //   return this._categories;
    // }
    // set categories(categories: Category[]) {
    //   this._categories = categories;
    // }
  
    // get year(): string {
    //   return this._year;
    // }
    // set year(year: string) {
    //   this._year = year;
    // }
  
    // get publishingCompany(): PublishingCompany {
    //   return this._publishingCompany;
    // }
    // set publishingCompany(publishingCompany: PublishingCompany) {
    //   this._publishingCompany = publishingCompany;
    // }
  
    // get acquisitionValue(): string {
    //   return this._acquisitionValue;
    // }
    // set acquisitionValue(acquisitionValue: string) {
    //   this._acquisitionValue = acquisitionValue;
    // }
  
    // get edition(): string {
    //   return this._edition;
    // }
    // set edition(edition: string) {
    //   this._edition = edition;
    // }
  
    // get isbn(): string {
    //   return this._isbn;
    // }
    // set isbn(isbn: string) {
    //   this._isbn = isbn;
    // }
  
    // get pages(): string {
    //   return this._pages;
    // }
    // set pages(pages: string) {
    //   this._pages = pages;
    // }
  
    // get synopsis(): string {
    //   return this._synopsis;
    // }
    // set synopsis(synopsis: string) {
    //   this._synopsis = synopsis;
    // }
  
    // get dimensions(): Dimension {
    //   return this._dimensions;
    // }
    // set dimensions(dimensions: Dimension) {
    //   this._dimensions = dimensions;
    // }
  
    // get pricingGroup(): PricingGroup {
    //   return this._pricingGroup;
    // }
    // set pricingGroup(pricingGroup: PricingGroup) {
    //   this._pricingGroup = pricingGroup;
    // }
  
    // get barcode(): string {
    //   return this._barcode;
    // }
    // set barcode(barcode: string) {
    //   this._barcode = barcode;
    // }

    // get active(): boolean {
    //     return this._active;
    // }
    // set active(active: boolean) {
    //     this._active = active;
    // }

    // toJSON(): IBookModel {
    //   return {
    //     id: this._id,
    //     title: this._title,
    //     author: this._author,
    //     categories: this._categories,
    //     year: this._year,
    //     publishingCompany: this._publishingCompany,
    //     acquisitionValue: this._acquisitionValue,
    //     edition: this._edition,
    //     isbn: this._isbn,
    //     pages: this._pages,
    //     synopsis: this._synopsis,
    //     dimensions: this._dimensions,
    //     pricingGroup: this._pricingGroup,
    //     barcode: this._barcode,
    //     active: this._active,
    //   };
    // }
  }
  
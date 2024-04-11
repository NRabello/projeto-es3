
  export interface IBookModel {
    id?: number;
    title?: string;
    author?: string;
    category?: string;
    year?: string;
    publisher?: string;
    acquisitionValue?: string;
    edition?: string;
    ISBN?: string;
    numPages?: string;
    synopsis?: string;
    height?: string;
    width?: string;
    weight?: string;
    depth?: string;
    priceGroup?: string;
    barcode?: string;
    active?: boolean;
  }
  
  export class Book {
    private _id: number;
    private _title: string;
    private _author: string;
    private _category: string;
    private _year: string;
    private _publisher: string;
    private _acquisitionValue: string;
    private _edition: string;
    private _ISBN: string;
    private _numPages: string;
    private _synopsis: string;
    private _height: string;
    private _width: string;
    private _weight: string;
    private _depth: string;
    private _priceGroup: string;
    private _barcode: string;
    private _active: boolean;
  
    constructor({
      id = 0,
      title = '',
      author = '',
      category = '',
      year = '',
      publisher = '',
      acquisitionValue = '',
      edition = '',
      ISBN = '',
      numPages = '',
      synopsis = '',
      height = '',
      width = '',
      weight = '',
      depth = '',
      priceGroup = '',
      barcode = '',
      active= true
    }: IBookModel = {}) {
      this._id = id;
      this._title = title;
      this._author = author;
      this._category = category;
      this._year = year;
      this._publisher = publisher;
      this._acquisitionValue = acquisitionValue;
      this._edition = edition;
      this._ISBN = ISBN;
      this._numPages = numPages;
      this._synopsis = synopsis;
      this._height = height;
      this._width = width;
      this._weight = weight;
      this._depth = depth;
      this._priceGroup = priceGroup;
      this._barcode = barcode;
      this._active = active;
    }

    get id(): number {
      return this._id;
    }
    set id(id: number) {
      this._id = id;
    }
  
    get title(): string {
      return this._title;
    }
    set title(title: string) {
      this._title = title;
    }
  
    get author(): string {
      return this._author;
    }
    set author(author: string) {
      this._author = author;
    }
  
    get category(): string {
      return this._category;
    }
    set category(category: string) {
      this._category = category;
    }
  
    get year(): string {
      return this._year;
    }
    set year(year: string) {
      this._year = year;
    }
  
    get publisher(): string {
      return this._publisher;
    }
    set publisher(publisher: string) {
      this._publisher = publisher;
    }
  
    get acquisitionValue(): string {
      return this._acquisitionValue;
    }
    set acquisitionValue(acquisitionValue: string) {
      this._acquisitionValue = acquisitionValue;
    }
  
    get edition(): string {
      return this._edition;
    }
    set edition(edition: string) {
      this._edition = edition;
    }
  
    get ISBN(): string {
      return this._ISBN;
    }
    set ISBN(ISBN: string) {
      this._ISBN = ISBN;
    }
  
    get numPages(): string {
      return this._numPages;
    }
    set numPages(numPages: string) {
      this._numPages = numPages;
    }
  
    get synopsis(): string {
      return this._synopsis;
    }
    set synopsis(synopsis: string) {
      this._synopsis = synopsis;
    }
  
    get height(): string {
      return this._height;
    }
    set height(height: string) {
      this._height = height;
    }

    get width(): string {
      return this._width;
    }
    set width(width: string) {
      this._width = width;
    }

    get weight(): string {
      return this._weight;
    }
    set weight(weight: string) {
      this._weight = weight;
    }

    get depth(): string {
      return this._depth;
    }
    set depth(depth: string) {
      this._depth = depth;
    }
  
    get priceGroup(): string {
      return this._priceGroup;
    }
    set priceGroup(priceGroup: string) {
      this._priceGroup = priceGroup;
    }
  
    get barcode(): string {
      return this._barcode;
    }
    set barcode(barcode: string) {
      this._barcode = barcode;
    }

    get active(): boolean {
        return this._active;
    }
    set active(active: boolean) {
        this._active = active;
    }
  }
  
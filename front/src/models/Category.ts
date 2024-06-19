
export interface ICategoryModel {
    id?: number;
    name?: string;
  }
  
  export class Category {
    id: number;
    name: string;
    
    constructor({
      id = 0,
      name = '',
    }: ICategoryModel = {}) {
      this.id = id;
      this.name = name;
    }

    // get id(): number {
    //   return this._id;
    // }
    // set id(id: number) {
    //   this._id = id;
    // }
  
    // get name(): string {
    //   return this._name;
    // }
    // set name(name: string) {
    //   this._name = name;
    // }
}
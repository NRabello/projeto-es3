
export interface IAuthorModel {
    id?: number;
    name?: string;
  }
  
  export class Author {
    id: number;
    name: string;
    
    constructor({
      id = 0,
      name = '',
    }: IAuthorModel = {}) {
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
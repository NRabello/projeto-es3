
export interface IPricingGroupModel {
    id?: number;
    name?: string;
    discount?: number;
  }
  
  export class PricingGroup {
    id: number;
    name: string;
    discount: number;
    
    constructor({
      id = 0,
      name = '',
      discount = 0,
    }: IPricingGroupModel = {}) {
      this.id = id;
      this.name = name;
      this.discount = discount;
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

    // get discount(): number {
    //   return this._discount;
    // }
    // set discount(discount: number) {
    //   this._discount = discount;
    // }
}
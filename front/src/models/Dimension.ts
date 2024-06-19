
export interface IDimensionModel {
    id?: number;
    height?: number;
    width?: number;
    depth?: number;
    weight?: number;
  }
  
  export class Dimension {
    id: number;
    height: number;
    width: number;
    depth: number;
    weight: number;
    constructor({
        id = 0,
        height = 0,
        width = 0,
        depth = 0,
        weight = 0,
    }: IDimensionModel = {}) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    // get id(): number {
    //   return this._id;
    // }
    // set id(id: number) {
    //   this._id = id;
    // }
    
    // get height(): number {
    //   return this._height;
    // }
    // set height(height: number) {
    //   this._height = height;
    // }

    // get width(): number {
    //   return this._width;
    // }
    // set width(width: number) {
    //   this._width = width;
    // }

    // get depth(): number {
    //   return this._depth;
    // }
    // set depth(depth: number) {
    //   this._depth = depth;
    // }

    // get weight(): number {
    //   return this._weight;
    // }
    // set weight(weight: number) {
    //   this._weight = weight;
    // }

}
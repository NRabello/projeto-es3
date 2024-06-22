import { Book } from './Book';

export interface IReasonActivationDeactivationModel {
    id?: number;
    description?: string;
    book?: Book;
    type?: string;
  }
  
  export class ReasonActivationDeactivation {
    id: number;
    description: string;
    book: Book;
    type: string;
  
    constructor({
      id = 0,
      description = '',
      book = new Book(),
      type = ''
    }: IReasonActivationDeactivationModel = {}) {
        this.id = id;
        this.description = description;
        this.book = book;
        this.type = type;
    }
}
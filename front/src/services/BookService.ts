import { Book } from "@/models/Book";
import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
});

export class BookService {
    findAll() {
        return axiosInstance.get("/book/findAll");
    }  

    save(book: Book) {
        return axiosInstance.post("/book/save", book);
    }

    delete(id: number) {
        return axiosInstance.delete(`/book/delete/${id}`);
    }

    async findById(id: number) {
        return await axiosInstance.get("/book/findById", {
           params: {
               id: id,
           }
       });
   }

    update(book: Book) {
        return axiosInstance.patch("/book/update", book);
    }
}
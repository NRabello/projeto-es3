import { Category } from "@/models/Category";
import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
});

export class CategoryService {
    findAll() {
        return axiosInstance.get("/category/findAll");
    }  

    save(category: Category) {
        return axiosInstance.post("/category/save", category);
    }
}
import { PricingGroup } from "@/models/PricingGroup";
import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
});

export class PricingGroupService {
    findAll() {
        return axiosInstance.get("/pricingGroup/findAll");
    }  

    save(pricingGroup: PricingGroup) {
        return axiosInstance.post("/pricingGroup/save", pricingGroup);
    }
}
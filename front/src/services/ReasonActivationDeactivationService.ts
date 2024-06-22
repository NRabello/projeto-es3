import { ReasonActivationDeactivation} from '../models/ReasonActivationDeactivation'
import axios from 'axios'

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
});

export class ReasonActivationDeactivationService {
    findAll() {
        return axiosInstance.get("/reason=/findAll");
    }  

    save(reasonActivationDeactivation: ReasonActivationDeactivation) {
        return axiosInstance.post("/reason/save", reasonActivationDeactivation);
    }
}
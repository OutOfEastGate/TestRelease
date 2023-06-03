import axios from 'axios';
import {backPath} from "@/components/Conf";

export function uploadFile(file: File) {
    const formData = new FormData();
    formData.append('file', file);
    const response = axios.post('http://' + backPath + '/api/upload', formData, {
        headers: {
            authorization: localStorage.getItem("token") as string,
        }
    })
    return response
}
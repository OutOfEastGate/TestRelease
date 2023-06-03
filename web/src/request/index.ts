import axios from "axios"
import {backPath} from "@/components/Conf";

//创建axios实例
const instance = axios.create({
    //基本请求路径抽取
    baseURL:"http://" + backPath + "/api",
    timeout:20000,
    headers: {
        Authorization : localStorage.getItem('token')
    }
})

//请求拦截器
instance.interceptors.request.use((config)=>{
    return config
},err=>{
    return Promise.reject(err)
});

//响应拦截器
instance.interceptors.response.use(res=>{
    if (res.status === 401) {
        localStorage.removeItem("token")
    }
    return res.data;
},err=>{
    return Promise.reject(err)
})

export default instance
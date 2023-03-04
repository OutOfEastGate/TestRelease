import React,{ lazy } from "react";
import App from "@/App";
import Home from "@/views/Home";
import { BrowserRouter,Route, Routes, Navigate } from "react-router-dom";

const About = lazy(()=>import("../views/about/About"));//懒加载

const withLoadingComponent = (comp:JSX.Element) =>(//抽取loading组件函数     
    <React.Suspense fallback={<div>Loading...</div>}>
        {comp}
    </React.Suspense>
)

const baseRouter = () => (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App/>}>
                <Route path="/" element={<Navigate to="/home"/>}></Route>
                <Route path="/" element={<Home/>}  children={[
                    <Route path="/about" element={withLoadingComponent(<About />)}></Route>
                ]  
                }></Route>
                
            </Route>
        </Routes>
    </BrowserRouter>
)

export default baseRouter
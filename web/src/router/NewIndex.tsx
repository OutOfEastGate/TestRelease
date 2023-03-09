import Home from "@/views/Home";
import About from "@/views/about/About";
import NotFound from "@/components/Common/NotFound";
import LoginView from "@/views/Login/index"
import Role from "@/components/Common/Role/index"
import Permission from "@/components/Common/Permission/index";
import CallBack from "@/components/Common/Callback";
import User from "@/components/Common/User"
import { Navigate } from "react-router-dom";
import HomePage from "@/components/Common/HomePage"
import Editor from "@/components/Common/Edit"

const routes = [
    {
        path: "/",
        element:<Navigate to="/homepage"/>
    },
    {
        path: "/login",
        element: <LoginView />
    },
    {
        path: "/home",
        element: <Home/>
    },
    {
        path: "/",
        element: <Home/>,
        children:[
            {
                path: "/homepage",
                element: <HomePage />
            },
            {
                path: "/users",
                element: <User/>
            },
            {
                path: "/about",
                element: <About/>
            },
            {
                path: "/edit",
                element: <Editor />
            },
            {
                path: "/permission",
                element: <Permission />
            }
        ]
    },
    {
        path: "/callback",
        element: <CallBack />
    },
    {
        path:"*",
        element: <NotFound/>
    }
    
]
export default routes
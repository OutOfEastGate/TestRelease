import Home from "@/views/Home";
import About from "@/views/about/About";
import Page from "@/views/Page/Page";
import NotFound from "@/components/Common/NotFound";
import LoginView from "@/views/Login/index"
import Role from "@/components/Common/Role/index"
import Permission from "@/components/Common/Permission/index";
import CallBack from "@/components/Common/Callback";
import User from "@/components/Common/User"
import { Navigate } from "react-router-dom";
import HomePage from "@/components/Common/HomePage"

const routes = [
    {
        path: "/",
        element:<Navigate to="/homeoage"/>
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
                path: "/page",
                element: <Page/>
            },
            {
                path: "/about",
                element: <About/>
            },
            {
                path: "/role",
                element: <Role />
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
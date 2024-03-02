import Home from "@/views/NewHome";
import About from "@/views/about/About";
import NotFound from "@/components/Common/NotFound";
import LoginView from "@/views/Login/index"
import CallBack from "@/components/Common/Callback";
import User from "@/components/Common/User"
import { Navigate } from "react-router-dom";
import Article from "@/components/Common/Article"
import ArticleDetail from "@/views/Article"
import Editor from "@/components/Common/Edit"
import MessageList from "@/components/Common/Comments/index";
import ChatRoom from "@/components/Common/Chat"
import File from "@/components/Common/File"
import FileType from "@/components/Common/File/FileType";
import Notification from "@/components/Common/Notification"
import Ip from "@/components/Common/Ip";
import Announcement from "@/components/Common/Notification/Announcement";
import Store from "@/components/Common/Permission/Store";
// @ts-ignore
import Script from "@/components/Common/Script";
import System from "@/components/Common/System";
import HomePage from "@/components/Common/HomePage";
import ArticlePage from "@/components/Common/Article/ArticlePage";
import Graph from "@/components/Common/Permission/Graph";

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
                element: <HomePage/>
            },
            {
                path: "/article",
                element: <Article />
            },
            {
                path: "/articlePage",
                element: <ArticlePage/>
            },
            {
                path: "/article/:articleId",
                element: <ArticleDetail />
            },
            {
                path: "/notification",
                element: <Notification />
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
                path: "/edit/:id",
                element: <Editor />
            },
            {
                path: "/edit",
                element: <Editor />
            },
            {
                path: "/messageList",
                element: <MessageList />
            },
            {
                path: "/chat",
                element: <ChatRoom />
            },
            {
                path: "/file",
                element: <File />
            },
            {
                path: "/fileType" ,
                element: <FileType />
            },
            {
                path: "/ip" ,
                element: <Ip />
            },
            {
                path: "/announcement",
                element: <Announcement></Announcement>
            },
            {
                path: "/store",
                element: <Store></Store>
            },
            {
                path: "/script",
                element: <Script></Script>
            },
            {
                path: "/system",
                element: <System></System>
            },
            {
                path: "/model",
                element: <Graph isModalOpen={true}></Graph>
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
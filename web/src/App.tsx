import React, { useEffect } from 'react'
import './i18n'
import './components/Setting'
import { useRoutes,useLocation,useNavigate } from "react-router-dom"
import router from "@/router/NewIndex"
import SSEConnection from "@/request/Sse";

function ToLogin() {
  const navigateTo = useNavigate()
  //加载完这个组件实现跳转
  useEffect(()=>{
    navigateTo("login")
  })
  return <div></div>
}

function ToHome() {
  const navigateTo = useNavigate()
  //加载完这个组件实现跳转
  useEffect(()=>{
    navigateTo("/")
  })
  return <div></div>
}

function BeforeRouterEnter() {
  const outlet = useRoutes(router)
  const location = useLocation()
  let token = localStorage.getItem("token");
  if(location.pathname === "/callback") {
    return outlet
  }
  if(location.pathname !== "/login" && !token) {
    return <ToLogin/>
  }
  if(token && location.pathname === "/login") {
    return <>
      <ToHome/>
    </>
  }
  return outlet
}


function App() {
  return (
    <div>
      <SSEConnection/>
      <BeforeRouterEnter/>
    </div>
  )
}

export default App

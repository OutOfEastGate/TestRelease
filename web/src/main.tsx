import React from 'react'
import ReactDOM from 'react-dom/client'
import "reset-css"
//全局样式
import "@/assets/styles/global.scss"
//组件样式
import App from './App'
// import Router from './router'
import { BrowserRouter } from "react-router-dom"
//状态管理
import { Provider } from 'react-redux'
import store from './store'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <Provider store={store}>
    <React.StrictMode>
      <BrowserRouter>
        <App></App>
      </BrowserRouter>
    </React.StrictMode>
  </Provider>,

)

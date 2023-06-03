import React, { useEffect } from 'react';
import {backPath} from "@/components/Conf";
import {showMessage} from "@/components/Setting";

const SSEConnection = () => {
    if (localStorage.getItem("username") != null && localStorage.getItem("token") != null) {
        useEffect(() => {
            const eventSource = new EventSource("http://" + backPath + "/api/sse/get?userId=" + localStorage.getItem("username")) as EventSource & {
                headers:{
                    Authorization: string
                }
            }

            eventSource.headers = {
                Authorization: localStorage.getItem("token") as string
            }

            eventSource.onmessage = (event) => {
                console.log(event.data)
                showMessage("notification", event.data)
            };

            eventSource.onerror = (error) => {

            };

            return () => {
                eventSource.close(); // 在组件卸载时关闭连接
            };
        });
    }


    return null; // SSEConnection 组件本身不需要渲染任何内容
};

export default SSEConnection;
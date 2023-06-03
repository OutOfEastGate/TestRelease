import {message, notification} from 'antd';
import { useLocation } from "react-router-dom";
import {downloadFile} from "@/request/api";

export function showMessage(type:string, text:string)  {
    if (type === "success") {
        message.success(text);
      } else if (type === "error") {
        message.error(text);
      } else if (type === "info") {
        message.info(text);
      } else if (type === "notification"){
        notification.open({
            type: "info",
            message: '通知提醒',
            description: text,
            onClick: () => {
                console.log('Notification Clicked!');
            },
        });
    }
}


export function location(path:string) {
    const location = useLocation()
    // 页面跳转方法
    console.log(location,'props')
}

export function getCurrentTime() {
    const date = new Date()
    return date.toLocaleDateString() +" "+ date.toLocaleTimeString()
}

export function download(filename:string,url:string) {
    downloadFile(url).then(res=>{
        const blob = new Blob([res.data]) // 将字节流(字符流)转换为 blob 对象
        let url = window.URL.createObjectURL(blob)
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.download = filename
        document.body.appendChild(link)
        link.click()
        document.body.removeChild(link) // 下载完成移除元素
        window.URL.revokeObjectURL(url) // 释放掉blob对象
    })
}

import React, { useState } from "react";
import {Button, Card, Input, List} from "antd";
import { MessageOutlined } from "@ant-design/icons";
import {addComment, getAllComment} from "@/request/api";
import {getCurrentTime, showMessage} from "@/components/Setting";


const MessageList = () => {
    const [messages, setMessages] = useState<Message[]>([]);
    const [newMessage, setNewMessage] = useState("");

    const handleAddMessage = () => {
        if (newMessage.trim() !== "") {
            setMessages([ { username: localStorage.getItem("username"), message: newMessage,createTime: getCurrentTime() },...messages]);
            setNewMessage("");
            addComment({username:localStorage.getItem("username"),message:newMessage,createTime:getCurrentTime()}).then( res =>{
                if (res.msg === "success") {
                    showMessage("success","评论成功")
                } else {
                    showMessage("error", "评论失败")
                }
            })
        }
    };
    if (messages.length === 0) {
        getAllComment().then(res => {
            setMessages(res.data)
        })
    }


    return (
        <div style={{ padding: "24px" }}>
            <div style={{ marginBottom: "24px", textAlign: "center" }}>
                <h1 style={{ textAlign: "center", marginBottom: "24px" }}>留言板</h1>
                <Input.TextArea
                    placeholder="请输入留言内容"
                    rows={4}
                    value={newMessage}
                    onChange={(e) => setNewMessage(e.target.value)}
                />
                <Button type="primary" style={{ marginLeft: "8px" }} onClick={handleAddMessage}>
                    添加留言
                </Button>
            </div>
            <div style={{textAlign:"center"}}>
                <Card>
                    <List
                        dataSource={messages}
                        renderItem={(item) => (
                            <List.Item>
                                <List.Item.Meta avatar={<MessageOutlined />} title={`${item.username}留言 ${item.createTime}`} description={item.message} />
                            </List.Item>
                        )}
                        style={{ maxHeight: "480px", overflowY: "auto" }}
                    />
                </Card>
            </div>
        </div>
    );
};

export default MessageList;
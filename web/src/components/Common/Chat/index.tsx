import React, { useState, useEffect, useRef } from "react";
import { Input, Card, Avatar, List, Button } from "antd";
import { SendOutlined } from "@ant-design/icons";
import "./Chat.css";
import {backPath} from "@/components/Conf";

const { Meta } = Card;

interface Message {
    isSystem:boolean;
    fromName: string;
    avatar:string;
    message: string;
}

interface Users {
    users: string[]
}

interface ChatRoomProps {
    username: string;
}

const ChatRoom: React.FC = () => {
    const [messages, setMessages] = useState<Message[]>([]);
    const [inputValue, setInputValue] = useState("");
    const [onlineUsers, setOnlineUsers] = useState<string[]>([]);
    const [username,setUsername] = useState<string | null>(localStorage.getItem("username"))
    if (username == null || username === undefined) setUsername("游客")
    const socket = useRef<WebSocket>();

    useEffect(() => {
        socket.current = new WebSocket("ws://"+ backPath +"/api/chat/" + username);
        socket.current.onopen = () => console.log("WebSocket connected");

        socket.current.onmessage = (event) => {
            const data = JSON.parse(event.data) as Message | string[];
            if (Array.isArray(data)) {
                setOnlineUsers(data);
            } else {
                setMessages((prevMessages) => [...prevMessages, data]);
            }
        };

        return () => {
            socket.current?.close()
        };
    }, []);
    if (onlineUsers.length === 0) {

    }
    const sendMessage = () => {
        if (inputValue.trim()) {
            socket.current?.send(
                JSON.stringify({ isSystem:true, fromName: username, message: inputValue })
            );
            setInputValue("");
        }
    };

    return (
        <div className="chat-room-container">
            <div className="chat-room">
                <Card className="chat-room-card">
                    <div className="chat-room-header">在线用户</div>
                    <List
                        dataSource={onlineUsers}
                        renderItem={(user) => (
                            <List.Item>
                                <Meta
                                    avatar={
                                        <Avatar style={{ color: "#f56a00", backgroundColor: "#fde3cf" }}>
                                            {user[0].toUpperCase()}
                                        </Avatar>
                                    }
                                    title={user}
                                />
                            </List.Item>
                        )}
                    />
                </Card>
                <Card className="chat-room-card">
                    <div className="chat-room-header">Chat Room</div>
                    <div className="chat-room-messages">
                        {messages.map((msg, index) => (
                            <div
                                key={index}
                                className={`chat-room-message ${
                                    msg.fromName === username ? "right" : "left"
                                }`}
                            >
                                <div className="chat-room-message-user">{msg.fromName} : {msg.message}</div>
                            </div>
                        ))}
                    </div>
                    <div className="chat-room-input">
                        <Input
                            value={inputValue}
                            onChange={(e) => setInputValue(e.target.value)}
                            placeholder="Type message here"
                            onPressEnter={sendMessage}
                        />
                        <Button
                            type="primary"
                            icon={<SendOutlined />}
                            onClick={sendMessage}
                            style={{ position: "absolute", bottom: 10, right: 10 }}
                        >
                            Send
                        </Button>
                    </div>
                </Card>
            </div>
        </div>
    );
};

export default ChatRoom;

import { ProList } from '@ant-design/pro-components';
import {Button, Popconfirm, Space, Tag} from 'antd';
import React from "react";
import UserInfo from "@/components/Common/User/UserInfo";
import {deleteArticle, deleteUser} from "@/request/api";
import {showMessage} from "@/components/Setting";

interface DataType {
    users: {
        owner: string;
        name: string;
        displayName: string;
        avatar: string;
        email: string;
        phone: string;
        tag: string;
        location: string;
        createdTime: string;
        signupApplication: string
    }
}

interface User {
    owner: string;
    name: string;
    displayName: string;
    avatar: string;
    email: string;
    phone: string;
    tag: string;
    location: string;
    createdTime: string;
    signupApplication: string;
}

interface PropsType {
    children:DataType,
    reload:(event: React.ChangeEvent<HTMLInputElement>) => void
}

class UserTable extends React.Component<any,any> {
    constructor(props:PropsType) {
        super(props);
        this.state = {
            infoOpen: false,
            currentUser: null,
        }
    }
    //关闭用户信息展示
    closeUserInfo = () => {
        this.setState({
            infoOpen:false
        })
    }
    //更改当前选中学生
    changeCurrentUser = (user:User) => {
        this.setState({
            currentUser: user
        })
    }
    openUserInfo = (user:User) => {
        this.changeCurrentUser(user)
        this.setState({
            infoOpen:true
        })
    }

    confirm = (user:any) => {
        deleteUser(user).then(res => {
            if (res.msg === "success") {
                this.props.reload()
                showMessage("success","删除成功")
            } else {
                showMessage("error", res.msg)
            }
        })

    };

    cancel = () => {

        showMessage("info","已取消")
    };

    render() {
        return (
            <>
                <UserInfo open = {this.state.infoOpen} close = {this.closeUserInfo} user = {this.state.currentUser}></UserInfo>
                <ProList<any>
                    onRow={(record: User) => {
                        return {
                            onMouseEnter: () => {
                                // console.log(record);
                            },
                            onClick: () => {
                                this.changeCurrentUser(record)
                            },
                        };
                    }}
                    rowKey="name"
                    headerTitle="用户"
                    tooltip="用户列表"
                    dataSource={this.props.children.users}
                    showActions="hover"
                    showExtra="hover"
                    metas={{
                        title: {
                            dataIndex: 'name',
                        },
                        avatar: {
                            dataIndex: 'avatar',
                        },
                        description: {
                            dataIndex: 'email',
                        },
                        subTitle: {
                            dataIndex: 'tag',
                            render: (tag) => {
                                return (
                                    <Space size={0}>
                                        <Tag color="blue">{tag}</Tag>
                                    </Space>
                                );
                            },
                        },
                        actions: {
                            render: (text, row) => [
                                <Button
                                    onClick={()=>this.openUserInfo(row)}>
                                    查看
                                </Button>,
                                <Popconfirm
                                    title="删除文章"
                                    description="确定要删除用户吗?"
                                    onConfirm={() => this.confirm(row)}
                                    onCancel={() => this.cancel()}
                                    okText="是"
                                    cancelText="否"
                                >
                                    <Button type="primary"  danger>删除</Button>
                                </Popconfirm>
                            ],
                        },
                    }}
                />
            </>
        )
    }
}

export default UserTable
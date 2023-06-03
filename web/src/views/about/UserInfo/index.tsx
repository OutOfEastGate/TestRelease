import React, { useState } from 'react';
import {
    Avatar,
    Button,
    Form,
    Input,
    InputNumber,
    Switch, Upload,
} from 'antd';
import {getUserDetails} from "@/request/api";
import Loading from "@/components/Util/Loading";
import {ProCard} from "@ant-design/pro-components";
import {UploadOutlined} from "@ant-design/icons";
import {showMessage} from "@/components/Setting";

type SizeType = Parameters<typeof Form>[0]['size'];

class UserInfo extends React.Component<any, any> {
    constructor(props:any) {
        super(props);
        this.state = ({
            componentSize: "small",
            userInfo: null
        })
    }

    updateUserInfo = () => {
        console.log(this.state.userInfo)
    }

    handleNameOnchange = (e:any) => {
        this.setState({userInfo: {...this.state.userInfo, name: e.target.value}})
    }

    handleDisplayNameOnchange = (e:any) => {
        this.setState({userInfo: {...this.state.userInfo, displayName: e.target.value}})
    }

    handleScoreOnchange = (e:any) => {
        this.setState({
            userInfo: {
                ...this.state.userInfo,
                score: e
            }
        })
    }

    handleSelectOnchange = (e:any) => {
        this.setState({
            userInfo: {
                ...this.state.userInfo,
                isAdmin: e
            }
        })
    }

    render() {
        if (this.state.userInfo == null) {
            getUserDetails({token: localStorage.getItem("token")}).then(res => {
                this.setState({
                    userInfo: res.data
                })
            })
            return (
                <Loading></Loading>
            )
        }else {
            return (
                <ProCard colSpan={16}>
                    <Form
                        labelCol={{ span: 4 }}
                        wrapperCol={{ span: 14 }}
                        layout="horizontal"
                        initialValues={{ size: this.state.componentSize }}
                        size={this.state.componentSize  as SizeType}
                        style={{ maxWidth: 600 }}
                    >
                        <Form.Item label="头像">
                            <Avatar
                                size={{ xs: 24, sm: 32, md: 40, lg: 64, xl: 80, xxl: 100 }}
                                src={this.state.userInfo.avatar}
                            />
                            <br/>
                            <Upload beforeUpload={() => showMessage("info", "开发中")}>
                                <Button icon={<UploadOutlined />}>点击上传头像</Button>
                            </Upload>
                        </Form.Item>
                        <Form.Item label="名称">
                            <Input value={this.state.userInfo.name} onChange={this.handleNameOnchange}/>
                        </Form.Item>
                        <Form.Item label="显示名称">
                            <Input value={this.state.userInfo.displayName} onChange={this.handleDisplayNameOnchange}/>
                        </Form.Item>
                        <Form.Item label="用户类型">
                            <Input value={this.state.userInfo.type} disabled={true}/>
                        </Form.Item>
                        <Form.Item label="创建日期">
                            <Input value={this.state.userInfo.createdTime} disabled={true} />
                        </Form.Item>
                        <Form.Item label="得分">
                            <InputNumber value={this.state.userInfo.score} onChange={this.handleScoreOnchange}/>
                        </Form.Item>
                        <Form.Item label="是否管理员" valuePropName="checked">
                            <Switch checked={this.state.userInfo.isAdmin} onChange={this.handleSelectOnchange}/>
                        </Form.Item>
                        <Form.Item label="操作">
                            <Button onClick={this.updateUserInfo}>更新</Button>
                        </Form.Item>
                    </Form>
                </ProCard>

            );
        }
        }


};

export default UserInfo;

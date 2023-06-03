import React, {ChangeEvent, ChangeEventHandler} from "react";
import TextArea from "antd/es/input/TextArea";
import {Button, Card, Space, Tag} from "antd";
import {addAnnouncement, getOnlineUserNum} from "@/request/api";
import {showMessage} from "@/components/Setting";

interface PropsType{
    loading: boolean
    message: string
    userNum: number
}
class App extends React.Component<any, PropsType> {
    constructor(props:any) {
        super(props);
        this.state= {
            loading: false,
            message:"",
            userNum: 0
        }
    }
    onchange = (e:ChangeEvent<HTMLTextAreaElement>) => {
        this.setState({
            message: e.target.value
        })
    }
    sendAnnouncement = () => {
        this.setState({
            loading: true
        })
        addAnnouncement(this.state.message).then(res => {
            if (res.msg === "success") {
                showMessage("success", "发送成功")
            } else {
                showMessage("error", res.msg)
            }
            this.setState({
                loading:false
            })
        })
    }

    render() {
        getOnlineUserNum().then(res => {
            this.setState({
                userNum: res.data
            })
        })
        return(
            <>
                <>
                   <Card>
                       <Space direction="vertical" size="middle" style={{ display: 'flex' , alignItems: "center"}}>
                           <Tag color="success">当前在线人数：{this.state.userNum}</Tag>
                           <TextArea placeholder="输入全局通知文本" allowClear onChange={this.onchange} size={"large"}/>

                           <Button type="primary" loading={this.state.loading} onClick={this.sendAnnouncement}>
                               发送通知
                           </Button>
                       </Space>
                   </Card>
                </>
            </>
        )
    }
}

export default App;
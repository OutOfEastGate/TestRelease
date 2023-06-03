import React from 'react';
import {Badge, Button, Card, Space, Steps, Switch} from 'antd';
import {ClockCircleOutlined} from "@ant-design/icons";
import CreateNotificationForm from "@/components/Common/Notification/CreateNotificationForm";

const description = 'This is a description.';
const items = [
    {
        title: '吃饭',
        description,
    },
    {
        title: '睡觉',
        description,
    },
    {
        title: '打豆豆',
        description,
    },
];
class App extends React.Component<any, any>{
    constructor(props:any) {
        super(props);
        this.state={
            show: true,
            isOpen: false
        }
    }
    onOpenChange = (isOpen:boolean) => {
        this.setState({
            isOpen: isOpen
        })
    }
    render() {
        return(
            <>
                <Card title="时间管理">
                    <Button type={"primary"} onClick={() => this.onOpenChange(true)}>新增事件</Button><br/><br/>
                    <CreateNotificationForm isOpen={this.state.isOpen} onOpenChange={this.onOpenChange}></CreateNotificationForm>
                    <Space>
                        <div>开启通知：<Switch checked={this.state.show} onChange={() => this.setState({show: !this.state.show})}/></div>
                        <br/>
                        <div>近期到期：<Badge count={this.state.show ? 11 : 0} showZero color='#faad14'/></div>

                        <div>已逾期：<Badge count={this.state.show ? 25 : 0}/></div>
                        <Badge count={this.state.show ? <ClockCircleOutlined style={{color: '#f5222d'}}/> : 0}/>
                        <div>
                            正在流程中：
                            <Badge
                                className="site-badge-count-109"
                                count={this.state.show ? 109 : 0}
                                style={{backgroundColor: '#52c41a'}}
                            />
                        </div>
                    </Space>
                    <Card
                        style={{marginTop: 16}}
                        type="inner"
                        title="Inner Card title"
                        extra={<a href="#">编辑</a>}>
                        <Steps current={1} labelPlacement="vertical" items={items}/>
                    </Card>
                    <Card
                        style={{marginTop: 16}}
                        type="inner"
                        title="Inner Card title"
                        extra={<a href="#">编辑</a>}
                    >
                        <Steps current={1} percent={60} labelPlacement="vertical" items={items}/>
                    </Card>
                </Card>
            </>
        )
    }
};

export default App;

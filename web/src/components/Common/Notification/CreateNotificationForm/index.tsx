import React from "react";
import {Button, Drawer, Input, Space, TimePicker} from "antd";
import dayjs from 'dayjs';
import type { Dayjs } from 'dayjs';
import Calendar from "@/components/Common/Notification/CreateNotificationForm/Calendar";

interface StateType{
    taskName:string,
    deadlineDay:string,
    deadlineTime:string,
    open:boolean
}

interface PropsType{
    isOpen:boolean,
    onOpenChange: (isOpen: boolean) => any;
}

class App extends React.Component<PropsType, StateType>{
    constructor(props:PropsType) {
        super(props);
        this.state={
            taskName: "",
            deadlineDay: "",
            deadlineTime: "",
            open: false
        }
    }
    setDeadlineTime = (time: Dayjs | null, timeString: string) => {
        this.setState({
            deadlineTime: timeString
        })
    }

    setDeadlineDay = (timeString: string) => {
        this.setState({
            deadlineDay: timeString
        })
    }
    onClose = () => {
        this.setState({
            open:false
        })
    };
    submit = () => {
        console.log(this.state)
    }
    render() {
        return(
            <>
                <Drawer title="新增事件" placement="right" onClose={() => this.props.onOpenChange(false)} open={this.props.isOpen}>
                    <div>
                        <Space><p>任务名称：</p><Input placeholder="任务名称" /></Space>
                    </div>
                    <div>
                        <p>任务结束时间：</p>
                        <Calendar day={this.state.deadlineDay} onDayChange={this.setDeadlineDay}></Calendar>
                    </div>
                    <TimePicker defaultValue={dayjs('12:08:23', 'HH:mm:ss')} size="large" onChange={this.setDeadlineTime}/><br/>
                    <Button type={"primary"} onClick={this.submit}>提交</Button>
                </Drawer>
            </>
        )
    }
}

export default App;
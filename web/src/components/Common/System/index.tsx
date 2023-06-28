import React from "react";
import {Card, Col, CountdownProps, Progress, Row, Statistic} from "antd";
import {getSystemInfo} from "@/request/api";
import Loading from "@/components/Util/Loading";

const { Countdown } = Statistic;

interface stateType{
    systemInfo: SystemInfo | null
}
class App extends React.Component<any, stateType>{
    constructor(props:any) {
        super(props);
        this.state={
            systemInfo: null
        }
    }

    UNSAFE_componentWillMount() {
        const id = setInterval(() => {
        getSystemInfo().then(res => {
            this.setState({
                systemInfo: res.data
            })
        })
    }, 1000 * 2)
    }

    render() {

        return this.state.systemInfo == null ? <><Loading></Loading></>:
            <>
                <Card>
                    <Row gutter={16}>
                        <Col span={8}>
                            <Statistic title="系统运行时间" value={this.state.systemInfo.systemRuntime} />
                        </Col>
                        <Col span={8}>
                            <Statistic title="CPU核心数" value={this.state.systemInfo.cpuNum}  />
                        </Col>
                        <Col span={8}>
                            <Statistic title="CPU线程数数" value={this.state.systemInfo.cpuThreadNum}  />
                        </Col>
                        <Col span={24} style={{ marginTop: 32 }}>
                            <Statistic title="系统总内存" value={this.state.systemInfo.totalMemory} />
                        </Col>
                        <Col span={12}>
                            {"系统内存使用率"}<br/>
                            <Progress type="circle"  percent={this.state.systemInfo.memoryUsage * 100} />
                        </Col>
                        <Col span={12}>
                            {"JVM内存使用率"}<br/>
                            <Progress type="circle" percent={this.state.systemInfo.jvmMemoryUsage * 100} />
                        </Col>
                    </Row>
                </Card>
            </>;
    }
}

export default App;
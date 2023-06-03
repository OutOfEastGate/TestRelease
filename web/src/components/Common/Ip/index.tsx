import React from "react";
import {Table} from "antd";
import {getAllIpInfo} from "@/request/api";

const columns = [
    {
        title: 'IP',
        dataIndex: 'ip',
        key: 'ip',
    },
    {
        title: '国家',
        dataIndex: 'country',
        width: 300,
        key: 'country',
    },
    {
        title: '城市',
        dataIndex: 'city',
        key: 'city'
    },
    {
        title: '访问次数',
        dataIndex: 'times',
        key: 'times',
    },
    {
        title: '最近访问日期',
        dataIndex: 'date',
        key: 'date',
    }
];
interface StateType{
    ip:Ip[],
    total:number
}
class App extends React.Component<any, StateType>{
    constructor(props:any) {
        super(props);
        this.state={
            ip:[],
            total: 0,
        }
    }

    render() {
        if (this.state.ip.length === 0) {
            getAllIpInfo({currentPage:0,pageSize:10}).then(res => {
                this.setState({
                    ip: res.data.data,
                    total: res.data.total
                })
            })
        }

        return(
            <Table className="selectable-table"
                   columns={columns}
                   dataSource={this.state.ip}
                   rowKey="id"
                   pagination={
                       {
                           total: this.state.total,
                           pageSize: 10,
                           onChange: (page) => {
                               getAllIpInfo({currentPage: page - 1,pageSize: 10}).then(res => {
                                   this.setState({
                                       ip: res.data.data,
                                       total: res.data.total
                                   })
                               })
                           }
                       }
                   }
            />
        )
    }
}

export default App;
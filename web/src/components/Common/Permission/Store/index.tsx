import React from "react";
import {Button, Popconfirm, Table} from "antd";
import {getAllStores} from "@/request/api";
import {Link} from "react-router-dom";

const columns = [
    {
        title: 'id',
        dataIndex: 'id',
        key: 'id',
    },
    {
        title: '存储名称',
        dataIndex: 'name',
        width: 300,
        key: 'name',
    },
    {
        title: '创建时间',
        dataIndex: 'created_at',
        key: 'created_at'
    },
    {
        title: '更新时间',
        dataIndex: 'updated_at',
        key: 'updated_at',
    },
    {
        title: '删除时间',
        dataIndex: 'deleted_at',
        key: 'deleted_at',
    },
    {
        title: '操作',
        key:"action",
        render: (text: any, record: Store) => (
            <>
                <Button type={"primary"}>查看存储模型</Button>
            </>
        ),
    }
];
interface StateType{
    stores:Store[],
    total:number
}
class App extends React.Component<any, StateType>{
    constructor(props:any) {
        super(props);
        this.state={
            stores:[],
            total: 0,
        }
    }

    render() {
        if (this.state.stores.length === 0) {
            getAllStores().then(res => {
                this.setState({
                    stores: res.data.stores
                })
            })
        }

        return(
            <Table className="selectable-table"
                   columns={columns}
                   dataSource={this.state.stores}
                   rowKey="id"
                   pagination={
                       {
                           total: this.state.total,
                           pageSize: 10,
                       }
                   }
            />
        )
    }
}

export default App;
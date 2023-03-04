import React from 'react';
import { Space, Table, Tag } from 'antd';
import { getAllUsersAPI } from '@/request/api'
import UserTable from '@/components/Common/User/Table/UserTable'
import Loading from '@/components/Util/Loading'

const { Column } = Table;

interface DataType {
    owner: string;
    name: string;
    displayName: string;
    avatar: string;
    email: string;
    tag: string
}

var data: DataType[] = [];

const getDetail = (name:string) => {
    // Setting.showMessage("info","正在开发中")
}

const deleteUser = (name:string) => {
    // showMessage("info","正在开发中")
}

class UserList extends React.Component {
    constructor(props: any) {
        super(props)
        this.state={
            users: [],
            isLoaded:false
        }
    }
    
    render() {
        if(this.state.users.length === 0) {
            getAllUsersAPI().then((res) => {
                this.setState({
                    users: res.data,
                    isLoaded: true
                })
            })
            return(
                <Loading/>
            )
        } else {
            return (
                <UserTable>
                    {this.state.users}
                </UserTable>
            )
        }
    }
};

export default UserList;

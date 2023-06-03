import React from 'react';
import { getAllUsersAPI } from '@/request/api'
import UserTable from '@/components/Common/User/NewTable'
import Loading from '@/components/Util/Loading'


class UserList extends React.Component<any,any> {
    constructor(props: any) {
        super(props)
        this.state={
            userTableInfo: {
                users: [],
            },
            isLoaded:false,
        }
    }

    getAllUsers = () => {
        getAllUsersAPI().then((res) => {
            this.setState({
                userTableInfo:{
                    users:res.data
                },
            })
        })
    }

    render() {
        if(this.state.userTableInfo.users.length === 0) {
            this.getAllUsers()
            return(
                <Loading/>
            )
        } else {
            return (
                <>
                    <UserTable children={this.state.userTableInfo} reload={this.getAllUsers}/>
                </>
            )
        }
    }
};

export default UserList;

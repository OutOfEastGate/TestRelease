import React from 'react';
import {Avatar, Col, Row, Space} from 'antd';
import List from "./List"
import {getUserDetails} from "@/request/api";
import Loading from "@/components/Util/Loading";

class App extends React.Component<any, any> {
    constructor(props:any) {
        super(props);
        this.state = {
            user: null
        }
    }
    render() {
        if (this.state.user === null) {
            getUserDetails({token:localStorage.getItem("token")}).then(res => {
                this.setState({
                    user:res.data
                })
            })
            return (
                <Loading></Loading>
            )
        }else {
            return (
                <Row>
                    <Col flex={23}></Col>
                    <Col flex={1}><Space wrap size={16}>
                        <List>
                            {this.state.user}
                        </List>
                    </Space>
                    </Col>
                </Row>
            )
        }

    }
}

export default App;

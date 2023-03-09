import React from 'react';
import {Avatar, Col, Row, Space} from 'antd';
import {UserOutlined} from "@ant-design/icons";
import List from "./List"

const App: React.FC = () => (
    <>
        <Row>
            <Col flex={23}></Col>
            <Col flex={1}><Space wrap size={16}>
                <List></List>
                <Avatar size={50} icon={<UserOutlined />} />
            </Space></Col>
        </Row>
    </>
);

export default App;

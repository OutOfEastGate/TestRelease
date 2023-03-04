import React from 'react';
import { Layout, Card } from 'antd';
import LoginMain from './Main/Main';
import "@/views/Login/Main/MainStyle.scss"

const { Header, Footer, Sider, Content } = Layout;

const Login: React.FC = () => (
    <div className='slick-login'>
        <Card title="Please Login" >
            <LoginMain />
        </Card>
    </div>
);
export default Login;
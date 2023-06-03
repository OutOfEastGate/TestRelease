import React from 'react';
import { Card } from 'antd';
import LoginMain from './Main/Main';
import "@/views/Login/Main/MainStyle.scss"

const Login: React.FC = () => (
    <div className='slick-login'>
        <Card title="请登录" className={"login-card"} >
            <LoginMain />
        </Card>
    </div>
);
export default Login;
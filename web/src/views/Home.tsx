import React, { useState } from 'react';
import {Avatar, Breadcrumb, Layout, Space, theme} from 'antd';
import { Outlet } from "react-router-dom"
import MainMenu from '@/components/MainMenu';
import { getUserDetails } from '@/request/api';
import LineInfo from "@/views/UserInfo/LineInfo";

const { Header, Content, Footer, Sider } = Layout;


const Home: React.FC = () => {
    const [collapsed, setCollapsed] = useState(false);
    const {
        token: { colorBgContainer },
    } = theme.useToken();


    return (
        <Layout style={{ minHeight: '100vh' }}>
            <Sider collapsible collapsed={collapsed} onCollapse={(value) => setCollapsed(value)}>
                <div style={{ height: 32, margin: 16, background: 'rgba(255, 255, 255, 0.2)' }} />
                <MainMenu />
            </Sider>
            <Layout className="site-layout">
                <Header style={{ padding: 0, background: colorBgContainer }}>
                    <LineInfo>
                    </LineInfo>
                </Header>

                <Content style={{ margin: '16px 16px 0px' }} className="site-layout-background">
                    <Outlet />
                </Content>
                <Footer style={{ textAlign: 'center',padding:0, lineHeight:"48px" }}><Avatar src="https://cdn.casbin.org/img/casbin.svg" /> Casdoor + springboot-3.0 ©2023 Created by WHT</Footer>
            </Layout>
        </Layout>
    );

};

export default Home;
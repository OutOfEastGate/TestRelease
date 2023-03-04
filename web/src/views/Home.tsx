import React, { useState } from 'react';
import { Breadcrumb, Layout, theme } from 'antd';
import { Outlet } from "react-router-dom"
import MainMenu from '@/components/MainMenu';

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
            {/* <Breadcrumb style={{ margin: '16px 16px' }}>
            <Breadcrumb.Item>User</Breadcrumb.Item>
            <Breadcrumb.Item>Bill</Breadcrumb.Item>
            </Breadcrumb> */}
          </Header>

        <Content style={{ margin: '16px 16px 0px' }} className="site-layout-background">
          <Outlet />
        </Content>
        <Footer style={{ textAlign: 'center',padding:0, lineHeight:"48px" }}>Ant Design ©2018 Created by Ant UED</Footer>
      </Layout>
    </Layout>
  );
};

export default Home;
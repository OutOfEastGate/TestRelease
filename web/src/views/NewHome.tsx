import React, { useState } from 'react';
import {Avatar, Card, FloatButton, Modal} from 'antd';
import {Outlet, useLocation, useNavigate} from "react-router-dom"
import LineInfo from "@/views/UserInfo/LineInfo";
import {ProLayout} from "@ant-design/pro-components";
import defaultProps from './_props'
import i18n from "i18next";
import {CommentOutlined, QuestionCircleOutlined} from "@ant-design/icons";
import SSEConnection from "@/request/Sse";


const Home: React.FC = () => {
    const navigateTo = useNavigate();
    const [pathname, setPathname] = useState('/homepage');
    const location = useLocation();
    const [openAnno, setOpenAnno] = useState(false)
    const menuClick = (e:any) =>{
        //点击跳转对应路由
        setPathname(e.key)
        navigateTo(e.key);
    }


    function toChat() {
        navigateTo("/chat")
    }

    return (
        <div
            style={{
                height: '100vh',
            }}
        >
            <ProLayout
                menuItemRender={(item, dom) => (
                    <div style={{display: 'flex', alignItems: 'center', gap: 8,}} onClick={() => menuClick(item)}>
                        {dom}
                    </div>
                )}
                subMenuItemRender={(_, dom) => (
                    <div style={{display: 'flex', alignItems: 'center', gap: 8,}}>
                        {dom}
                    </div>
                )}
                title={String(i18n.t("common:BlogManagement"))}
                logo="https://gw.alipayobjects.com/mdn/rms_b5fcc5/afts/img/A*1NHAQYduQiQAAAAAAAAAAABkARQnAQ"
                {...defaultProps}
                location={{
                    pathname: pathname,
                }}
                selectedKeys={[location.pathname]}
            >
                <Card>
                    <LineInfo></LineInfo>
                </Card>
                <Outlet />
            </ProLayout>
            <FloatButton.Group
                trigger="click"
                type="primary"
                style={{ right: 24 }}
                icon={<QuestionCircleOutlined />}
            >
                <FloatButton tooltip={<div>{i18n.t("info:Announcement")}</div>} onClick={() => setOpenAnno(true)}/>
                <FloatButton tooltip={<div>{i18n.t("info:GotoChatPage")}</div>} icon={<CommentOutlined />} onClick={toChat}/>
            </FloatButton.Group>

            <Modal
                title="通知公告"
                centered
                open={openAnno}
                onOk={() => setOpenAnno(false)}
                onCancel={() => setOpenAnno(false)}
                width={500}
            >
                <h1>欢迎光临！</h1>
                <Avatar src={"http://www.wanghongtao.xyz/app/file/6463715ee4b0c2ee0a1f2002.png"} size={200}></Avatar>
            </Modal>
        </div>
    );

};

export default Home;

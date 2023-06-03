import React, {useEffect, useState} from 'react';
import {DownOutlined, UserOutlined} from '@ant-design/icons';
import type { MenuProps } from 'antd';
import {Avatar, Button, Dropdown, Space} from 'antd';
import {Link} from "react-router-dom";
import { useTranslation } from 'react-i18next'
import {showMessage} from "@/components/Setting";
import i18n from "i18next";
import './List.scss'

const items: MenuProps['items'] = [
    {
        key: '1',
        label: (
            <Link to={{pathname: '/about'}}>{i18n.t("user:PersonalHomepage")}</Link>
        ),
    },
    {
        key: '2',
        danger: true,
        label: (
            <a target="_blank" rel="noopener noreferrer" onClick={logout}>
                {i18n.t("user:LogOut")}
            </a>
        ),
        disabled: false,
    }
];

const handleMenuClick: MenuProps['onClick'] = (e) => {

};

const menuProps = {
    items,
    onClick: handleMenuClick,
};


//退出登录
function logout() {
    window.localStorage.removeItem("token")
    window.localStorage.removeItem("username")
    location.reload()
}
interface childProps {
    children: {
        avatar:string
        name:string
        displayName:string
    };
}


const App: React.FC<childProps> = (props) => {
    const {children} = props
    const { t, i18n } = useTranslation()

    const changeLanguage = (lang: string) => {
        i18n.changeLanguage(lang).then(() => {
            var preLang = localStorage.getItem("lang")
            localStorage.setItem("lang",lang)
            if (preLang != lang){
                window.location.reload()
            }else {
                var msg = lang === "zh" ? "当前已经是中文" :" Current is English"
                showMessage("info",msg)
            }
        });
    }

    return (
        <>
            <Space>
                <>
                    <a onClick={() => changeLanguage('zh')}>中文</a><a onClick={() => changeLanguage('en')}>English</a>
                    <button className="lang-button">
                        <Dropdown menu={menuProps}>
                            <Space>
                                <span>{children.name}</span>
                                <DownOutlined />
                            </Space>
                        </Dropdown>
                        <div className="liquid"></div>
                    </button>
                </>

                <Avatar src={<img src={children.avatar} alt="avatar" />}  size={42}/>
            </Space>

        </>

    )
}
export default App;

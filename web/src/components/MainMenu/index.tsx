import {
    CloudUploadOutlined,
    DesktopOutlined,
    FileOutlined, GlobalOutlined, MehOutlined,
    PieChartOutlined,
    TeamOutlined,
    UserOutlined,
} from '@ant-design/icons';
import type { MenuProps } from 'antd';
import { useNavigate, useLocation } from "react-router-dom"
import { Menu } from 'antd';
import { useState } from 'react';
import i18n from "i18next";



type MenuItem = Required<MenuProps>['items'][number];

function getItem(
    label: React.ReactNode,
    key: React.Key,
    icon?: React.ReactNode,
    children?: MenuItem[],
): MenuItem {
    return {
        key,
        icon,
        children,
        label,
    } as MenuItem;
}

const items: MenuItem[] = [
    getItem(i18n.t("common:Homepage"),"/homepage",<GlobalOutlined />),
    getItem(i18n.t("common:Article"),"/article",<PieChartOutlined />),
    getItem(i18n.t("common:Users"),"/users",<UserOutlined />),
    getItem(i18n.t("common:Notification"),"/notification",<MehOutlined />),
    getItem(i18n.t("common:Edit"), '/edit', <PieChartOutlined />),
    getItem(i18n.t("common:MessageList"), '/messageList', <DesktopOutlined />),
    getItem(i18n.t("common:Chat"), '/chatManage', <TeamOutlined />, [getItem(i18n.t("common:GlobalChat"), '/chat')]),
    getItem(i18n.t("common:File"), '/fileManage', <CloudUploadOutlined />,[getItem(i18n.t("common:FileType"), '/fileType'),getItem(i18n.t("common:File"), '/file')]),
];

const MainMenu: React.FC = () => {
    const navigateTo = useNavigate();
    //当前所在路径
    const currentRoute = useLocation();
    const menuClick = (e:{key:string}) =>{
        //点击跳转对应路由
        navigateTo(e.key);
    }
    let firstOpenKey:string = "";
    //设置展开初始值
    const [openKeys,setOpenKeys] = useState([firstOpenKey]);
    function findKey(obj:MenuItem){
        return obj!.key === currentRoute.pathname;
    }
    const handleOpenChange = (keys:string[])=>{
        setOpenKeys([keys[keys.length-1]]);
    }

    for(let i=1;i<items.length;i++){
        // @ts-ignore
        if(items[i]!['children'] && items[i]!['children'].find(findKey)){
            firstOpenKey = items[i]!.key as string;
            break;
        }
    }

    return (
        <Menu theme="dark"
              openKeys={openKeys}
              defaultSelectedKeys={[currentRoute.pathname]}
              mode="inline" items={items}
              onClick={menuClick}
              onOpenChange={handleOpenChange} />
    )
}

export default MainMenu;
import {
    DesktopOutlined,
    FileOutlined,
    PieChartOutlined,
    TeamOutlined,
    UserOutlined,
  } from '@ant-design/icons';
  import type { MenuProps } from 'antd';
  import { useNavigate, useLocation } from "react-router-dom"
  import { Menu } from 'antd';
import { useState } from 'react';



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
    getItem("Homepage","/homepage",<PieChartOutlined />),
    getItem("Users","/users",<UserOutlined />),
    getItem('Role', '/role', <PieChartOutlined />),
    getItem('Permission', '/permission', <DesktopOutlined />),
    getItem('Chat', '/chat', <TeamOutlined />, [getItem('People Online', '/online'), getItem('Team 2', '/8')]),
    getItem('Files', '/file', <FileOutlined />),
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
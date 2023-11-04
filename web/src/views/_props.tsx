import {
    BugOutlined,
    ChromeFilled, CloudUploadOutlined,
    ControlOutlined,
    CrownFilled, DesktopOutlined, GlobalOutlined, MehOutlined, PieChartOutlined, RadarChartOutlined,
    SmileFilled,
    TabletFilled, TeamOutlined, UserOutlined,
} from '@ant-design/icons';
import {MenuProps} from "antd";
import i18n from "i18next";
import Announcement from "@/components/Common/Notification/Announcement";
import HomePage from "@/components/Common/HomePage";
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


export default {
    route: {
        path: '/',
        routes: [
            {
                path: '/homepage',
                name: i18n.t("common:Homepage"),
                icon: <SmileFilled />,
                component: <HomePage />,

            },
            {
                path: '/article',
                name: i18n.t("common:Article"),
                icon: <CrownFilled />,
                routes:[
                    {
                        path: "/articlePage",
                        name: i18n.t("common:ArticlePage"),
                    },
                    {
                        path: "/article",
                        name: i18n.t("common:Article"),
                    },
                    {
                        path: "/edit",
                        name: i18n.t("common:Edit"),
                        icon: <ChromeFilled />,
                    },
                ]

            },
            {
                name: i18n.t("common:Users"),
                icon: <UserOutlined />,
                path: '/users',
                component: './ListTableList',
            },
            {
                path: '/notification',
                name: i18n.t("common:Notification"),
                icon: <MehOutlined />,
                routes:[
                    {
                        path: "/notification",
                        name: i18n.t("common:Notification"),
                        icon: <Announcement />,
                    },
                    {
                        path: "/announcement",
                        name: i18n.t("common:Announcement"),
                        icon: <Announcement />,
                    },
                ]
            },
            {
                path: "/chatManage",
                name: i18n.t("common:Chat"),
                icon: <TeamOutlined />,
                routes:[
                    {
                        path: "/chat",
                        name: i18n.t("common:GlobalChat"),
                        icon: <ChromeFilled />,
                    },
                    {
                        path: "/messageList",
                        name: i18n.t("common:MessageList"),
                        icon: <DesktopOutlined />,
                    },
                ]
            },
            {
                path:"/",
                name: i18n.t("common:File"),
                icon: <CloudUploadOutlined />,
                routes:[
                    {
                        path:"/fileType",
                        name:i18n.t("common:FileType"),
                    },
                    {
                        path:"/file",
                        name:i18n.t("common:File"),
                    }
                ]
            },
            {
                path: '/permission',
                name: i18n.t("common:PermissionCenter"),
                icon: <ControlOutlined />,
                routes:[
                    {
                        path: '/script',
                        name: i18n.t("common:Script"),
                        icon: <BugOutlined />,
                    },
                    {
                        path:"/store",
                        name:i18n.t("permission:StoreManage"),
                    },
                    {
                        path:"/model",
                        name:i18n.t("permission:ModelManage"),
                    }
                ]
            },

            {
                path: '/ip',
                name: i18n.t("common:SystemInfo"),
                icon: <RadarChartOutlined />,
                routes:[
                    {
                        path:"/ip",
                        name:i18n.t("common:Ip"),
                    },
                    {
                        path:"/system",
                        name:i18n.t("common:SystemInfo"),
                    }
                ]
            }
        ],
    },

    appList: [
        {
            icon: 'http://www.wanghongtao.xyz/app/file/644a808f887e396c183cd956.jpeg',
            title: '王洪涛的Blog',
            desc: '王洪涛的Blog',
            url: 'http://wanghongtao.xyz/',
        }
    ],
};
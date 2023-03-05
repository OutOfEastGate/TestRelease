import { ProList } from '@ant-design/pro-components';
import { Button, Space, Tag } from 'antd';
import React from "react";

interface DataType {
    owner: string;
    name: string;
    displayName: string;
    avatar: string;
    email: string;
    tag: string
}

interface PropsType {
    children:DataType
}

class UserTable extends React.Component<any,any> {
    constructor(props:PropsType) {
        super(props);
    }
    render() {
        return (
            <ProList<any>
                toolBarRender={() => {
                    return [
                        <Button key="add" type="primary">
                            新建
                        </Button>,
                    ];
                }}
                onRow={(record: any) => {
                    return {
                        onMouseEnter: () => {
                            console.log(record);
                        },
                        onClick: () => {
                            console.log(record);
                        },
                    };
                }}
                rowKey="name"
                headerTitle="用户"
                tooltip="用户列表"
                dataSource={this.props.children}
                showActions="hover"
                showExtra="hover"
                metas={{
                    title: {
                        dataIndex: 'name',
                    },
                    avatar: {
                        dataIndex: 'avatar',
                    },
                    description: {
                        dataIndex: 'email',
                    },
                    subTitle: {
                        dataIndex: 'tag',
                        render: (tag) => {
                            return (
                                <Space size={0}>
                                    <Tag color="blue">{tag}</Tag>
                                </Space>
                            );
                        },
                    },
                    actions: {
                        render: (text, row) => [
                            <a href={row.html_url} target="_blank" rel="noopener noreferrer" key="link">
                                链路
                            </a>,
                            <a href={row.html_url} target="_blank" rel="noopener noreferrer" key="warning">
                                报警
                            </a>,
                            <a href={row.html_url} target="_blank" rel="noopener noreferrer" key="view">
                                查看
                            </a>,
                        ],
                    },
                }}
            />
        )
    }
}

export default UserTable
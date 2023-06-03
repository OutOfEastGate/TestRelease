import React, { useState } from 'react';
import { Avatar, Col, Divider, Drawer, List, Row } from 'antd';
import { Image } from 'antd';
import './style.css'

interface DescriptionItemProps {
    title: string;
    content: React.ReactNode;
}

const DescriptionItem = ({ title, content }: DescriptionItemProps) => (
    <div className="site-description-item-profile-wrapper">
        <p className="site-description-item-profile-p-label">{title}:</p>
        {content}
    </div>
);

interface data {
    open: boolean,
    close: object,
    user: User
}

interface User {
    owner: string;
    name: string;
    displayName: string;
    avatar: string;
    email: string;
    phone: string;
    tag: string;
    location: string;
    createdTime: string;
    homepage: string;
    signupApplication: string;
}

class UserInfo extends React.Component<any, any> {
    constructor(props: data) {
        super(props)
        this.state={
            user: this.props.user,
            open: this.props.open,
            close: this.props.close
        }

    }
    handleClose = () => {
        this.props.close()
    }


    render() {
        if (this.props.user != null)
        return (
            <>
                <Drawer width={640} placement="right" closable={true} onClose={this.handleClose} open={this.props.open}>
                    <p className="site-description-item-profile-p" style={{ marginBottom: 24 }}>
                        用户详细信息
                    </p>
                    <p className="site-description-item-profile-p">头像</p>
                    <Row>
                        <Image width={100} src={this.props.user.avatar} />
                    </Row>
                    <Row>
                        <Col span={12}>
                            <DescriptionItem title="显示名称" content={this.props.user.name} />
                        </Col>
                        <Col span={12}>
                            <DescriptionItem title="邮箱" content={this.props.user.email} />
                        </Col>
                    </Row>
                    <Row>
                        <Col span={12}>
                            <DescriptionItem title="居住地" content={this.props.user.location} />
                        </Col>
                        <Col span={12}>
                            <DescriptionItem title="手机号" content={this.props.user.phone} />
                        </Col>
                    </Row>
                    <Row>
                        <Col span={12}>
                            <DescriptionItem title="创建时间" content={this.props.user.createdTime} />
                        </Col>
                        <Col span={12}>
                            <DescriptionItem title="个人网站" content={this.props.user.homepage} />
                        </Col>
                    </Row>
                    <Row>
                        <Col span={24}>
                            <DescriptionItem
                                title="所属组织"
                                content={this.props.user.signupApplication}
                            />
                        </Col>
                    </Row>
                    <Divider />
                </Drawer>
            </>
        );
    }
};

export default UserInfo;

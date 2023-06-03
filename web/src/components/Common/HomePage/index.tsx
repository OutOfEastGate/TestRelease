import { LikeOutlined, MessageOutlined, StarOutlined } from '@ant-design/icons';
import {Avatar, Badge, Card, List, Space} from 'antd';
import React from 'react';
import {getArticlesByPage} from "@/request/api";
import {Link} from "react-router-dom";
import Loading from "@/components/Util/Loading";

interface StateType{
    articles: Page<Article[]>
}
const IconText = ({ icon, text }: { icon: React.FC; text: string }) => (
    <Space>
        {React.createElement(icon)}
        {text}
    </Space>
);

class App extends React.Component<any, StateType>{
    constructor(props:any) {
        super(props);
        this.state={
            articles:{
                currentPage:0,
                pageSize: 0,
                total:0,
                data:[]
            },
        }
    }

    handleGetAllArticles() {
        getArticlesByPage({currentPage:0,pageSize:3}).then((res) => {
            this.setState({
                articles: res.data
            })
        })
    }

    getArticleList = () => {
        return <List
            itemLayout="vertical"
            size="large"
            pagination={{
                total:this.state.articles.total,
                pageSize: 3,
                onChange: (page) => {
                    getArticlesByPage({currentPage:page - 1,pageSize:3}).then((res) => {
                        this.setState({
                            articles: res.data
                        })
                    })
                },
            }}
            dataSource={this.state.articles.data}
            renderItem={(item) => (
                <List.Item
                    key={item.title}
                    actions={[
                        <IconText icon={StarOutlined} text="156" key="list-vertical-star-o" />,
                        <IconText icon={LikeOutlined} text="156" key="list-vertical-like-o" />,
                        <IconText icon={MessageOutlined} text="2" key="list-vertical-message" />,
                    ]}
                    extra={
                        <img
                            width={150}
                            alt="logo"
                            src={item.image}
                        />
                    }
                >
                    <Badge.Ribbon text="文章">
                    </Badge.Ribbon>
                    <List.Item.Meta
                        avatar={<Avatar src={item.authorAvatar} />}
                        title={<Link to={"/article/"+item.id}>{item.title}</Link>}
                        description={item.description}
                    />
                        {item.content}
                    </List.Item>

            )}
        />
    }

    render() {
        if (this.state.articles.data.length === 0){
            this.handleGetAllArticles()
        }
        return(
            <>
                {this.state.articles.data.length === 0 ? <Loading/> : <Card >{this.getArticleList()}</Card>}
            </>
        )
    }
}

export default App;
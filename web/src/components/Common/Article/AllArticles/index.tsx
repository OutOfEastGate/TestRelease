import React from 'react';
import {Button, Popconfirm, Table} from 'antd';
import {deleteArticle, getAllArticles, getArticleById, searchArticle} from "@/request/api";
import ArticleDetail from "@/components/Common/Article/ArticleDetail";
import Loading from "@/components/Util/Loading";
import {showMessage} from "@/components/Setting";
import './table.css'
import {Link} from "react-router-dom";
import Search from "antd/es/input/Search";

class Articles extends React.Component<any, any> {
    constructor(props:any) {
        super(props);
        this.state = {
            articles:[],
            openDetail: false,
            currentArticle: null
        }
    }

    getAllArticles() {
        getAllArticles().then((res:AllArticles) => {
            this.setState({
                articles: res.data
            })
        })
    }
    handleDetails(id: string) {
        this.setState({
            openDetail:true
        })
        getArticleById(id).then(res => {
            this.setState({
                currentArticle: res.data
            })
        })
    }

    handleCloseDetails = () => {
        this.setState({
            currentArticle: null,
            openDetail: false
        })
    }

    confirm = (id:string) => {
        deleteArticle({id:id}).then(res => {
            console.log(res)
            if (res.msg === "success") {
                showMessage("success","删除成功")
                this.getAllArticles()
            }else {
                showMessage("error",res.msg)
            }
        })
    };

    cancel = () => {
        showMessage("info","已取消")
    };

    onSearch = (text:string) => {
        searchArticle(text).then(res => {
            if (res.data.length === 0) {
                showMessage("info","无结果")
            } else {
                this.setState({
                    articles: res.data
                })
            }
        })
    }

    render() {
        const columns = [
            {
                title: '标题',
                dataIndex: 'title',
                key: 'title',
            },
            {
                title: '描述',
                dataIndex: 'description',
                width: 300,
                key: 'description',
            },
            {
                title: '作者',
                dataIndex: 'author',
                key: 'author'
            },
            {
                title: '封面',
                key: 'author',
                render: (record: Article) => (
                    <>
                        <img src={record.image} width={64}/>
                    </>
                )
            },
            {
                title: '操作',
                key: 'actions',
                render: (text: any, record: Article) => (
                    <>
                        <Button onClick={() => this.handleDetails(record.id)} type="primary"  >详情</Button>
                        <Link to={"/edit/"+record.id}><Button type="primary">编辑</Button></Link>
                        <Popconfirm
                            title="删除文章"
                            description="确定要删除文章吗?"
                            onConfirm={() => this.confirm(record.id)}
                            onCancel={() => this.cancel()}
                            okText="是"
                            cancelText="否"
                        >
                            <Button type="primary"  danger>删除</Button>
                        </Popconfirm>
                    </>
                ),
            }
        ];
        if (this.state.articles.length === 0) {
            this.getAllArticles()
        }
        const pagination = {
            pageSize: 5, // 设置每页显示的行数为 6
        };

        return (
            <>
                {
                    this.state.articles.length === 0 ? <Loading /> :
                        <>
                            <Search placeholder="input search text" allowClear onSearch={this.onSearch} style={{ width: 200 }} />
                            <Table className="selectable-table"
                                   columns={columns}
                                   dataSource={this.state.articles}
                                   rowKey="id"
                                   pagination={pagination}
                            />
                            <ArticleDetail
                            open={this.state.openDetail} close={this.handleCloseDetails}
                            article={this.state.currentArticle}/>
                        </>
                }
            </>
        );
    }
};

export default Articles;
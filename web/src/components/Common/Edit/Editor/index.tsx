import MarkdownEditor from "@uiw/react-markdown-editor";
import React from "react";
import {Affix, Image, Button, Card, Col, Input, Row, Tabs, TabsProps, Upload} from 'antd';
import "./styles.css";
import {showMessage} from "@/components/Setting";
import {editArticle, getArticleById, saveArticle} from "@/request/api";
import {UploadOutlined} from "@ant-design/icons";
import {uploadFile} from "@/request/Upload";

class Editor extends React.Component<any, any> {
    constructor(props:any) {
        super(props);
        this.state = {
            articleId: null,
            image: "http://www.wanghongtao.xyz/app/file/644a808f887e396c183cd956.jpeg",
            author: localStorage.getItem("username") as string,
            title: "",
            description: "",
            markdownVal: `# title\n\nHello World!\n\n`
        }
    }
    setMarkdownVal = (markdownVal:string) => {
        this.setState({
            markdownVal:markdownVal
        })
    }

    upload = (file:File) => {
        uploadFile(file).then(res => {
            if (res.data.msg === "success") {
                showMessage("success","上传成功")
                this.setState({
                    image:res.data.data
                })
            } else {
                showMessage("error",res.data.msg)
            }
        })
    }

    getArticleById() {
        const articleId = window.location.pathname.match(/\/edit\/([a-zA-Z0-9]+)/)?.[1] as string;

        if (articleId == undefined) return
        this.setState({
            articleId: articleId
        })
        getArticleById(articleId).then(res => {
            if (res.msg != "success") {
                showMessage("error",res.msg)
            }else {
                this.setState({
                    title:res.data.title,
                    description: res.data.description,
                    markdownVal:res.data.content,
                    image:res.data.image
                })
            }
        })

    }
    saveArticle = () => {
        if (this.state.title === "") {
            showMessage("error","请输入标题")
        } else if (this.state.description === "") {
            showMessage("error", "请输入描述")
        } else if (this.state.markdownVal === "") {
            showMessage("error", "请输入正文")
        } else {
            if (this.state.articleId == null) {
                saveArticle({
                    title:this.state.title,
                    description:this.state.description,
                    content:this.state.markdownVal,
                    author: this.state.author,
                    image: this.state.image
                }).then(res => {
                    if (res.msg === "success") {
                        this.setState({
                            articleId:res.data.id
                        })
                        showMessage(res.msg, "保存成功")
                    }else {
                        showMessage("error", res.msg)
                    }
                })
            }else {
                editArticle({
                    id:this.state.articleId,
                    title:this.state.title,
                    image:this.state.image,
                    description:this.state.description,
                    content:this.state.markdownVal
                }).then(res => {
                    if (res.msg === "success") {
                        showMessage(res.msg, "修改已经保存")
                    }else {
                        showMessage("error", res.msg)
                    }
                })
            }
        }
    }

    onTitleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        this.setState({
            title:e.target.value
        })
    }

    onDesChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        this.setState({
            description:e.target.value
        })
    }
    onChange = (key: string) => {
        console.log(key);
    };

    changeImage = (e:any) => {
        this.setState({
            image:e.target.value
        })
    }

    render() {
        const items: TabsProps['items'] = [
            {
                key: '1',
                label: `基础信息编辑`,
                children: this.getEditTitle(),
            },
            {
                key: '2',
                label: `文章编辑`,
                children: this.getEditContent(),
            },
        ];
        if (this.state.articleId == null) {
            this.getArticleById()
        }
        return (
            <div data-color-mode="light" className="app">
                <Tabs defaultActiveKey="1" items={items} onChange={this.onChange} />
            </div>
        )
    }

    private getEditContent() {
        return <div>
            <Row className="Card">
                <Col span={20}>
                    <MarkdownEditor
                        value={this.state.markdownVal}
                        onChange={(value) => {
                            this.setMarkdownVal(value)
                        }}
                    />
                </Col>
            </Row>
            <br/>

            <Affix offsetBottom={10}>
                <Button type="primary" onClick={this.saveArticle}> 保存 </Button>
            </Affix>
        </div>;
    }

    private getEditTitle() {
        return <div id="title" style={{height: '35vh'}}>
            <Row className="Card">
                <Col span={10}>
                    <Card title="标题" bordered={true}>
                        标题
                        <Input showCount maxLength={15} value={this.state.title} onChange={this.onTitleChange}
                        />
                        简介
                        <Input.TextArea showCount maxLength={100} value={this.state.description}
                                        onChange={this.onDesChange}/>
                        封面<br/>
                        <Image
                            width={200}
                            height={200}
                            src={this.state.image}
                        /><br/>
                        <Input placeholder="图片url" value={this.state.image} onChange={this.changeImage}/>
                        <Upload beforeUpload={this.upload}>
                            <Button icon={<UploadOutlined/>}>上传封面</Button>
                        </Upload>
                    </Card>
                </Col>
            </Row>
        </div>;
    }
}

export default Editor;
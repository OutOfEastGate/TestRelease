import React from 'react';
import { Button, Drawer, Radio, Space } from 'antd';
import Loading from "@/components/Util/Loading";
import {marked} from "marked";
import './article.css';

interface Article {
    id: string;
    title: string;
    description: string;
    content: string;
}
interface Props {
    open: boolean
    close: object
    article: Article
}
function MdToHtml(props:string) {
    return <div dangerouslySetInnerHTML={{ __html:  marked(props) }} />;
}

class App extends React.Component<any, any>{
    constructor(props:Props) {
        super(props);
        this.state = {
            open: false,
        }
    }

    showDrawer = () => {
        this.setState({
            open:true
        })
    };
    render() {
        return (
            <>
                <Drawer
                    title="文章详情"
                    placement={"top"}
                    width={100}
                    height={750}
                    onClose={this.props.close}
                    open={this.props.open}
                    extra={
                        <Space>
                            <Button onClick={this.props.close}>Cancel</Button>
                            <Button type="primary" onClick={this.props.close}>
                                OK
                            </Button>
                        </Space>
                    }
                >
                    {
                        this.props.article === null ? <Loading /> : <div className="markdown-body" style={{backgroundColor: 'white', color: "black"}}>
                            <h1 className="title">{this.props.article.title}</h1>
                            <h3>介绍：{this.props.article.description}</h3>
                            <br/>
                            {this.props.article.content === null ? <Loading /> : MdToHtml(this.props.article.content)}
                        </div>
                    }
                </Drawer>
            </>
        );
    }
};

export default App;
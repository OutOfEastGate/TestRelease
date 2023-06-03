import React from "react";
import {marked} from "marked";
import Loading from "@/components/Util/Loading";
import './article.css'
import {getArticleById} from "@/request/api";
import {Card, FloatButton} from "antd";
import i18n from "i18next";
import {showMessage} from "@/components/Setting";
import PersonalCard from "@/views/Article/PersonalCard";
import {
    DownOutlined,
    QuestionCircleOutlined,
    UpOutlined
} from "@ant-design/icons";


function MdToHtml(props:string) {
    return <div dangerouslySetInnerHTML={{ __html:  marked(props) }} />;
}

interface StateType{
    article: ArticleInfo | null,
    liked:boolean
}

class Article extends React.Component<any, StateType>{
    private readonly cardRef: React.RefObject<HTMLDivElement>;
    private readonly articleRef: React.RefObject<HTMLDivElement>;
    constructor(props:any) {
        super(props);
        this.state={
            article:null,
            liked:false
        }
        this.cardRef = React.createRef<HTMLDivElement>(); // 创建ref
        this.articleRef = React.createRef<HTMLDivElement>()
    }

    render() {
        if (this.state.article === null) {
            const articleId = window.location.pathname.match(/\/article\/([a-zA-Z0-9]+)/)?.[1] as string;
            getArticleById(articleId).then(res => {
                this.setState({
                    article:res.data
                })
            })
        }
        return(
            this.state.article === null ? <Loading /> :
             <div className="markdown-body" style={{backgroundColor: 'white', color: "black", padding:"30px"}}>
                <h1 className="title">{this.state.article.title}</h1>
                <h3>介绍：{this.state.article.description}</h3>
                <br/>
                 <div className="table-of-contents">
                     {this.generateTableOfContents()}
                 </div>
                <div ref={this.articleRef}>
                    {this.state.article.content === null ? <Loading /> : MdToHtml(this.state.article.content)}
                </div>
                 <Card style={{ textAlign: "center", display: "flex", flexDirection: "column", alignItems: "center"}} ref={this.cardRef}>
                     <button className={`like-button ${this.state.liked ?  '':'gray'}`} onClick={() => this.likeArticle(this.state.article != null ? this.state.article.id : "")}>
                      <span className="button-content">
                        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                            <path d="M0 0H24V24H0z" fill="none"></path>
                            <path
                            d="M12.001 4.529c2.349-2.109 5.979-2.039 8.242.228 2.262 2.268 2.34 5.88.236 8.236l-8.48 8.492-8.478-8.492c-2.104-2.356-2.025-5.974.236-8.236 2.265-2.264 5.888-2.34 8.244-.228z"
                            fill="currentColor"></path>
                        </svg>
                          {i18n.t("article:LikeArticle")}
                      </span>
                     </button>
                     <PersonalCard>{this.state.article.author}</PersonalCard>
                 </Card>

                 <FloatButton.Group shape="circle" style={{ right: 15 }}>
                     <FloatButton icon={<QuestionCircleOutlined />} />
                     <FloatButton icon={<UpOutlined />} onClick={this.article}/>
                     <FloatButton icon={<DownOutlined />} onClick={this.down}/>
                 </FloatButton.Group>
            </div>
        )
    }

    down = () => {
        if (this.cardRef.current) {
            this.cardRef.current.scrollIntoView({ behavior: 'smooth' });
        }
    }

    article = () => {
        if (this.articleRef.current) {
            this.articleRef.current.scrollIntoView({ behavior: 'smooth' });
        }
    }

    private likeArticle(articleId: string) {
        this.setState({
            liked: !this.state.liked
        })
        if (!this.state.liked){
            showMessage("success","点赞成功")
        } else {
            showMessage("info","已取消点赞")
        }
    }

    generateTableOfContents() {
        const content = marked(this.state.article != null ? this.state.article.content : "");
        if (!content) {
            return null;
        }

        const headings = content.match(/<h([1-6])[^>]*>.*?<\/h\1>/g);
        if (!headings) {
            return null;
        }

        return (
            <ul>
                {headings.map((heading: string, index: number) => {
                    const level = parseInt(heading.charAt(2), 10);
                    const text = heading.replace(/<[^>]+>/g, '');
                    const id = `heading${index}`;

                    return (
                        <li key={index} style={{ paddingLeft: `${level * 16}px` }}>
                            <a href={`#${id}`} onClick={this.scrollToHeading}>
                                {text}
                            </a>
                        </li>
                    );
                })}
            </ul>
        );
    }


    scrollToHeading = (event: React.MouseEvent<HTMLAnchorElement>) => {
        event.preventDefault();
        const headingId = event.currentTarget.getAttribute('href');
        const trimmedHeadingId = headingId && headingId.slice(1); // 去除 # 符号
        const headingElement = trimmedHeadingId && document.getElementById(trimmedHeadingId); // 添加条件检查
        if (headingElement) {
            headingElement.scrollIntoView({ behavior: 'smooth' });
        }
    };

}

export default Article;
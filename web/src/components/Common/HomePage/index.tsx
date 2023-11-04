import React from 'react';
import {
    Avatar,
    Card,
    Col,
    Descriptions,
    Form, Image, Input,
    Layout,
    List,
    Modal, Popconfirm, Progress,
    Row, Space, Spin,
    Tabs,
    TabsProps, Tag,
    Tooltip,
    Typography
} from "antd";
import {addWebsite, deleteWebsite, getAllWebsite, getHistoryToday, getWeather} from "@/request/api";
import {marked} from "marked";
import Sider from "antd/es/layout/Sider";
import {Content} from "antd/es/layout/layout";
import {EditOutlined, IeOutlined, LoadingOutlined, MinusOutlined, PlusOutlined} from '@ant-design/icons';
import {showMessage} from "@/components/Setting";
import Icon from "antd/es/icon";

const onChange = (key: string) => {

};

const contentStyle: React.CSSProperties = {
    textAlign: 'center',
    minHeight: 120,
    lineHeight: '120px',
};

const siderStyle: React.CSSProperties = {
    textAlign: 'center',
    lineHeight: '120px',
};

interface stateType{
    loading:boolean
    historyToday:GetHistoryToday[]
    weather: Weather | null
    openAddWebsite: boolean
    formData: Website;
    websites: Website[]
    spinning:boolean
}
class App extends React.Component<any, stateType>{
    constructor(props:any) {
        super(props);
        this.state={
            loading:true,
            historyToday:[],
            weather: null,
            openAddWebsite: false,
            formData:{
                id:'',
                name: '',
                link: '',
                desc: '',
                icon: '',
                title: ''
            },
            websites:[],
            spinning: false
        }
    }

    openAddWebsite = () => {
        this.setState({
            openAddWebsite: true
        })
    }

    closeAddWebsite = () => {
        this.setState({
            openAddWebsite: false
        })
    }

    deleteWebsite = (id:string) => {
        deleteWebsite(id).then(res => {
            if (res.msg === "success") {
                showMessage("success", "删除成功")
                this.reloadWebsite();
            }else {
                showMessage("error", "删除失败")
            }
        })
    }

    handleAddWebsite = () => {
        this.setState({
            spinning:true
        })
        addWebsite(this.state.formData).then(res => {
            if (res.msg === "success") {
                showMessage("success", "添加站点成功")
                this.closeAddWebsite()
                this.reloadWebsite();
                this.setState({
                    spinning:false
                })
            }
        })
    }

    private reloadWebsite() {
        getAllWebsite().then(res => {
            this.setState({
                websites: res.data
            })
        })
    }

    handleChange = (e: React.ChangeEvent<HTMLInputElement>, fieldName: keyof Website) => {
        const { formData } = this.state;
        const updatedFormData = { ...formData, [fieldName]: e.target.value };
        this.setState({ formData: updatedFormData });
    };

    render() {
        const items: TabsProps['items'] = [
            {
                key: '1',
                label: `历史上的今天`,
                children: this.getHistoryTodayComponent(),
            },
            {
                key: '2',
                label: `每日一句英文`,
                children: this.getEnglishTodayComponent(),
            }
        ];
        if (this.state.historyToday.length === 0) {
            getHistoryToday().then(res => {
                this.setState({
                    historyToday:res.data.result,
                    loading:false
                })
            })
        }
        if (this.state.weather === null) {
            getWeather().then(res => {
                this.setState({
                    weather: res.data.result
                })
            })
        }
        if (this.state.websites.length === 0) {
            getAllWebsite().then(res => {
                this.setState({
                    websites:res.data
                })
            })
        }



        return(
            <Layout hasSider>
                <Content style={contentStyle}>
                    <Card loading={this.state.weather === null}>
                        {this.getWeatherCard()}
                    </Card>
                    {this.getWebsiteCards()}
                    {this.getModal()}
                </Content>
                <Sider style={siderStyle}>
                    <Card loading={this.state.loading}>
                        <Tabs defaultActiveKey="1" items={items} onChange={onChange}/>
                    </Card></Sider>
            </Layout>
        )
    }

    private getModal() {
        return <Modal
            title="添加站点"
            centered
            open={this.state.openAddWebsite}
            onOk={() => this.handleAddWebsite()}
            onCancel={() => this.closeAddWebsite()}
            width={500}
        >
            <Spin spinning={this.state.spinning} delay={500}>

            </Spin>
            <Form
                name="wrap"
                labelCol={{flex: '110px'}}
                labelAlign="left"
                labelWrap
                wrapperCol={{flex: 1}}
                colon={false}
                style={{maxWidth: 600}}
            >
                <Form.Item label="站点名称" name="name">
                    <Input onChange={e => this.handleChange(e, 'name')}/>
                </Form.Item>

                <Form.Item label="站点url" name="link" rules={[{type: 'url', warningOnly: true}]}>
                    <Input onChange={e => this.handleChange(e, 'link')}/>
                </Form.Item>

                <Form.Item label="描述" name="desc">
                    <Input onChange={e => this.handleChange(e, 'desc')}/>
                </Form.Item>
            </Form>
        </Modal>;
    }

    private getWebsiteCards() {
        return<>
            <Space direction="vertical" size="middle" style={{ display: 'flex' }}>
                {Array.from({ length: Math.ceil(this.state.websites.length / 3) }).map((_, rowIndex) => (
                    <Row gutter={16} key={rowIndex}>
                        {this.state.websites.slice(rowIndex * 3, rowIndex * 3 + 3).map((website) => (
                            <Col span={8} key={website.id}>
                                <Card title={this.getTitle(website)} bordered={false}>
                                    {website.icon === "" ? <IeOutlined />:<Avatar src={<img src={website.icon} alt="avatar"/>} size={42}/>}<br/>
                                    <Tag color="magenta">{website.title}</Tag><br/>
                                    <Tag color="blue">{MdToHtml(website.desc)}</Tag>
                                </Card>
                            </Col>
                        ))}
                    </Row>
                ))}
                <Row gutter={16}>
                    <Col span={8} onClick={this.openAddWebsite}>
                        <Card bordered={false} title={"添加"}>
                            <Tooltip placement="leftTop" title={"添加站点"} arrow={true}>
                                <PlusOutlined />
                            </Tooltip>
                        </Card>
                    </Col>
                </Row>
            </Space>


        </>
    }

    private getTitle(website: Website) {
        return <div><a href={website.link}>{website.name}</a>
            <Popconfirm
                title="删除站点"
                description="确定删除站点？"
                okText="是"
                cancelText="否"
                onConfirm={() => this.deleteWebsite(website.id)}
            >
                <Tooltip placement="leftTop" title={"删除站点"} arrow={true}>
                    <Tag color="red"><MinusOutlined /></Tag>
                </Tooltip>
            </Popconfirm>
            <Tooltip placement="leftTop" title={"编辑站点"} arrow={true}>
                <Tag color="green"><EditOutlined /></Tag>
            </Tooltip>
        </div>;
    }

    private getHistoryTodayComponent() {
        return(
            <List
                header={<div>历史上的今天</div>}
                bordered
                dataSource={this.state.historyToday}
                renderItem={(item) => (
                    <Tooltip placement="leftTop" title={MdToHtml(item.desc)} arrow={true}>
                        <List.Item onClick={() => this.openDetail(item)}>
                            <Typography.Text mark>{item.year}</Typography.Text> {item.title}
                        </List.Item>
                    </Tooltip>
                )}
            />
        )
    }
    private getEnglishTodayComponent() {
        return(
           <Card>
              <Image key={"https://cn.bing.com/th?id=OHR.HalfwayBoats_ZH-CN3563044251_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp"}></Image>
           </Card>
        )
    }
    openDetail = (item:GetHistoryToday) => {

    }

    private getCardTitle(title:string, link:string) {
        return(
            <div>
                {title}
            </div>
        )
    }

    private getWeatherCard = () => {
        if (this.state.weather === null) {

        }else {
            return (
                <Descriptions title="天气">
                    <Descriptions.Item label="城市">{this.state.weather.city.counname} {this.state.weather.city.name}</Descriptions.Item>
                    <Descriptions.Item label="天气">{this.state.weather.condition.condition}</Descriptions.Item>
                    <Descriptions.Item label="风向">{this.state.weather.condition.windDir}  {this.state.weather.condition.windLevel}级</Descriptions.Item>
                    <Descriptions.Item label="小贴士">{this.state.weather.condition.tips}</Descriptions.Item>
                    <Descriptions.Item label="日升">{this.state.weather.condition.sunRise}</Descriptions.Item>
                    <Descriptions.Item label="日落">{this.state.weather.condition.sunSet}</Descriptions.Item>
                    <Row gutter={16}>
                        {
                            this.state.weather.forecast.map(f =>(
                                <Col span={3.2}>
                                    <Card title={f.predictDate} bordered={false}>
                                        白天：{f.conditionDay} 晚上：{f.conditionNight}
                                    </Card>
                                </Col>
                            ))
                        }
                    </Row>
                </Descriptions>
            )
        }
    }


}
function MdToHtml(props:string) {
    return <div dangerouslySetInnerHTML={{ __html:  marked(props) }} />;
}
export default App;
import {Avatar, Button, Divider, Form, Input, List, Modal, Popconfirm, Radio, Upload} from 'antd';
import React, {ChangeEventHandler, useState} from 'react';
import {ProCard} from "@ant-design/pro-components";
import {UploadOutlined} from "@ant-design/icons";
import {uploadFile} from "@/request/Upload";
import {showMessage} from "@/components/Setting";
import {addFileType, deleteFileType, editFileType, getAllFileType} from "@/request/api";
import Loading from "@/components/Util/Loading";

interface FileTypeInfo{
    id:string;
    image:string;
    title:string;
    description:string
}

class FileType extends React.Component<any, any>{
    constructor(props:any) {
        super(props);
        this.state = ({
            isModalOpen: false,
            isEdit: false,
            typeInfo: {
                image: "http://www.wanghongtao.xyz/app/file/644a808f887e396c183cd956.jpeg",
                title: "",
                description: ""
            },
            AllTypeInfo:[]
        })
    }

    upload = (file:File) => {
        uploadFile(file).then(res => {
            if (res.data.msg === "success") {
                showMessage("success","上传成功")
                this.setState({
                    typeInfo: {
                        ...this.state.typeInfo,
                        image: res.data.data
                    }
                })
            } else {
                showMessage("error",res.data.msg)
            }
        })
    }

    addFileType = () => {
        this.setState({
            isEdit:false,
            typeInfo:{
                ...this.state.typeInfo,
                title:"",
                description:""
            }
        })
        this.showModal()
    }

    showModal = () => {
        this.setState({
            isModalOpen: true
        })
    };

    handleAddFileType = () => {
        addFileType(this.state.typeInfo).then(res => {
            if (res.msg === "success") {
                showMessage("success","新增成功")
                this.handleGetAllFileType()
            } else {
                showMessage("error", "新增失败" + res.msg)
            }
        })
    }
    handleEditFileType = () => {
        editFileType(this.state.typeInfo).then(res => {
            if (res.msg === "success") {
                showMessage("success","编辑成功")
                this.handleGetAllFileType()
            } else {
                showMessage("error", "编辑失败：" + res.msg)
            }
        })
    }
    handleOk = () => {
        if (this.state.typeInfo.title === "") {
            showMessage("info", "请填写标题")
        } else {
            if(this.state.isEdit) {
                this.handleEditFileType()
            }else {
                this.handleAddFileType()
            }
            this.setState({
                isModalOpen: false
            })
        }
    };

    handleCancel = () => {
        this.setState({
            isModalOpen: false
        })
    };

    handleGetAllFileType = () => {
        getAllFileType().then(res => {
            this.setState({
                AllTypeInfo: res.data
            })
        })
    }

    changeTitle = (title:any) => {
        this.setState({
            typeInfo: {
                ...this.state.typeInfo,
                title: title.target.value
            }
        })
    }

    changeDesc = (description:any) => {
        this.setState({
            typeInfo: {
                ...this.state.typeInfo,
                description: description.target.value
            }
        })
    }

    changeImage = (e:any) => {
        this.setState({
            typeInfo: {
                ...this.state.typeInfo,
                image: e.target.value
            }
        })
    }

    confirm = (id:string) => {
        this.handleDeleteFileType(id)
    };

    cancel = () => {
        showMessage("info","已取消")
    };

    render() {
        if (this.state.AllTypeInfo.length === 0) {
            this.handleGetAllFileType()
        }
        return(
            <ProCard colSpan={16}>
                <Button type="primary" onClick={this.addFileType}>
                    新增分类
                </Button>
                <Divider plain></Divider>
                <Modal title={this.state.isEdit ? "编辑文件分类" : "新增文件分类"} open={this.state.isModalOpen}
                       onOk={this.handleOk} okText={'保存'} onCancel={this.handleCancel} cancelText={'取消'}>
                    {this.getFormItem()}
                </Modal>
                {this.state.AllTypeInfo.length === 0 ? <Loading/> :
                    this.getFileTypeList()}
            </ProCard>
        )
    }


    private getFileTypeList() {
        return <List
            itemLayout="horizontal"
            dataSource={this.state.AllTypeInfo}
            renderItem={(item: FileTypeInfo, index) => (
                <List.Item
                    actions={[<Button type={"primary"} onClick={() => this.editFileType(item)}>编辑</Button>,
                        this.getDeleteConfirm(item),
                    ]}>
                    <List.Item.Meta
                        avatar={<Avatar src={item.image}/>}
                        title={<a href="https://ant.design">{item.title}</a>}
                        description={item.description}
                    />
                </List.Item>
            )}
        />;
    }

    private getFormItem() {
        return <>
            <Form.Item label="分类图标">
                <Avatar size={64} src={this.state.typeInfo.image}/>
                <br></br>
                <Input placeholder="图片url" value={this.state.typeInfo.image} onChange={this.changeImage}/>
                <Upload beforeUpload={this.upload}>
                    <Button icon={<UploadOutlined/>}>上传头像</Button>
                </Upload>
            </Form.Item>
            <Form.Item label="分类名称">
                <Input placeholder="输入分类名称" value={this.state.typeInfo.title} onChange={this.changeTitle}/>
            </Form.Item>
            <Form.Item label="分类描述">
                <Input placeholder="输入分类描述" value={this.state.typeInfo.description} onChange={this.changeDesc}/>
            </Form.Item>
        </>;
    }

    private getDeleteConfirm(item: FileTypeInfo) {
        return <Popconfirm
            title="删除文件"
            description="确定要删除文件类型吗?"
            onConfirm={() => this.confirm(item.id)}
            onCancel={() => this.cancel()}
            okText="是"
            cancelText="否">
            <Button type={"primary"} danger>删除</Button>
        </Popconfirm>;
    }

    editFileType = (fileType: FileTypeInfo) => {
        this.setState({
            isEdit:true,
            typeInfo: {
                id: fileType.id,
                image: fileType.image,
                title: fileType.title,
                description: fileType.description
            },
        })
        this.showModal()
    }

    handleDeleteFileType = (id: string)  => {
        deleteFileType(id).then(res => {
            if (res.msg === "success") {
                showMessage("success", "删除成功")
                this.handleGetAllFileType()
            }else {
                showMessage("error","删除失败："+res.msg)
            }
        })
    }
};

export default FileType;

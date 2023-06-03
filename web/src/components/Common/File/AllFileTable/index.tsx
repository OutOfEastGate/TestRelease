import React, {ReactNode} from "react";
import {
    Avatar,
    Button, Divider,
    Dropdown,
    Form,
    Image,
    Input,
    MenuProps,
    Modal,
    Popconfirm,
    Select,
    Space,
    Table,
    Upload
} from "antd";
import {deleteFile,  editFileInfo, getAllFiles, getAllFileType, getFilesByTypeId} from "@/request/api";
import { showMessage} from "@/components/Setting";
import {CopyOutlined, DownOutlined, UploadOutlined, UserOutlined} from "@ant-design/icons";
import {uploadFile} from "@/request/Upload";
import './allFileTable.css'

interface FineType{
    id:string,
    image:string,
    title:string,
    description:string
}
interface StateTypes{
    file:any,
    files:FileInfo[],
    fileTypes:FineType[],
    showEdit:boolean
}
class AllFileTable extends React.Component<any, StateTypes>{
    constructor(props:any) {
        super(props);
        this.state = ({
            file: null,
            files: [],
            fileTypes: [],
            showEdit: false
        })
    }
    private getFiles() {
        getAllFiles().then(res => {
            this.setState({
                files: res.data
            })
        })
    }

    private deleteFile(url: string) {
        deleteFile(url).then(res => {
            if (res.msg === "success") {
                showMessage("success", "删除成功")
                this.getFiles()
            } else {
                showMessage("error",res.msg)
            }
        })
    }

    private copyUrl(url: string) {
        const copyText = url;
        const textarea = document.createElement('textarea');
        textarea.style.position = 'fixed';
        textarea.style.opacity = '0';
        textarea.value = copyText;
        document.body.appendChild(textarea);
        textarea.select();
        document.execCommand('copy');
        document.body.removeChild(textarea);
        showMessage("success","复制成功")
    }

    upload = (file:File) => {
        uploadFile(file).then(res => {
            if (res.data.msg === "success") {
                this.getFiles()
                showMessage("success","上传成功")
            } else {
                showMessage("error",res.data.msg)
            }
        })
    }

    private download(filename:string,url:string) {
        fetch(url)
            .then(response => response.blob())
            .then(blob => {
                // 创建一个临时的 URL 对象，指向包含 Blob 数据的 URL
                const blobUrl = URL.createObjectURL(blob);
                // 创建一个<a>元素并设置其属性，然后模拟点击以启动下载
                const link = document.createElement('a');
                link.href = blobUrl;
                link.download = filename;
                document.body.appendChild(link);
                link.click();
                // 释放 URL 对象以节省内存
                URL.revokeObjectURL(blobUrl);
                document.body.removeChild(link);
            });
    }

    edit = (fileInfo:FileInfo)  => {
        this.setState({
            showEdit:true,
            file: fileInfo,
        })

    }

    confirm = (id:string) => {
        this.deleteFile(id)
    };

    cancel = () => {
        showMessage("info","已取消")
    };

    handleChangeSelectType = (selectType:string) => {
        console.log(selectType)
        this.setState({
            file:{
                ...this.state.file,
                objectType:selectType,
            }
        })
    }


    private getFormItem() {
        if (this.state.file != null)
        return (
            <>
                <Form.Item label="源文件名称">
                    <Input value={this.state.file.originalFilename}/>
                </Form.Item>
                <Form.Item label="分类" >
                    <Select
                        value={this.state.file.objectType}
                        defaultValue={"default"}
                        style={{ width: 120 }}
                        showSearch={true}
                        onSelect={this.handleChangeSelectType}
                        options={this.state.fileTypes.map(value => ({
                            key:value.id,
                            value:value.title,
                            label:<div><Avatar size={28} src={value.image}/><a>{value.title}</a></div>
                        }))}
                    />
                </Form.Item>
                <Form.Item label="备注">
                    <Input value={this.state.file.attr} disabled={true}/>
                </Form.Item>
                 <Form.Item label="创建时间">
                    <Input value={this.state.file.createTime} disabled={true}/>
                </Form.Item>
            </>
        )
    }

    handleOk = () => {
        editFileInfo(this.state.file).then(res => {
            if (res.msg === "success") {
                showMessage("success","修改成功")
                this.getFiles()
            } else {
                showMessage("error","修改失败：" + res.msg)
            }
        })
        this.setState({
            showEdit:false
        })
    };

    handleCancel = () => {
        this.setState({
            showEdit: false,
            file: null
        })
    };

    render() {
        if (this.state.files.length == 0) {
            this.getFiles();
        }
        if (this.state.fileTypes.length === 0) {
            getAllFileType().then(res => {
                this.setState({
                    fileTypes: res.data
                })
            });
        }
        const columes = [
            {
                key: "预览",
                title: '预览',
                width: 150,
                render:(record:FileInfo) => {
                    if (record.ext === "gif" || record.ext === "jpg" || record.ext === "png" || record.ext === "bmp" || record.ext === "jpeg") {
                        return(
                            <Image src={record.url}/>
                        )
                    }else {
                        return (
                            <CopyOutlined />
                        )
                    }
                }
            },
            {
                title: '源文件名称',
                dataIndex: 'originalFilename',
                key: 'originalFilename',
            },
            {
                title: '文件分类',
                dataIndex: 'objectType',
                key: 'objectType',
            },
            {
                title: '文件格式',
                dataIndex: 'ext',
                key: 'ext',
            },
            {
                title: '存储平台',
                dataIndex: 'platform',
                key: 'platform',
            },
            {
                title: '所属用户',
                dataIndex: 'objectId',
                key: 'objectId',
            },
            {
                title: '创建时间',
                dataIndex: 'createTime',
                key: 'createTime',
            },
            {
                key: '操作',
                title: '操作',
                width: 340,
                render:(record:FileInfo) => (
                    <>
                        <Button
                            type={"primary"}
                            onClick={() => this.copyUrl(record.url)}
                        >复制链接</Button>
                        <Button
                            type={"primary"}
                            onClick={() => this.download(record.originalFilename,record.url)}
                        >下载文件</Button>
                        <Button
                            type={"primary"}
                            onClick={() => this.edit(record)}
                        >编辑</Button>
                        <Popconfirm
                            title="删除文件"
                            description="确定要删除文件吗?"
                            onConfirm={() => this.confirm(record.url)}
                            onCancel={() => this.cancel()}
                            okText="是"
                            cancelText="否"
                        >
                            <Button
                                type={"primary"}
                                danger>删除</Button>
                        </Popconfirm>
                    </>
                )
            }
        ]

        return (
            <>
                <div>
                    <Modal title={"编辑文件信息"} open={this.state.showEdit}
                           onOk={this.handleOk} okText={'保存'} onCancel={this.handleCancel} cancelText={'取消'}>
                        {this.getFormItem()}
                    </Modal>
                    {this.getSelect()}
                    <Upload beforeUpload={this.upload}>
                        <Button icon={<UploadOutlined />}>点击上传文件</Button>
                    </Upload>
                    <Table
                        columns={columes}
                        dataSource={this.state.files}
                        pagination={{pageSize: 4}}
                        scroll={{ x: 1000, y: 400 }}
                    />
                </div>
            </>
        )
    }

    handleMenuClick: MenuProps['onClick'] = (e) => {
        getFilesByTypeId(e.key).then(res => {
            this.setState({
                files:res.data
            })
        })
    };

    private  getSelect() {
        const items: MenuProps['items'] = this.state.fileTypes.map((value, index) => ({
            label: value.title,
            key: value.id.toString(),
            icon: <Avatar size={32} src={value.image}/>
        }));
        const menuProps = {
            items,
            onClick: this.handleMenuClick,
        }
        return <Dropdown menu={menuProps}>
            <Button>
                <Space>
                    选择文件分类
                    <DownOutlined/>
                </Space>
            </Button>
        </Dropdown>;
    }
}

export default AllFileTable;
import React from "react";
import {Modal, Tabs, TabsProps} from "antd";
import Loading from "@/components/Util/Loading";
import {getAllModals} from "@/request/api";
import {JSONTree} from "react-json-tree";
import AceEditor from "react-ace";



interface PropsType{
    isModalOpen: boolean
    closeModal:() => void
    id:string
}

interface StateType{
    isModalOpen: boolean
    modalString:object
}
class App extends React.Component<PropsType, StateType>{
    constructor(props:any) {
        super(props);
        // @ts-ignore
        this.state= {
            isModalOpen: props.isModalOpen,
            modalString: {}
        }
    }
    isEmptyObject = (obj: object) => {
        return Object.keys(obj).length === 0;
    };



    render() {


        const items: TabsProps['items'] = [
            {
                key: '1',
                label: `查看模型`,
                children: this.getShowModal(),
            },
            {
                key: '2',
                label: `修改模型`,
                children: this.getAceEditor(),
            }
        ];

        if (this.isEmptyObject(this.state.modalString)) {
            getAllModals(this.props.id).then(res => {
                this.setState({
                    modalString: res.data.authorization_models
                })
            })
        }

        const showModal = () => {
            this.setState({
                isModalOpen: true
            })
        };

        const handleOk = () => {
            this.setState({
                isModalOpen: false
            })
        };

        const handleCancel = () => {
            this.setState({
                isModalOpen: false
            })
        };

        const onChange = () => {

        };

        return(
            <>

                <Modal title="权限模型" open={this.props.isModalOpen} onOk={() => this.props.closeModal()} onCancel={() => this.props.closeModal()}>
                    <Tabs defaultActiveKey="1" items={items} onChange={onChange} />
                </Modal>
            </>
        )

    }

    private getAceEditor = () => {
        // @ts-ignore
        return <AceEditor
            placeholder="输入Groovy脚本"
            mode="java"
            theme="github"
            name="blah2"
            fontSize={16}
            showPrintMargin={false}
            showGutter={true}
            highlightActiveLine={true}
            value={JSON.stringify(this.state.modalString, null, 2)}
            setOptions={{
                enableBasicAutocompletion: true,
                enableLiveAutocompletion: true,
                enableSnippets: true,
                showLineNumbers: true,
                tabSize: 2,
            }}
        />;
    }

    private getShowModal() {
        return (
            this.isEmptyObject(this.state.modalString) ? <Loading/> :
                <JSONTree data={this.state.modalString}
                ></JSONTree>
        )
    }
}

export default App;
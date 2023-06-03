import React from "react";
import AceEditor from "react-ace";
import "ace-builds/src-noconflict/mode-java";
import "ace-builds/src-noconflict/theme-github";
import "ace-builds/src-noconflict/ext-language_tools";
import { Button, Input, Space } from "antd";
import {getScript, updatePolicy} from "@/request/api";
import {showMessage} from "@/components/Setting";

interface AppProps {}

interface AppState {
    code: string;
    result: string
}

class App extends React.Component<AppProps, AppState> {
    constructor(props: AppProps) {
        super(props);
        this.state = {
            code: "",
            result: ""
        };
    }

    handleChange = (newCode: string) => {

        this.setState({
            code: newCode as string,
        });
        console.log(this.state.code)
    };

    updateScript =() => {
        updatePolicy({script: this.state.code}).then(res => {
            if (res.msg === "success") {
                showMessage("success", "运行成功")
                this.setState({
                    result: res.data
                })
            } else {
                showMessage("error", res.msg)
            }
        })
    }



    onLoad = () => {};


    render() {
        if (this.state.code === "") {
            getScript().then(res => {
                this.setState({
                    code: res.data
                })
            })
        }
        const getAceEditor = () => {
            // @ts-ignore
            return <AceEditor
                placeholder="输入Groovy脚本"
                mode="java"
                theme="github"
                name="blah2"
                onLoad={this.onLoad}
                onChange={this.handleChange}
                fontSize={16}
                showPrintMargin={false}
                showGutter={true}
                highlightActiveLine={true}
                value={this.state.code}
                setOptions={{
                    enableBasicAutocompletion: true,
                    enableLiveAutocompletion: true,
                    enableSnippets: true,
                    showLineNumbers: true,
                    tabSize: 2,
                }}
            />;
        }

// @ts-ignore
        return (
            <Space direction="vertical" size="middle" style={{ display: 'flex' , alignItems: "center"}}>
                {getAceEditor.call(this)}
                {"运行结果"}<Input placeholder="运行结果" bordered={false} value={this.state.result}/>

                <Button type="primary" onClick={this.updateScript}>提交</Button>
            </Space>
        );
    }
}

// @ts-ignore
export default App;
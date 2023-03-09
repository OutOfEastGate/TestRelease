import MarkdownEditor from "@uiw/react-markdown-editor";
import { useState } from "react";
import "./styles.css";

const updateValue = (val:string) => {
    console.log(val)
}

export default function App() {
    const code = `# title\n\nHello World!\n\n`;
    const [markdownVal, setMarkdownVal] = useState(code);
    console.log("markdownVal:", markdownVal);
    return (
        <div>
            <div className="App" data-color-mode="light">
                <MarkdownEditor
                    value={markdownVal}
                    onChange={(value) => {
                        updateValue(value)
                        setMarkdownVal(value);
                    }}
                />
            </div>
        </div>
    );
}
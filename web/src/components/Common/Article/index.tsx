import React from 'react';
import {Card} from "antd";
import AllArticles from "@/components/Common/Article/AllArticles";

const App: React.FC = () => (
    <div>
        <Card title="" bordered={false}>
            <AllArticles></AllArticles>
        </Card>
    </div>
);

export default App;

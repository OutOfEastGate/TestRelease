import React from 'react';
import RotationChat from './RotationChart'
import IntroduceText from "@/components/Common/HomePage/IntroduceText";
import { ProForm, ProFormText } from '@ant-design/pro-components';
import {Card} from "antd";

const App: React.FC = () => (
    <div>
        <Card title="" bordered={false} style={{ width: 1300 }}>
            <IntroduceText></IntroduceText>
        </Card>

    </div>
);

export default App;

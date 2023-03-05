import React from 'react';
import RotationChat from './RotationChart'
import { ProForm, ProFormText } from '@ant-design/pro-components';

const App: React.FC = () => (
    <div>
        <ProForm
            onFinish={async (values) => {
                console.log(values);
            }}
        >
            <ProFormText name="name" label="姓名" />
        </ProForm>
        <RotationChat></RotationChat>
    </div>
);

export default App;

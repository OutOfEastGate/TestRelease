import { Calendar, theme } from 'antd';
import type { Dayjs } from 'dayjs';
import React from 'react';

interface ChildComponentProps {
    day: string;
    onDayChange: (newDay: string) => void;
}
const App: React.FC<ChildComponentProps> = ({day, onDayChange}) => {
    const { token } = theme.useToken();

    const wrapperStyle: React.CSSProperties = {
        width: 300,
        border: `1px solid ${token.colorBorderSecondary}`,
        borderRadius: token.borderRadiusLG,
    };
    const onPanelChange = (value: Dayjs) => {
        onDayChange(value.format('YYYY-MM-DD'))
    };
    return (
        <div style={wrapperStyle}>
            <Calendar fullscreen={false} onChange={onPanelChange} />
        </div>
    );
};

export default App;
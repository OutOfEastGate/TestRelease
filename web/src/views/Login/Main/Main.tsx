import React, { ChangeEvent, useState, useMemo} from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input, notification } from 'antd';
import type { NotificationPlacement } from 'antd/es/notification/interface';
import { loginAPI,getCasdoorLoginUrlAPI } from '@/request/api';
const Context = React.createContext({ name: 'Default' });

const LoginMain: React.FC = () => {
  const [api, contextHolder] = notification.useNotification();
  const openNotification = (placement: NotificationPlacement) => {
    api.info({
      message: `登录失败`,
      description: <Context.Consumer>{({ name }) => `账号或密码错误`}</Context.Consumer>,
      placement,
    });
  };

  const openYesification = (placement: NotificationPlacement) => {
    api.info({
      message: `登录成功`,
      placement,
    });
  };

  const onFinish = (values: any) => {
    console.log('Received values of form: ', values);
  };

  //获取用户输入的用户名
  const [usernameVal,setUsernameVal] = useState("")
  const usernameChange = (e:ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setUsernameVal(e.target.value)//修改usernameVal变量
  }

  //获取用户输入的密码
  const [passwordVal,setPasswordVal] = useState("")
  const passwordChange = (e:ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setPasswordVal(e.target.value)//修改usernameVal变量
  }

  //点击登录
  const gotoLogin = () => {
    loginAPI({userName:usernameVal,userPassword:passwordVal}).then((res)=>{
      if(res.success === false) {
        openNotification('topLeft')
      }else if(res.data.token && res.data.userId) {
        localStorage.setItem("token",res.data.token)
        localStorage.setItem("userId",res.data.userId)
        openYesification('topLeft')
        window.location.href = "/home"
      } 
    })
  }

  const casdoorLogin = () => {
    getCasdoorLoginUrlAPI({origin:window.location.origin}).then((res)=>{
      window.location.href = res.data
    })
  }


  const contextValue = useMemo(() => ({ name: 'Ant Design' }), []);

  return (
    <Context.Provider value={contextValue}>
      {contextHolder}
      <Form
      name="normal_login"
      className="login-form"
      initialValues={{ remember: true }}
      onFinish={onFinish}
    >
      <Form.Item
        name="username"
        rules={[{ required: true, message: 'Please input your Username!' }]}
      >
        <Input 
          prefix={<UserOutlined className="site-form-item-icon" />} 
          placeholder="Username"
          onChange={usernameChange} />
      </Form.Item>
      <Form.Item
        name="password"
        rules={[{ required: true, message: 'Please input your Password!' }]}
      >
        <Input
          prefix={<LockOutlined className="site-form-item-icon" />}
          type="password"
          placeholder="Password"
          onChange={passwordChange}
        />
      </Form.Item>
      <Form.Item>
        <Form.Item name="remember" valuePropName="checked" noStyle>
          <Checkbox>Remember me</Checkbox>
        </Form.Item>

        <a className="login-form-forgot" href="">
          Forgot password
        </a>
      </Form.Item>

      <Form.Item>
        <Button type="primary" htmlType="submit" className="login-form-button" onClick={gotoLogin}>
          Log in
        </Button>
        Or    
        <Button type="primary" onClick={casdoorLogin}>
          Casdoor Login
        </Button>
      </Form.Item>
    </Form>
    </Context.Provider>
  );
};

export default LoginMain;
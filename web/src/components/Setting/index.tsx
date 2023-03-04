import { message } from 'antd';

const [messageApi] = message.useMessage();

export function showMessage(type:string, text:string)  {
    if (type === "success") {
        messageApi.success(text);
      } else if (type === "error") {
        messageApi.error(text);
      } else if (type === "info") {
        messageApi.info(text);
      }
  };

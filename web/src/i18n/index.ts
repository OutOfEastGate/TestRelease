import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import en from '../locales/en/data.json';
import zh from '../locales/zh/data.json';

// 定义需要支持的语言类型
const resources = {
    en: en,
    zh: zh,
};

i18n
    .use(initReactI18next)
    .init({
        lng: localStorage.getItem("lang") === "zh" ? "zh" : "en",  // 默认语言
        resources: resources,
        fallbackLng: "en",  // 当所选语言未在 resources 中定义时，使用该语言
        interpolation: {escapeValue: false},

    }).then();

export default i18n;

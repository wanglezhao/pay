package com.guweibit.pay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092400584305";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZ6RPyZXvy2DQkFlRGE7r6y++zKzMmNg7smLbrw8fHnic3MNaGQxe0ULId82bb3hnyhNtN8WaPAYq9Iiu7EtHDxp6witA8BYVU45+zDMIKoHqP48fPOnOlhzV3/5jh5qXYXfF67gbxAgMUcesu/2kNc62Fh/KoEiQDzpQnqhhVKmHVmAXUV902FsPS9KQoi8CFU9udaRnYl49VmIIFb5RG551jypaIZph51YcQEEHcrstabAmOw9eo9qxpodlws7SsEHLYx1518fBYopNYK+akHUuoBKo97JzbS+o92gle/izt1/rGDg5ZKypBq5PsHiaZ/c0Z+Wvyof605JBvodx9AgMBAAECggEBAI29CjOWphk0ZoA9WArZLL6+hNaZmBc+fWwCD6L7v8XjrfWzsjwfGXtjPUU73KPq3DZth5E2GN7l6qDXETLM2ATVq1ql27MK2okcvvujaidjNrvAZ0g+ajYsWF9UMbUINf8WNMai4h2dXry7VH0JlfNfbpOkaSHC4wvmeKY2jQYP/dhT/EDWNPWe/VueDhIV0TtN6gpwi/1drXHWIoh+Bj1sF4qUT30bm2uhztogqQgbEL71ttcX0RN6fJUEyzLi14LJ3grRVvmNHu8oqP1HgPcRVj4BTtop+z/lYQ6cYG7PBaou4GUVHmRIdZOWydNXY5uEHAK18hfmXNvUcjj2NkECgYEA0DEbcOZLNH7mw8Xbc8ZKZSvp0g3fdzbQLktd9mAOBLGjlSPg3qFzFhyBN1IKG5+YQm6hFOQMJWZjPP5uoW2jCsILFEkRUFe/XNnJJ0YFQsa3blA4AN80ifPn9wrKWlq8PPX06DJMHTDM5HfDZx0haKk5uhaiLLW70WJmUPBTdWkCgYEAvUDz+RaoLxVAFr3KaiEAm1nTNRY/6erWmDnL1kvWcuufyIdkyyULT6NEz3vbQu8vheJKISQrgDqJHoqOkwfMcIJkT40xua4ZXJ2wEMYqAcW4RAKr8B1EWO8S2IUDHZDT7sIxqu/lhexNkdL7hPdcz6Qpv5fs+TncNLoyHEBzp/UCgYBvODzDpJO6mKypG5MwF1d5EuuXxseBxWuTv7mTvB7hDREpxIAGD1QPFO1G43H47dqGatls8qM2e6s6U2ZAoPR/88e9b4drV2UoskQO0g5PbR9jNEGm3ZcQt5dNV5tgh6aWHoNWZEBbO83Jo91kwaAubHElY6ABqJiMtDeat7iuOQKBgG3Nqb/zrVDj+3M2WqKI01lPHIPIjPyjDC72GZYUGjBDFUm7hHd43r8t81aOfgCv1drQGEJyQer8C2J08ZPNCoicnqapPRiGMqDRvL1+vBCbLvYGtstxr54J191YDx6wUMZOVZLf7UNufvMEfnn/KxIuJSrMcumG8ISHI1vQ6UmhAoGBAL5Vrvoj6PO6L0SNP3PHPhrUvCAaOoCEe6s9CA7pnTK3hDjm/9rD9EjucXYraqI0ELgOanJ4i5OePnNIH1lKnBbpqP6v6salWwV3x82IKHLiqCM5rLX5AKtpN5aYymzIBJQ8zX5ZOsQkI7SCMyrxSTgjmsp2dcJlYMiZtwEakXAt";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvurY8gbnOZ9K/E+2cbITfg3n0/pMFBFoTWEytuKILa90Hn7/8UQBnE42s0+JOdZ1o3QYiGewb6vZScVeCP7Q1MkiaIMR7qBhZAJwzT9ZUqUi1JBtDM+BUwppvZoIRW7mGwWxZPEHP1N+CjFIDsczk+p8LgG00gaRsmaWYNI2qbWlacGonTecwgCra80DzK901OqXIT+/aFv6pbP+t4rMAxBoATusY8rwFVohFA3Z5MofDOjfGpzchQzFQtEoJ8euc9aJWZQUS0oT/FN869AUOth9b5Q8Hpc75LEqNbqRfDDEKoBe+mFLcby5kab2sf2FzR8NgDoJ5tNEiZs7FiX9aQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://fmjkaa.natappfree.cc/alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://fmjkaa.natappfree.cc/alipay/pay/return_url.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


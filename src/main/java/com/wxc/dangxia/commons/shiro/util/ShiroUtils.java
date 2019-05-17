package com.wxc.dangxia.commons.shiro.util;

import com.wxc.dangxia.entity.Employee;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Shiro加密
 *
 * @author Dadazhao
 * @date 2018/12/22
 */
public class ShiroUtils {


    /**
     * 传入字符串和盐值 返回加密的字符串
     * @param str 需要加密的字符串
     * @param salt 盐值
     * @return 加密字符串
     */
    /*public static String getEncryptionStr (String str,String salt){

        //获得加密方式
        String hashAlgorithmName = hashedCredentialsMatcher.getHashAlgorithmName();

        //加密次数
        int hashIterations = hashedCredentialsMatcher.getHashIterations();

        String encryStr = new SimpleHash(hashAlgorithmName, str, salt, hashIterations).toString();
        return encryStr;
    }*/

    /**
     * Emplyee加密
     * @param emp
     * @return
     */
    public static void encryption(Employee emp) {
        //加密方式
        String hashAlgorithmName = "MD5";
        //加密次数
        int hashIterations = 101;
        //从对象获得密码
        String empPassword = emp.getEmpPassword();
        //加密的盐值
        String salt = UUID.randomUUID().toString();
        //加密后的字符串
        String encryStr = new SimpleHash(hashAlgorithmName, empPassword,salt, hashIterations).toString();
        //加密的盐值存入对象
        emp.setEmpPassword(encryStr);
        //emp.setEmpSalt(salt);
    }


    /**
     * \传入字符串 加密次数 和盐值 返回加密的字符串
     * @param str 需要加密的字符串
     * @param salt 盐值
     * @param iter 加密次数
     * @return 加密后的字符串
     */
    public static String getEncryptionStr (String str,String salt,int iter){
        String encryStr = new SimpleHash("MD5", str, salt, iter).toString();
        return encryStr;
    }
}

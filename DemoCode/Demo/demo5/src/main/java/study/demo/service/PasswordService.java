package study.demo.service;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@PropertySource("classpath:application.yml")
@Service
public class PasswordService {
	
	@Value("${password.type}")
	String type;
	
	public String encrypt(@NonNull String str){
		switch(type.intern()) {
		case "base64":
			return encodeByBase64(str);
		case "Hex":
			return encodeByHex(str);
		default:
			return str;
		}
	}
	
	public String decrypt(@NonNull String str){
		switch(type.intern()) {
		case "base64":
			return decodeByBase64(str);
		case "Hex":
			return decodeByHex(str);
		default:
			return str;
		}
	}
	
	public String encodeByBase64(@NonNull String str) {
		return Base64.encodeToString(str.getBytes());
	}
	
	public String decodeByBase64(@NonNull String str) {
		return Base64.decodeToString(str.getBytes());
	}
	
	public String encodeByHex(@NonNull String str) {
		return Hex.encodeToString(str.getBytes());
	}
	
	public String decodeByHex(@NonNull String str) {
		return new String(Hex.decode(str));
	}
	
	
	public static void main(String[] args) {
		String password = "123456";
		String encode;
		
		PasswordService passwordService = new PasswordService();
		System.out.println("原密码:"+password);
		
		System.out.println();
		System.out.println("base64:");
		encode = passwordService.encodeByBase64(password);
		System.out.println("加密:"+encode);
		System.out.println("解密:"+passwordService.decodeByBase64(encode));
		
		System.out.println();
		System.out.println("Hex:");
		encode = passwordService.encodeByHex(password);
		System.out.println("加密:"+encode);
		System.out.println("解密:"+passwordService.decodeByHex(encode));
	}

}

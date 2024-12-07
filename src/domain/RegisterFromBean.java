package domain;

import java.util.HashMap;

public class RegisterFromBean {
    private String username;
    private String password;
    private String confirmPassword;
    private String phoneNumber;

    private final HashMap<String, String> errors = new HashMap<>();

    public RegisterFromBean(){}
    public RegisterFromBean(String username, String password, String confirmPassword, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public HashMap<String, String> getErrors() {
        return errors;
    }

    public boolean validate() {
        boolean flag = true;
        if (username == null || username.isEmpty()) {
            errors.put("username", "请输入用户名");
            this.username = "";
            flag = false;
        }
        if (password == null || password.isEmpty()) {
            errors.put("password", "请输入密码");
            this.password = "";
            flag = false;
        }
        else if (password.length() < 6) {
            errors.put("password", "密码长度不能小于6位");
            this.password = "";
            flag = false;
        }
        assert confirmPassword != null;
        if (!password.equals(confirmPassword)) {
            errors.put("confirmPassword", "两次输入的密码不一致");
            this.confirmPassword = "";
            flag = false;
        }
        assert phoneNumber != null;
        if(phoneNumber.length() != 11) {
            errors.put("phoneNumber", "请输入11位手机号");
            this.phoneNumber = "";
            flag = false;
        }
        return flag;
    }

}



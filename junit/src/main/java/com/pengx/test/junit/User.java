package com.pengx.test.junit;

/**
 * @author PengXin
 */
public class User {

    private String userId;
    private int sex;
    private String phone;
    private int age;

    public User(String userId, int sex, String phone, int age) {
        this.userId = userId;
        this.sex = sex;
        this.phone = phone;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexString() {
        if (sex == 1) {
            return "男";
        } else if (sex == 2) {
            return "女";
        }
        return "未知";
    }
}

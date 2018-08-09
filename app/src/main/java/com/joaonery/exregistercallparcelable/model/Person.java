package com.joaonery.exregistercallparcelable.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.joaonery.exregistercallparcelable.R;

public class Person implements Parcelable{

    private String login;
    private String password;
    private Context context;

    public Person(Context context) {
        this.context = context;
    }

    public Person(String login, String password, Context context) {
        if(login.equalsIgnoreCase("adm1") && password.equalsIgnoreCase("adm1")){
            this.login = login;
            this.password = password;
            this.context = context;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.password);
    }

    protected Person(Parcel in) {
        this.login = in.readString();
        this.password = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  context.getResources().getString(R.string.la_et_login) + ": " + login + "\n" +
                context.getResources().getString(R.string.la_et_password) + ": " + password;
    }
}
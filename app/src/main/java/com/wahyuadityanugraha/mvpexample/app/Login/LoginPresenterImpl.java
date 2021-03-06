/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wahyuadityanugraha.mvpexample.app.login;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginFunction loginFunction;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginFunction loginFunction) {
        this.loginFunction = loginFunction;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override public void validateCredentials(String username, String password) {
        loginFunction.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override public void onUsernameError() {
        loginFunction.setUsernameError();
        loginFunction.hideProgress();
    }

    @Override public void onPasswordError() {
        loginFunction.setPasswordError();
        loginFunction.hideProgress();
    }

    @Override public void onSuccess() {
        loginFunction.navigateToHome();
    }
}

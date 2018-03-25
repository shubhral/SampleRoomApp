package com.shubhral.myfirstmvvp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Shubhral on 3/26/2018.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface GithubApplicationScope {
}

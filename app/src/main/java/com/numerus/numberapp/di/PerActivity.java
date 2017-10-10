package com.numerus.numberapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by kiran.kumar on 10/10/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}

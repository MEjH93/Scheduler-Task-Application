package com.scheduler.schedulertask.service.impl;
import groovy.lang.GroovyShell ;
import groovy.lang.GroovyClassLoader ;
import groovy.util.GroovyScriptEngine ;
import java.io.File ;

class Runner {
    static void runWithGroovyShell() throws Exception {
        new GroovyShell().parse( new File( "test.groovy" ) ).invokeMethod( "hello_world", null ) ;
    }

    static void runWithGroovyClassLoader() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyClassLoader().parseClass( new File( "test.groovy" ) ) ;
        Object scriptInstance = scriptClass.newInstance() ;
        scriptClass.getDeclaredMethod( "hello_world", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    }

    static void runWithGroovyScriptEngine() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyScriptEngine( "." ).loadScriptByName( "test.groovy" ) ;
        Object scriptInstance = scriptClass.newInstance() ;
        scriptClass.getDeclaredMethod( "hello_world", new Class[] {} ).invoke( scriptInstance, new Object[] {} ) ;
    }

    public static void main( String[] args ) throws Exception {
        runWithGroovyShell() ;
        runWithGroovyClassLoader() ;
        runWithGroovyScriptEngine() ;
    }

}

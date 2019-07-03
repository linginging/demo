#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Properties;
import java.util.Set;


/**
 * @author : sue.s.li
 * @Date : 2018-12-28
 * @Time : 16:07
 */
public class YzwCommentGenerator implements CommentGenerator {
    /**
     * 添加注解
     *
     * @param properties 配置
     */
    @Override
    public void addConfigurationProperties(Properties properties) {

    }

    /**
     * 添加注解
     *
     * @param field              字段属性
     * @param introspectedTable  表
     * @param introspectedColumn 列
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("${symbol_escape}n", " "));
        field.addJavaDocLine(" */");
    }

    /**
     * 添加注解
     *
     * @param field             字段属性
     * @param introspectedTable 表
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加注解
     *
     * @param topLevelClass     t
     * @param introspectedTable t
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加注解
     *
     * @param innerClass        cls
     * @param introspectedTable 表
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加注解
     *
     * @param innerClass        cls
     * @param introspectedTable 表
     * @param b                 标识
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {

    }

    /**
     * 添加注解
     *
     * @param innerEnum         枚举
     * @param introspectedTable 表
     */
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加注解
     *
     * @param method             方法
     * @param introspectedTable  表
     * @param introspectedColumn 列
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    /**
     * 添加注解
     *
     * @param method             方法
     * @param introspectedTable  表
     * @param introspectedColumn 列
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    /**
     * 添加注解
     *
     * @param method            方法
     * @param introspectedTable 表
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加注解
     *
     * @param compilationUnit 字段
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    /**
     * 添加注解
     *
     * @param xmlElement t
     */
    @Override
    public void addComment(XmlElement xmlElement) {

    }

    /**
     * 添加注解
     *
     * @param xmlElement t
     */
    @Override
    public void addRootComment(XmlElement xmlElement) {

    }

    /**
     * 添加注解
     *
     * @param method            方法
     * @param introspectedTable 表格
     * @param set               set
     */
    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加注解
     *
     * @param method             方法
     * @param introspectedTable  表
     * @param introspectedColumn 注解
     * @param set                set
     */
    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加注解
     *
     * @param field             字段
     * @param introspectedTable 表
     * @param set               set
     */
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加注解
     *
     * @param field              字段
     * @param introspectedTable  表
     * @param introspectedColumn 列
     * @param set                set
     */
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加注解
     *
     * @param innerClass        cls
     * @param introspectedTable 表
     * @param set               set
     */
    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }
}

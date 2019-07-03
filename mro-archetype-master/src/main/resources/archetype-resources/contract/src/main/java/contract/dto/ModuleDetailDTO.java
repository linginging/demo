#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract.dto;

import lombok.Data;

import java.util.Date;

/**
 * 模块信息
 *
 * @author : joy.x.wei
 * @Data : 2018/11/19
 * @Time : 3:38 PM
 */
@Data
public class ModuleDetailDTO {
    /**
     * Id
     */
    private Integer id;
    /**
     * 模块code
     */
    private String module;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 模块版本号
     */
    private String moduleVersion;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 变更记录
     */
    private String changes;
    /**
     * 文件路径
     */
    private String files;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;
}
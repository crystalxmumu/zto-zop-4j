package top.todev.express.zto.api.config.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.todev.express.zto.api.bean.ZopHostConfig;
import top.todev.express.zto.api.config.IZopConfigStorage;

import java.io.Serializable;

/**
 * 中通开放平台配置内存实现类
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZopConfigStorageMemoryImpl implements IZopConfigStorage, Serializable {

    private static final long serialVersionUID = -8948109336517112098L;

    /** 合作商编号 */
    private volatile String companyId;
    /** 合作商密钥 */
    private volatile String companyKey;
    /** Api路径配置类 */
    private volatile ZopHostConfig zopHostConfig;


}
